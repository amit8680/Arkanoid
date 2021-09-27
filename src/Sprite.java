import biuoop.DrawSurface;

/**
 * @author Amit Lavi
 */
public interface Sprite {
    /**
     * Draw on.
     *
     * @param d the d
     */
    void drawOn(DrawSurface d);

    /**
     * Time passed.
     */
    void timePassed();
}
