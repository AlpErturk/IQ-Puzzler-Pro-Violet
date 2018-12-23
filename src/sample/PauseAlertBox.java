package sample;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import javax.swing.text.html.ImageView;
import java.io.IOException;


public class PauseAlertBox {


    ImageView replayView, nextView;

    public void display() throws IOException {

    }

    public void replayButtonHandle() throws IOException {
        /*Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);*/

        Game game = Game.getInstance();
        //game.nextLevel();
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


    public void nextLevelButtonHandle() throws IOException {

        Game game = Game.getInstance();
        game.nextLevel();
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


    public void exitButtonHandle() throws IOException {
        Platform.exit();
    }


}
