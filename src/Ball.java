import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Amit lavi
 */
public class Ball implements Sprite {
    private Point location;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private Paddle paddle;
    private GameEnvironment gameE;

    /**
     * Instantiates a new Ball.
     *
     * @param center the center
     * @param r      the r
     * @param color  the color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.location = center;
        this.r = r;
        this.color = color;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param x     the x
     * @param y     the y
     * @param r     the r
     * @param color the color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        Point newCenter = new Point(x, y);
        this.location = newCenter;
        this.r = r;
        this.color = color;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param x     the x
     * @param y     the y
     * @param r     the r
     * @param color the color
     * @param gameE the game e
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment gameE) {
        Point newCenter = new Point(x, y);
        this.location = newCenter;
        this.r = r;
        this.color = color;
        this.gameE = gameE;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return (int) this.location.getX();
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return (int) this.location.getY();
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * draw the ball on screen.
     *
     * @param surface surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }


    /**
     * Sets velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        Velocity v1 = new Velocity(dx, dy);
        this.v = v1;
    }
    /**
     * Sets velocity.
     *
     * @param v1 the dx
     */
    public void setVelocity(Velocity v1) {
        this.v = v1;
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * Move the ball every time by his velocity and next collision points.
     */
    public void moveOneStep() {
        Point nextPoint = new Point(this.location.getX() + this.v.getDx(),
                this.location.getY() + this.v.getDy());
        //creat line between the ball and his next move
        Line traject = new Line(this.location, nextPoint);
        //get the closet colliosion info for the ball for the next move
        CollisionInfo info = this.gameE.getClosestCollision(traject);
        //if the line doesnt crush anything next time keep moving same way
        if (info == null) {
            //if there is no colliosion point keep moving same way
            this.location = this.getVelocity().applyToPoint(this.location);
        } else {
            //move the ball while he hit something considering the collision point
            if (this.v.getDx() > 0 && this.v.getDy() > 0) {
                this.location = new Point(info.collisionPoint().getX() - 0.5,
                        info.collisionPoint().getY() - 0.5);
            } else if (this.v.getDx() > 0 && this.v.getDy() < 0) {
                this.location = new Point(info.collisionPoint().getX() - 0.5,
                        info.collisionPoint().getY() + 0.5);
            } else if (this.v.getDx() < 0 && this.v.getDy() < 0) {
                this.location = new Point(info.collisionPoint().getX() + 0.5,
                        info.collisionPoint().getY() + 0.5);
            } else {
                this.location = new Point(info.collisionPoint().getX() + 0.5,
                        info.collisionPoint().getY() - 0.5);
            }
            //set the new velocity of the ball
            this.v = info.collisionObject().hit(this, info.collisionPoint(), this.v);
        }
    }

    /**
     * Add to game.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Sets paddle.
     *
     * @param p the p
     */
    public void setPaddle(Paddle p) {
        this.paddle = p;
    }
    /**
     * remove the ball from the game.
     *
     * @param g the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

}

