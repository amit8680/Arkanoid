/**
 * @author Amit Lavi
 */
public class CollisionInfo {
    private Point collisonPoint;
    private Collidable collidable;

    /**
     * Instantiates a new Collision info.
     *
     * @param collisonPoint the collison point
     * @param collidable    the collidable
     */
    public  CollisionInfo(Point collisonPoint, Collidable collidable) {
        this.collisonPoint = collisonPoint;
        this.collidable = collidable;
    }

    /**
     * Collision point point.
     *
     * @return the point
     */
    public Point collisionPoint() {
        return this.collisonPoint;
    }

    /**
     * Collision object collidable.
     *
     * @return the collidable
     */
    public Collidable collisionObject() {
        return this.collidable;
    }

}
