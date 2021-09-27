import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amit Lavi
 */
public class Ass6Game {
    /**
     * The main of the game.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI("GameLevel", 800, 600);
        AnimationRunner ar = new AnimationRunner(gui);
        GameFlow gf = new GameFlow(ar, gui.getKeyboardSensor());
        List<LevelInformation> levelsInfo = new ArrayList<>();

        //if there is no args start with levels 1,2,3,4
        if (args.length == 0) {
            levelsInfo.add(new DirectHIt());
            levelsInfo.add(new WideEasy());
            levelsInfo.add(new Green3());
            levelsInfo.add(new FinalFour());
        } else {
            //take the correct args with 1,2,3,4 and add this levels to the game.
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    levelsInfo.add(new DirectHIt());
                } else if (args[i].equals("2")) {
                    levelsInfo.add(new WideEasy());
                } else if (args[i].equals("3")) {
                    levelsInfo.add(new Green3());
                } else if (args[i].equals("4")) {
                    levelsInfo.add(new FinalFour());
                }
            }
        }
        gf.runLevels(levelsInfo);
    }
}
