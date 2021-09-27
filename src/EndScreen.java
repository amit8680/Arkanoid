import java.awt.Color;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type End screen.
 *
 * @author Amit Lavi
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private int score;
    private boolean isWin;
    private boolean shouldStop;

    /**
     * Instantiates a new End screen.
     *
     * @param keyboard keyboard
     * @param score    the score
     * @param isWin    if the player win or lose the game
     */
    public EndScreen(KeyboardSensor keyboard, int score, boolean isWin) {
        this.keyboard = keyboard;
        this.score = score;
        this.isWin = isWin;
        this.shouldStop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.RED);
        if (this.isWin) {
            // if the player win
            d.drawText(270, d.getHeight() / 2, "You Win! Your score is " + this.score, 32);
        } else {
            //if the player lose
            d.drawText(270, d.getHeight() / 2, "Game Over. Your score is " + this.score, 32);
        }
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.shouldStop = true;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }

}
