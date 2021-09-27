import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type Paddle.
 *
 * @author Amit Lavi
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rec;
    private int speed;

    /**
     * Instantiates a new Paddle.
     *
     * @param k   the keyboardsensor.
     * @param rec the rec.
     */
    public Paddle(KeyboardSensor k, Rectangle rec) {
        this.rec = rec;
        this.keyboard = k;
    }

    /**
     * Sets speed.
     *
     * @param speed1 the speed
     */
    public void setSpeed(int speed1) {
        this.speed = speed1;
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            if (this.rec.getUpperLeft().getX() > 30) {
                this.rec.setUpperLeft(new Point(this.rec.getUpperLeft().getX() - this.speed,
                        this.rec.getUpperLeft().getY()));
            }
        }
    }

    /**
     * Move right.
     */
    public void moveRight() {
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            if (this.rec.getUpperLeft().getX() < 770 - this.rec.getWidth()) {
                this.rec.setUpperLeft(new Point(this.rec.getUpperLeft().getX() + this.speed,
                        this.rec.getUpperLeft().getY()));
            }
        }
    }

    /**
     * Move right.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        } else if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
    }

    /**
     * @param d surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.ORANGE);
        d.fillRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());

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
     * @param ball            the ball that hit this paddle
     * @return v the new velocity
     */
    public Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity) {
        double div = this.rec.getWidth() / 5;
        double speed1 = Math.sqrt(currentVelocity.getDx() * currentVelocity.getDx()
                + currentVelocity.getDy() * currentVelocity.getDy());
        Velocity v;
        //we will divide the paddle to 5 part that every one will return different velocity
        if (collisionPoint.getX() >= this.rec.getUpperLeft().getX() && collisionPoint.getX()
                <= this.rec.getUpperLeft().getX() + div) {
            v = Velocity.fromAngleAndSpeed(300, speed1);
        } else if (collisionPoint.getX() >= this.rec.getUpperLeft().getX() + 1 * div && collisionPoint.getX()
                < this.rec.getUpperLeft().getX() + 2 * div) {
            v = Velocity.fromAngleAndSpeed(330, speed1);
        } else if (collisionPoint.getX() >= this.rec.getUpperLeft().getX() + 2 * div && collisionPoint.getX()
                < this.rec.getUpperLeft().getX() + 3 * div) {
            v = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        } else if (collisionPoint.getX() >= this.rec.getUpperLeft().getX() + 3 * div && collisionPoint.getX()
                < this.rec.getUpperLeft().getX() + 4 * div) {
            v = Velocity.fromAngleAndSpeed(30, speed1);
        } else if (collisionPoint.getX() >= this.rec.getUpperLeft().getX() + 4 * div && collisionPoint.getX()
                < this.rec.getUpperLeft().getX() + 5 * div) {
            v = Velocity.fromAngleAndSpeed(60, speed1);
        } else {
            v = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        return v;
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}