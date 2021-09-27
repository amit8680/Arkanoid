import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 *
 * @author Amit Lavi
 */
public class KeyPressStoppableAnimation implements Animation {
    private Animation animation;
    private KeyboardSensor keyboard;
    private boolean shouldStop;
    private String key;
    private boolean isAlreadyPressed;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.animation = animation;
        this.key = key;
        this.isAlreadyPressed = false;
        this.shouldStop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboard.isPressed(key)) {
            if (!this.isAlreadyPressed) {
                this.shouldStop = true;
                this.isAlreadyPressed = true;
            }
        }

    }

    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }


}