package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class NewGameController {


    ImageView twoD, backImage;


    public void backButtonHandle() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

    public void twoDHandle() throws IOException {
        //GamePlayController controller = new GamePlayController();

        //Parent root = FXMLLoader.load(getClass().getResource("GamePlayController.fxml"));
       // Stage m = Main.getMainStage();
        //Scene t = Main.getMainStage().getScene();
        //t.setRoot(root);
        //Scene f = new Scene(controller.asParent(),400,400);
      //  m.setScene(f);
       // Main.setMainStage(m);

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

    public void threeDCheckBoxHandle() throws IOException {

    }

}
