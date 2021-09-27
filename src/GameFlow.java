import java.util.List;
import biuoop.KeyboardSensor;

/**
 * The type Game flow.
 *
 * @author Amit Lavi
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private ScoreIndicator sc;
    private LivesIndicator lc;
    private KeyPressStoppableAnimation kpsa;

    /**
     * Instantiates a new Game flow and set indicators.
     *
     * @param ar the ar
     * @param ks the ks
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.sc = new ScoreIndicator(new Counter(0));
        this.lc = new LivesIndicator(new Counter(7));
    }

    /**
     * Run the levels we get from main.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.ks, this.ar, this.sc, this.lc);
            level.initialize();
            while (level.isLive() && level.isBlocks()) {
                level.playOneTurn();
            }
            if (this.lc.getLives().getValue() == 0) {
                this.kpsa = new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                        new EndScreen(this.ks, this.sc.getScore().getValue(), false));
                this.ar.run(this.kpsa);
                this.ar.getGui().close();
                break;
            }
        }
        this.kpsa = new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                new EndScreen(this.ks, this.sc.getScore().getValue(), true));
        this.ar.run(this.kpsa);
        this.ar.getGui().close();
    }
}