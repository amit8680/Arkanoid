import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Lavi
 */
public class WideEasy implements LevelInformation {
    private BackGround bg;
    private int numberOfBalls;
    private List<Velocity> velocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Wide easy.
     */
    public WideEasy() {
        this.numberOfBalls = 10;
        this.velocities = new ArrayList<>();
        this.paddleSpeed = 5;
        this.paddleWidth = 500;
        this.levelName = "WideEasy";
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 10;
        this.bg = new BackGround();


    }

    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < this.numberOfBalls; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(225 + i * 30, 3);
            this.velocities.add(v);
        }
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

        for (int i = 0; i < 40; i++) {
            this.bg.addCirecle(new Point(156, 150), i, Color.yellow);
        }
        for (int i = 40; i < 45; i++) {
            this.bg.addCirecle(new Point(156, 150), i, Color.orange);
        }
        for (int i = 45; i < 50; i++) {
            this.bg.addCirecle(new Point(156, 150), i, Color.yellow);
        }
        for (int i = 0; i < 694; i = i + 5) {
            this.bg.addLine(new Line(156, 150, i, 250), Color.yellow);
        }

        this.bg.addBackColor(Color.white);
        return this.bg;

    }

    @Override
    public List<Block> blocks() {
        int width = 30;
        for (int i = 0; i < 2; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, 250), 74, 32), Color.red));
            width += 74;
        }
        for (int i = 2; i < 4; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, 250), 74, 32), Color.orange));
            width += 74;
        }
        for (int i = 4; i < 6; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, 250), 74, 32), Color.yellow));
            width += 74;
        }
        for (int i = 6; i < 8; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, 250), 74, 32), Color.green));
            width += 74;
        }
        for (int i = 8; i < 10; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, 250), 74, 32), Color.pink));
            width += 74;
        }
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}
