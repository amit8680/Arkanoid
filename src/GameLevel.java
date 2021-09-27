import java.awt.Color;
import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

/**
 * The type GameLevel.
 *
 * @author Amit Lavi
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blockCounter;
    private Counter ballCounter;
    private ScoreIndicator scoreIndicator;
    private ScoreTrackingListener scoreCounter;
    private Counter counter;
    private Counter numberOfLives;
    private LivesIndicator livescore;
    private Paddle p;
    private KeyboardSensor keyboard;
    private LevelInformation li;


    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void doOneFrame(DrawSurface d) {

        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.ballCounter.getValue() == 0) {
            this.removeSprite(this.p);
            this.removeCollidable(this.p);
            this.decreaseLive();
            this.running = false;
        }
        if (this.blockCounter.getValue() == 0) {
            this.counter.increase(100);
            this.running = false;
        }
        //pause screen
        if (this.keyboard.isPressed("p")) {
            KeyPressStoppableAnimation ks = new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen());
            this.runner.run(ks);
        }
    }

    /**
     * Instantiates a new GameLevel.
     *
     * @param li all the information about the level.
     * @param ks KeyboardSensor.
     * @param ar AnimationRunner.
     * @param sc score indicator.
     * @param lc live in the game indicator.
     */
    public GameLevel(LevelInformation li, KeyboardSensor ks, AnimationRunner ar
            , ScoreIndicator sc, LivesIndicator lc) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.running = true;
        this.runner = ar;
        this.keyboard = ks;
        this.li = li;
        this.scoreIndicator = sc;
        this.livescore = lc;
        this.numberOfLives = lc.getLives();

    }

    /**
     * Add collidable.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Add sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Initialize all the things in the game.
     */
    public void initialize() {
        //this.gui = new GUI("GameLevel", 800, 600);
        this.addSprite(this.li.getBackground());
        Block top = new Block(new Rectangle(new Point(0, 0), 800, 30), Color.gray);
        Block bottom = new Block(new Rectangle(new Point(0, 600), 800, 30), Color.gray);
        Block left = new Block(new Rectangle(new Point(0, 0), 30, 600), Color.gray);
        Block right = new Block(new Rectangle(new Point(770, 0), 30, 600), Color.gray);
        top.addToGame(this);
        bottom.addToGame(this);
        left.addToGame(this);
        right.addToGame(this);
        this.environment.addCollidable(top);
        this.environment.addCollidable(bottom);
        this.environment.addCollidable(right);
        this.environment.addCollidable(left);
        this.blockCounter = new Counter(0);
        BlockRemover br = new BlockRemover(this, this.blockCounter);
        this.ballCounter = new Counter(0);
        BallRemover ballr = new BallRemover(this, this.ballCounter);
        bottom.addHitListener(ballr);
        this.counter = this.scoreIndicator.getScore();
        this.scoreCounter = new ScoreTrackingListener(this.counter);
        this.numberOfLives = this.livescore.getLives();
        this.addSprite(this.scoreIndicator);
        this.addSprite(this.livescore);
        Sprite s = new NameIndicator(this.li.levelName());
        this.addSprite(s);
        for (Block block : this.li.blocks()) {
            block.addToGame(this);
            block.setHits(1);
            block.addHitListener(br);
            block.addHitListener(this.scoreCounter);
            this.blockCounter.increase(1);
        }
    }

    /**
     * play turn of the game, the turn end when all balls die or all blocks die.
     */
    public void playOneTurn() {

        for (int i = 0; i < this.li.numberOfBalls(); i++) {
            Ball ball = new Ball(400, 455, 5, Color.white, this.environment);
            ball.setVelocity(this.li.initialBallVelocities().get(i));
            ball.addToGame(this);
            this.ballCounter.increase(1);
            ball.setPaddle(this.p);
        }
        this.p = new Paddle(this.keyboard, new Rectangle(new Point(400 - (int) (this.li.paddleWidth() / 2), 550)
                , this.li.paddleWidth(), 20));
        this.p.setSpeed(this.li.paddleSpeed());
        this.p.addToGame(this);
        this.runner.run(new CountdownAnimation(2.0, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * Run the game untill you lose all your lives.
     */
    public void run() {
        while (this.numberOfLives.getValue() > 0) {
            this.playOneTurn();
            this.numberOfLives.decrease(1);
        }
        //gui.close();
    }

    /**
     * Decrease  1 live.
     */
    public void decreaseLive() {
        this.numberOfLives.decrease(1);
    }

    /**
     * check if we still got blocks in the game.
     *
     * @return true or false.
     */
    public boolean isBlocks() {
        if (this.blockCounter.getValue() > 0) {
            return true;
        }
        return false;
    }

    /**
     * check if we still got blocks in the game.
     *
     * @return true or false.
     */
    public boolean isLive() {
        if (this.numberOfLives.getValue() > 0) {
            return true;
        }
        return false;
    }
}
