package sample;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import javax.annotation.processing.Generated;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class PauseAlertBox {



    @FXML
    ImageView replayView, nextView, starView;
    Game game  = Game.getInstance();


    @FXML
    public void initialize(){
        int score = game.twoDLevels[game.getCurrent2DLevel() - 1].getHighScore();

        if(score >= 30)
            starView.setImage(new Image("file:images/menu/threeStar.png"));
        else if(score >= 20)
            starView.setImage(new Image("file:images/menu/twoStar.png"));
    }

    public void display() throws IOException {

    }

    public void replayButtonHandle() throws IOException {
        Game.setInstance(game);
        game.replayLevel();

        Stage primaryStage = Main.getMainStage();
        AdditionModel modelFirst = new AdditionModel();
        AdditionController controllerFirst = new AdditionController(modelFirst);
        AdditionView viewFirst = new AdditionView(controllerFirst, modelFirst);

        Scene scene = new Scene(viewFirst.asParent(), 1500, 1000);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
        Main.setMainStage(primaryStage);
    }

    public void calculateScore() throws IOException {

    }

    public void nextLevelButtonHandle() throws IOException {

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
