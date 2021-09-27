import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Lavi
 */
public class FinalFour implements LevelInformation {
    private BackGround bg;
    private int numberOfBalls;
    private List<Velocity> velocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Final four.
     */
    public FinalFour() {
        this.numberOfBalls = 2;
        this.velocities = new ArrayList<>();
        this.paddleSpeed = 5;
        this.paddleWidth = 100;
        this.levelName = "Final Four";
        this.blocks = new ArrayList<>();
        this.numberOfBlocksToRemove = 105;
        this.bg = new BackGround();


    }

    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < this.numberOfBalls; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(35, 3);
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
        for (int i = 1; i < 26; i++) {
            this.bg.addCirecle(new Point(120, 420), i, Color.gray.brighter());
        }
        for (int i = 1; i < 33; i++) {
            this.bg.addCirecle(new Point(140, 450), i, Color.gray.brighter());
        }
        for (int i = 1; i < 33; i++) {
            this.bg.addCirecle(new Point(160, 420), i, Color.gray);
        }
        for (int i = 1; i < 25; i++) {
            this.bg.addCirecle(new Point(180, 450), i, Color.gray);
        }
        for (int i = 1; i < 36; i++) {
            this.bg.addCirecle(new Point(200, 420), i, Color.gray);
        }
        for (int i = 0; i < 10; i++) {
            this.bg.addLine(new Line(130 + 10 * i, 450, 120 + 10 * i, 600), Color.white);
        }
        for (int i = 1; i < 26; i++) {
            this.bg.addCirecle(new Point(520, 500), i, Color.gray.brighter());
        }
        for (int i = 1; i < 33; i++) {
            this.bg.addCirecle(new Point(540, 530), i, Color.gray.brighter());
        }
        for (int i = 1; i < 33; i++) {
            this.bg.addCirecle(new Point(560, 500), i, Color.gray);
        }
        for (int i = 1; i < 25; i++) {
            this.bg.addCirecle(new Point(580, 530), i, Color.gray);
        }
        for (int i = 1; i < 36; i++) {
            this.bg.addCirecle(new Point(600, 500), i, Color.gray);
        }
        for (int i = 0; i < 10; i++) {
            this.bg.addLine(new Line(530 + 10 * i, 530, 520 + 10 * i, 600), Color.white);
        }
        this.bg.addBackColor(Color.cyan.darker());
        return this.bg;

    }


    @Override
    public List<Block> blocks() {
        int width = 30;
        int height = 120;

        for (int i = 0; i < 10; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, height), 74, 32), Color.gray));
            width += 74;
        }
        height += 32;
        width = 30;
        for (int i = 0; i < 10; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, height), 74, 32), Color.RED));
            width += 74;
        }
        height += 32;
        width = 30;
        for (int i = 0; i < 10; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, height), 74, 32), Color.YELLOW));
            width += 74;
        }
        height += 32;
        width = 30;
        for (int i = 0; i < 10; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, height), 74, 32), Color.GREEN));
            width += 74;
        }
        height += 32;
        width = 30;
        for (int i = 0; i < 10; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, height), 74, 32), Color.WHITE));
            width += 74;
        }
        height += 32;
        width = 30;
        for (int i = 0; i < 10; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, height), 74, 32), Color.PINK));
            width += 74;
        }
        height += 32;
        width = 30;
        for (int i = 0; i < 10; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(width, height), 74, 32), Color.white));
            width += 74;
        }


        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}
