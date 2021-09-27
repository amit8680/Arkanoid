//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Lavi
 */
public class GameEnvironment {
    private List<Collidable> list = new ArrayList<Collidable>();

    /**
     * Add collidable.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        this.list.add(c);
    }
    /**
     * remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.list.remove(c);
    }


    /**
     * Gets closest collision.
     *
     * @param trajectory the trajectory
     * @return the collisioninfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo cInfo;
        boolean check = false;
        Collidable c;
        Rectangle rec;
        Point closesPoint;
        int i = 0;
        //looking for collision
        while (i < this.list.size() && !check) {
            rec = this.list.get(i).getCollisionRectangle();
            if (trajectory.closestIntersectionToStartOfLine(rec) != null) {
                check = true;
                //if we find we want to return his index so we will get the i even with increase befor end loop
                i--;
            }
            i++;
        }
        //if we doesnt find any collision return null
        if (!check) {
            cInfo = null;
            return cInfo;
        }
        //now we looking for cloesr point
        c = this.list.get(i);
        rec = this.list.get(i).getCollisionRectangle();
        closesPoint = trajectory.closestIntersectionToStartOfLine(rec);
        i++;
        while (i < this.list.size()) {
            Rectangle recCheck = this.list.get(i).getCollisionRectangle();
            Point pointCheck = trajectory.closestIntersectionToStartOfLine(recCheck);
            if (pointCheck == null) {
                i++;
            } else {
                if (trajectory.start().distance(pointCheck) < trajectory.start().distance(closesPoint)) {
                    c = this.list.get(i);
                    closesPoint = pointCheck;

                }
                i++;
            }
        }
        //finally we return the point and the shape of hte hit
        cInfo = new CollisionInfo(closesPoint, c);
        return cInfo;
    }
}
