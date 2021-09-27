import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Name indicator.
 *
 * @author Amit Lavi
 */
public class NameIndicator implements Sprite {
    private String levelName;

    /**
     * Instantiates a new Name indicator.
     *
     * @param levelName the level name
     */
    public NameIndicator(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.red);
        d.drawText(80, 27, "Level Name:" + this.levelName, 20);
    }
    @Override
    public void timePassed() {

    }
}
