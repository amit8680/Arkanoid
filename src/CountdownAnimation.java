import biuoop.DrawSurface;
import biuoop.Sleeper;

/**
 * The type Animation runner.
 *
 * @author Amit Lavi
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Boolean stop;

    private long timmer;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.timmer = (long) (1000 * numOfSeconds / countFrom);
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        this.gameScreen.drawAllOn(d);
        d.drawText(270, d.getHeight() / 2, "play in:" + this.countFrom, 100);
        sleeper.sleepFor(this.timmer);
        this.countFrom--;
        if (this.countFrom < 0) {
            this.stop = true;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}

