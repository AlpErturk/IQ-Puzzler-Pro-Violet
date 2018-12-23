package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;

import java.io.IOException;


public class GamePlayScreenController {

    public Button Pause;

    public void handlePauseButton() throws IOException {

        PauseAlertBox alertBox = new PauseAlertBox();
        alertBox.display();
    }
}
