import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * The type Block.
 *
 * @author Amit Lavi
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rec;
    private int hits;
    private Color c;
    private List<HitListener> hitListeners;


    /**
     * Gets hit points.
     *
     * @return the hit points
     */
    public int getHitPoints() {
        return this.hits;
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
    /**
     * notify all the listeners about the hit.
     * @param hitter the ball the hit the object.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Remove from gameLevel.
     *
     * @param gameLevel the gameLevel
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * Instantiates a new Block.
     *
     * @param rec   the rec
     * @param color the color
     */
    public Block(Rectangle rec, java.awt.Color color) {
        this.rec = rec;
        this.c = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * @return rec
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }

    /**
     * @param collisionPoint  the point of collision
     * @param currentVelocity velocity of the ball right befor hit
     * @param hitter the ball that hit the block
     * @return v the new velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.hits--;
        this.notifyHit(hitter);
        //change the counter of hits in the block
        Point rightDown = new Point(this.rec.getUpperLeft().getX() + this.rec.getWidth(),
                this.rec.getUpperLeft().getY() + this.rec.getHeight());
        double dx, dy;
        Velocity v = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        //when we hit the side of block
        if (this.rec.getUpperLeft().getY() == collisionPoint.getY()
                || rightDown.getY() == collisionPoint.getY()) {
            dx = currentVelocity.getDx();
            dy = -currentVelocity.getDy();
            v = new Velocity(dx, dy);
            //when we hit top of block
        } else if (this.rec.getUpperLeft().getX() == collisionPoint.getX()
                || rightDown.getX() == collisionPoint.getX()) {
            dx = -currentVelocity.getDx();
            dy = currentVelocity.getDy();
            v = new Velocity(dx, dy);
        }

        return v;
    }

    /**
     * The type Block.
     */
    public void timePassed() {
    }

    /**
     * draw the block on screen.
     *
     * @param d surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.c);
        d.fillRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
    }

    /**
     * Add the block to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }


    /**
     * Sets color.
     *
     * @param col the col
     */
    public void setColor(Color col) {
        this.c = col;
    }

    /**
     * Sets hits.
     *
     * @param hit the hit
     */
    public void setHits(int hit) {
        this.hits = hit;
    }
}