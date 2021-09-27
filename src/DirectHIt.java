import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Lavi
 */
public class DirectHIt implements LevelInformation {
    private BackGround bg;
    private int numberOfBalls;
    private List<Velocity> velocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new level named Direct hit.
     */
    public DirectHIt() {
        this.numberOfBalls = 1;
        this.velocities = new ArrayList<>();
        this.paddleSpeed = 5;
        this.paddleWidth = 100;
        this.levelName = "Direct HIt";
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 1;
        this.bg = new BackGround();


    }

    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        Velocity v = Velocity.fromAngleAndSpeed(180, -4);
        this.velocities.add(v);
        return this.velocities;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public Sprite getBackground() {
        this.bg.addCirecle(new Point(400, 160), 50, Color.BLUE.darker());
        this.bg.addCirecle(new Point(400, 160), 75, Color.BLUE.darker());
        this.bg.addCirecle(new Point(400, 160), 100, Color.BLUE.darker());
        this.bg.addLine(new Line(280, 160, 530, 160), Color.BLUE.darker());
        this.bg.addLine(new Line(400, 40, 400, 280), Color.BLUE.darker());
        this.bg.addBackColor(Color.black);
        return this.bg;

    }

    @Override
    public List<Block> blocks() {
        this.blocks.add(new Block((new Rectangle(new Point(380, 140), 40, 40)), Color.RED));
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}
