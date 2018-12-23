package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import jfxtras.labs.util.event.MouseControlUtil;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GamePlayController implements Initializable {

    final int xTopLeft = 0;
    final int yTopLeft = -495;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        Game game = Game.getInstance();
        Board board = new Board(game.levelOne.getLevelMatrix());

        Stage primaryStage = new Stage();
        //Pane panel = new Pane();
        //Button button = new Button("tria");

        //panel.getChildren().addAll(button);

        //Scene scenel = new Scene(panel);
        //primaryStage.setScene(scenel);
        //primaryStage.show(); //BUNU COMMENTLEDIM BI HATA COZULDU HABERINIZ OLSUN

        BorderPane backgroundPane = new BorderPane();
        GridPane boardPane = new GridPane();
        HBox menuPane = new HBox();
        menuPane.setMinSize(150,150);
        menuPane.setMaxSize(150, 150);
        Button pauseButton = new Button("Pause");
        Button ege = new Button("Ege");
        Label menuLabel = new Label("MENU");

        pauseButton.setAlignment(Pos.BOTTOM_CENTER);

        menuPane.getChildren().addAll(menuLabel);
        menuPane.getChildren().addAll(ege);
        menuPane.getChildren().addAll(pauseButton);

        String styleMenu = "-fx-background-color: rgba(80,58,37,0);";
        menuPane.setStyle(styleMenu);

        // use it's predefined content pane as pieceBox pane
        Pane pieceBox = new Pane();
        pieceBox.setMaxSize(600, 600);

        ImageView pieceView = game.pieceTen.getCurrentImage();
        ImageView piece2View = game.pieceEleven.getCurrentImage();
        ImageView piece3View = game.pieceTwelve.getCurrentImage();

        MouseControlUtil.makeDraggable(pieceView);
        pieceBox.getChildren().add(pieceView);

        MouseControlUtil.makeDraggable(piece2View);
        pieceBox.getChildren().add(piece2View);

        MouseControlUtil.makeDraggable(piece3View);
        pieceBox.getChildren().add(piece3View);

        pieceView.setLayoutX(40);
        pieceView.setLayoutY(10);

        piece2View.setLayoutX(280);
        piece2View.setLayoutY(10);

        piece3View.setLayoutX(570);
        piece3View.setLayoutY(10);

//----------------------------------------------------------------------------------------------------------------------

        //BOARD MATRIXI INITIALIZE EDILIYOR VE BIR MATRIX XPOSITIONLARI TUTUYOR BIR MATRIX YPOSITIONLARI TUTUYOR
        //BIR MATRIX TUM BOARD ENTRYLERININ BOS OLUP OLMADIGINI TUTUYOR

        //Boardun constructorinda initialize edilecek
        //int xTopLeft = 0;
       // int yTopLeft = 150;

        double [][]XboardMatrix = new double[5][11];
        double [][]YboardMatrix = new double[5][11];

        int [][] isFull = game.levelOne.getLevelMatrix();


        for(int i = 0; i < 5; i++) {
            for(int j =0; j < 11; j++) {
                XboardMatrix[i][j] = xTopLeft + (72)*j;
                YboardMatrix[i][j] = yTopLeft + (72 * i);
            }
        }

//--------------------------------------------------------------------------------------------------

        //MOUSE RELEASED EVENT HANDLER
        //This code calculates the position of piece
        EventHandler handler = new EventHandler() {
            @Override
            public void handle(Event event){

                //System.out.println("X: " +pieceView.getLayoutX());
                //System.out.println("Y: " +pieceView.getLayoutY());

                if(board.checkPieceBoundary(pieceView, 40, 10)) {
                    board.putPiece(game.pieceTen, XboardMatrix, YboardMatrix, 40, 10);
                }

                if(board.checkPieceBoundary(piece2View, 280, 10))
                    board.putPiece(game.pieceEleven, XboardMatrix, YboardMatrix, 300,10);

                if(board.checkPieceBoundary(piece3View, 570, 10))
                    board.putPiece(game.pieceTwelve, XboardMatrix, YboardMatrix, 600,10);

            }
        };

//--------------------------------------------------------------------------------------------------

        //Finding the coordinates of mouse clicking
//        backgroundPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                System.out.println(event.getX());
//                System.out.println(event.getY());
//            }
//        });

//--------------------------------------------------------------------------------------------------

        //ADDING EVENTHANDLER TO PIECES
        game.pieceTen.getCurrentImage().addEventHandler(MouseEvent.MOUSE_RELEASED, handler);
        game.pieceEleven.getCurrentImage().addEventHandler(MouseEvent.MOUSE_RELEASED, handler);
        game.pieceTwelve.getCurrentImage().addEventHandler(MouseEvent.MOUSE_RELEASED, handler);

//--------------------------------------------------------------------------------------------------

        //SETTING THE PANE
        //board.getBoardView().setFitHeight(400);
        //board.getBoardView().setFitWidth(800);
        board.getBoardView().setLayoutX(300);
        board.getBoardView().setLayoutY(300);

        pieceBox.setMaxSize(300, 300);
        pieceBox.setMinSize(300,300);

        String style = "-fx-background-color: rgba(241, 235, 174, 0.8);";
        backgroundPane.setStyle(style);
        boardPane.getChildren().addAll(board.getBoardView());
        backgroundPane.setCenter(boardPane);
        backgroundPane.setBottom(pieceBox);
        backgroundPane.setTop(menuPane);

//--------------------------------------------------------------------------------------------------

        // add the scalable pane to the scene
        Scene scene = new Scene(backgroundPane, 775, 1000);

        // setup the stage
        primaryStage.setTitle("IQ PUZZLER PRO");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

    }

}
