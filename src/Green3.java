import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Green 3.
 *
 * @author Amit Lavi
 */
public class Green3 implements LevelInformation {
    private BackGround bg;
    private int numberOfBalls;
    private List<Velocity> velocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Green 3.
     */
    public Green3() {
        this.numberOfBalls = 2;
        this.velocities = new ArrayList<>();
        this.paddleSpeed = 5;
        this.paddleWidth = 100;
        this.levelName = "Green 3";
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 40;
        this.bg = new BackGround();


    }

    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < this.numberOfBalls; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(45, 3);
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
        this.bg.addRec(new Rectangle(new Point(80, 400), 150, 200), Color.darkGray);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                this.bg.addRec(new Rectangle(new Point(60 + 25 * (i + 1), 380 + 40 * (j + 1))
                        , 12, 30), Color.white);
            }
        }
        this.bg.addRec(new Rectangle(new Point(130, 340), 50, 60), Color.darkGray.brighter());
        this.bg.addRec(new Rectangle(new Point(145, 150), 20, 190), Color.gray);
        for (int i = 1; i <= 5; i++) {
            this.bg.addCirecle(new Point(155, 135), i, Color.white);
        }
        for (int i = 6; i <= 10; i++) {
            this.bg.addCirecle(new Point(155, 135), i, Color.red.brighter());
        }
        for (int i = 11; i <= 15; i++) {
            this.bg.addCirecle(new Point(155, 135), i, Color.yellow);
        }
        this.bg.addBackColor(Color.green.darker());
        return this.bg;

    }

    @Override
    public List<Block> blocks() {
        int width = 40;
        int height = 220;
        List<Block> blockList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            blockList.add(
                    new Block(new Rectangle(new Point(770 - 40 * (i + 1), height), width, width), Color.gray));
        }
        int i = 10;
        height += 40;
        for (int j = 0; j < 9; j++) {
            blockList.add(
                    new Block(new Rectangle(new Point(770 - 40 * (j + 1), height), width, width), Color.red));
            i++;
        }
        height += 40;
        for (int j = 0; j < 8; j++) {
            blockList.add(
                    new Block(new Rectangle(new Point(770 - 40 * (j + 1), height), width, width), Color.yellow));
            i++;
        }
        height += 40;
        for (int j = 0; j < 7; j++) {
            blockList.add(
                    new Block(new Rectangle(new Point(770 - 40 * (j + 1), height), width, width), Color.blue));
            i++;
        }
        height += 40;
        for (int j = 0; j < 6; j++) {
            blockList.add(
                    new Block(new Rectangle(new Point(770 - 40 * (j + 1), height), width, width), Color.white));
            i++;
        }

        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}
