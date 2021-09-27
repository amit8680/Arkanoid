import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Lives indicator.
 *
 * @author Amit Lavi
 */
public class LivesIndicator implements Sprite {
    private Counter numberOfLives;

    /**
     * Instantiates a new Lives indicator.
     *
     * @param lives the lives
     */
    public LivesIndicator(Counter lives) {
        this.numberOfLives = lives;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.red);
        d.drawText(660, 27, "live: " + this.numberOfLives.getValue(), 20);

    }

    @Override
    public void timePassed() {

    }

    /**
     * Get lives counter.
     *
     * @return the counter
     */
    public Counter getLives() {
        return this.numberOfLives;
    }
}
