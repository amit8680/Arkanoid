import biuoop.DrawSurface;

/**
 *
 * @author Amit Lavi
 */
public class PauseScreen implements Animation {
    //private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Instantiates a new Pause screen.
     */
    public PauseScreen() {
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        //if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }
    @Override
    public boolean shouldStop() { return this.stop; }
}