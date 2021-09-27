/**
 * The type Ball remover.
 *
 * @author Amit lavi
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter availabeBalls;

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        this.availabeBalls.decrease(1);

    }

    /**
     * Instantiates a new Ball remover.
     *
     * @param gameLevel          the gameLevel.
     * @param availabeBalls the availabe balls.
     */
    public BallRemover(GameLevel gameLevel, Counter availabeBalls) {
        this.gameLevel = gameLevel;
        this.availabeBalls = availabeBalls;
    }
}
