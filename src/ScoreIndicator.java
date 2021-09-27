import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Score indicator.
 *
 * @author Amit Lavi
 */
public class ScoreIndicator implements Sprite {
    private Counter score;


    /**
     * Instantiates a new Score indicator.
     *
     * @param c the c
     */
    public ScoreIndicator(Counter c) {
        this.score = c;

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.red);
        d.drawText(330, 27, "Score: " + this.score.getValue(), 20);

    }

    @Override
    public void timePassed() {

    }

    /**
     * Get score counter.
     *
     * @return the counter
     */
    public Counter getScore() {
        return this.score;
    }

}
