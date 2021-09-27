import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * @author Amit Lavi
 */
public class SpriteCollection {
    private List<Sprite> list = new ArrayList<>();

    /**
     * Add sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        this.list.add(s);
    }
    /**
     * remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.list.remove(s);
    }


    /**
     * Notify all time passed.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i) != null) {
                this.list.get(i).timePassed();
            }
        }
    }

    /**
     * Draw all on.
     *
     * @param d the d
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i) != null) {
                this.list.get(i).drawOn(d);
            }
        }
    }
}
