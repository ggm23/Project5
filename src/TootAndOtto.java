import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.text.Text;

/**
 * This class is a game called Toot and Otto.
 *
 * @author Grace Moran
 */

public class TootAndOtto extends Application {

  public GridPane generateGameBoard(int width, int height) throws Exception {
    if (width % 4 != 0 || height % 4 != 0) {
      throw new Exception("Game dimensions entered must be divisible by 4");
    }
    GridPane grid = new GridPane();
    for (int i = 0; i < width && i < height; i++) {
      for (int j = 0; j < width && j < height; j++) {
        grid.add(new Button(), i, j);
      }
    }

    Text scoreText = new Text("Player T Score:" + "Player O Score:");

    grid.addRow(0);
    grid.add(scoreText, height + 1, width + 1);

    return grid;
  }

  /**
   * Start method that sets the stage for the game
   *
   * @param primaryStage Stage
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Toot and Otto");
    List<String> args = getParameters().getRaw();
    GridPane grid = generateGameBoard(6, 6);
    List scoreBoard = grid.getChildren().filtered(i -> i.getId().equals("score"));

    Scene scene = new Scene(grid, 130, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Run the application
   *
   * @param args the command line arguments create the game
   */
  public static void main(String[] args) {
    Application.launch(args);
  }

}