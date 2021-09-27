import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Lavi
 */
public class BackGround implements Sprite {
    //we will keep the shapes in the background in list and their colors in match list.
    private List<Rectangle> rectangles = new ArrayList<>();
    private List<Color> rectanglesColor = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();
    private List<Color> linesColor = new ArrayList<>();
    private List<Point> circlesCenter = new ArrayList<>();
    private List<Color> circlesColor = new ArrayList<>();
    private List<Integer> circlesSize = new ArrayList<>();
    private Color backColor;

    /**
     * Add rec.
     *
     * @param rec   the rec
     * @param color the color
     */
    public void addRec(Rectangle rec, Color color) {
        this.rectangles.add(rec);
        this.rectanglesColor.add(color);
    }

    /**
     * Add line.
     *
     * @param line  the line
     * @param color the color
     */
    public void addLine(Line line, Color color) {
        this.lines.add(line);
        this.linesColor.add(color);
    }

    /**
     * Add cirecle.
     *
     * @param center the center
     * @param size   the size
     * @param color  the color
     */
    public void addCirecle(Point center, int size, Color color) {
        this.circlesCenter.add(center);
        this.circlesSize.add(size);
        this.circlesColor.add(color);
    }

    /**
     * Add back color.
     *
     * @param color the color
     */
    public void addBackColor(Color color) {
        this.backColor = color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.backColor);
        d.fillRectangle(0, 0, 800, 600);
        for (int i = 0; i < this.rectangles.size(); i++) {
            d.setColor(this.rectanglesColor.get(i));
            d.fillRectangle((int) this.rectangles.get(i).getUpperLeft().getX(),
                    (int) this.rectangles.get(i).getUpperLeft().getY(),
                    (int) this.rectangles.get(i).getWidth(), (int) this.rectangles.get(i).getHeight());
        }
        for (int i = 0; i < this.lines.size(); i++) {
            d.setColor(this.linesColor.get(i));
            d.drawLine((int) this.lines.get(i).start().getX(), (int) this.lines.get(i).start().getY(),
                    (int) this.lines.get(i).end().getX(), (int) this.lines.get(i).end().getY());
        }
        for (int i = 0; i < circlesSize.size(); i++) {
            d.setColor(this.circlesColor.get(i));
            d.drawCircle((int) this.circlesCenter.get(i).getX(),
                    (int) this.circlesCenter.get(i).getY(), this.circlesSize.get(i));
        }

    }

    /**
     * Time passed.
     */
    public void timePassed() {

    }

}
