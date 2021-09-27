import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Lavi
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

    }

    /**
     * Intersection points java . util . list.
     *
     * @param line the line
     * @return the java . util . list
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new  ArrayList<>();
        Point rightUpp = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Point leftDown =  new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point rightDown = new Point(this.upperLeft.getX() + this.width,
                this.upperLeft.getY() +  this.height);
        //creat lines for every side of the rec
        Line line1 = new Line(rightUpp, this.upperLeft);
        Line line2 = new Line(rightUpp, rightDown);
        Line line3 = new Line(this.upperLeft, leftDown);
        Line line4 = new Line(rightDown, leftDown);
        //find intersection of line with every side of the rec
        if (line.isIntersecting(line1)) {
            intersectionPoints.add(line.intersectionWith(line1));
        }
        if (line.isIntersecting(line2)) {
            intersectionPoints.add(line.intersectionWith(line2));
        }
        if (line.isIntersecting(line3)) {
            intersectionPoints.add(line.intersectionWith(line3));
        }
        if (line.isIntersecting(line4)) {
            intersectionPoints.add(line.intersectionWith(line4));
        }
        return intersectionPoints;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left.
     *
     * @return the upper left
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Sets upper left.
     *
     * @param p the p
     */
    public void setUpperLeft(Point p) {
        this.upperLeft = p;
    }




}
