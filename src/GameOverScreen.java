package sample;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class GameOverScreen {

    ImageView replayView;
    ImageView exitView;
    Game game;


    public void exitButtonHandle() throws IOException {
        Platform.exit();

    }


    public void replayButtonHandle() throws IOException {
        Game game = Game.getInstance();
        game.replayLevel();
        Game.setInstance(game);

        Stage primaryStage = Main.getMainStage();

        AdditionModel model = new AdditionModel();
        AdditionController controller = new AdditionController(model);
        AdditionView view = new AdditionView(controller, model);

        Scene scene = new Scene(view.asParent(), 1500, 1000);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
        Main.setMainStage(primaryStage);
    }


}
