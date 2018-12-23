package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.AdditionController;
import sample.AdditionModel;
import sample.AdditionView;
import sample.Main;

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
