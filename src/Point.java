/**
 * The type Point.
 *
 * @author Amit Lavi
 */
public class Point {
    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x - x.
     * @param y - y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * return distance between two points.
     *
     * @param other - point.
     * @return distance. double
     */
    public double distance(Point other) {
        double distance = ((this.x - other.x) * (this.x - other.x))
                + ((this.y - other.y) * (this.y - other.y));

        return Math.sqrt(distance);
    }

    /**
     * check if this point equal to another one.
     *
     * @param other - point.
     * @return true or false.
     */
    public boolean equals(Point other) {
        return (this.getX() == other.getX() && this.getY() == other.getY());
    }


    /**
     * Gets x.
     *
     * @return x of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return y of the point.
     */
    public double getY() {
        return this.y;
    }
}
