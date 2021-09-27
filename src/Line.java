import java.util.List;

/**
 * @author Amit Lavi
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Instantiates a new Line.
     *
     * @param start the start
     * @param end   the end
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Instantiates a new Line.
     *
     * @param x1 the x 1
     * @param y1 the y 1
     * @param x2 the x 2
     * @param y2 the y 2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * Start point.
     *
     * @return the point
     */
    public Point start() {
        return this.start;
    }


    /**
     * Middle point.
     *
     * @return the point
     */
    public Point middle() {
        double middleX = (this.start.getX() + this.end.getX()) / 2.0;
        double middleY = (this.start.getY() + this.end.getY()) / 2.0;
        return new Point(middleX, middleY);
    }

    /**
     * End point.
     *
     * @return the point
     */
    public Point end() {
        return this.end;
    }

    /**
     * Length double.
     *
     * @return the double
     */
    public double length() {
        return (Math.sqrt((this.start.getX() - this.end.getX()) + (this.start.getY() - this.end.getY())));
    }

    /**
     * Is intersecting boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

    /**
     * Intersection with point.
     *
     * @param other the other
     * @return the point
     */
    public Point intersectionWith(Line other) {
        Point p1 = this.start();
        Point p2 = this.end();
        Point p3 = other.start();
        Point p4 = other.end();
        double denominator = (p4.getY() - p3.getY()) * (p2.getX() - p1.getX())
                - (p4.getX() - p3.getX()) * (p2.getY() - p1.getY());
        if (denominator != 0.0) {
            double ua = ((p4.getX() - p3.getX()) * (p1.getY() - p3.getY())
                    - (p4.getY() - p3.getY()) * (p1.getX() - p3.getX())) / denominator;
            if (ua >= 0.0 && ua <= 1.0) {
                double ub = ((p2.getX() - p1.getX()) * (p1.getY() - p3.getY())
                        - (p2.getY() - p1.getY()) * (p1.getX() - p3.getX())) / denominator;
                if (ub >= 0.0 && ub <= 1.0) {
                    int x = (int) (p1.getX() + ua * (p2.getX() - p1.getX()));
                    int y = (int) (p1.getY() + ua * (p2.getY() - p1.getY()));
                    return new Point((double) x, (double) y);
                }
            }
        }

        return null;
    }


    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(Line other) {
        if ((this.start.equals(other.start) && (this.end.equals(other.end)))
                || ((this.start.equals(other.end)) && (this.end.equals(other.start)))) {
            return true;
        }
        return false;
    }

    /**
     * Closest intersection to start of line point.
     *
     * @param rect the rect
     * @return the point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        if (intersectionPoints.isEmpty()) {
            return null;
        }
        Point closestPoint = intersectionPoints.get(0);
        double x = this.start.distance(closestPoint);
        for (int i = 1; i < intersectionPoints.size(); i++) {
            if (x > start.distance(intersectionPoints.get(i))) {
                closestPoint = intersectionPoints.get(i);
            }
        }
        return closestPoint;
    }
}