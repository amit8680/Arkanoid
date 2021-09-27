import biuoop.DrawSurface;

/**
 * @author Amit Lavi
 */
public interface Animation {
    /**
     * Do one frame.
     *
     * @param d the d
     */
    void doOneFrame(DrawSurface d);

    /**
     * decide if the frame should stop or keep running.
     *
     * @return true or false.
     */
    boolean shouldStop();
}
