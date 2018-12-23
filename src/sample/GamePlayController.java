package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import jfxtras.labs.util.event.MouseControlUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GamePlayController implements Initializable {
    Game game;


    @Override
    public void initialize(URL location, ResourceBundle resources){

        Game game = Game.getInstance();
        Board board = new Board(game.levelOne.getLevelMatrix());


        Stage primaryStage = new Stage();
        Pane panel = new Pane();
        Button button = new Button("tria");

        panel.getChildren().addAll(button);

        Scene scenel = new Scene(panel);
        primaryStage.setScene(scenel);
        primaryStage.show();

        BorderPane backgroundPane = new BorderPane();
        GridPane boardPane = new GridPane();
        HBox menuPane = new HBox();
        menuPane.setMinSize(150,150);
        menuPane.setMaxSize(150, 150);
        Button pauseButton = new Button("Pause");
        menuPane.getChildren().addAll(pauseButton);
        // use it's predefined content pane as pieceBox pane
        Pane pieceBox = new Pane();
        pieceBox.setMaxSize(600, 600);

        //Adding board images, and pieces
        Image piece = new Image("file:/Users/safaaskin/IdeaProjects/Deneme/images/piece10.png");
        Image piece2 = new Image("file:/Users/safaaskin/IdeaProjects/Deneme/images/piece11.png");

        ImageView pieceView= new ImageView(piece);
        ImageView piece2View = new ImageView(piece2);


/*        pieceView.setFitHeight(66.36);
        pieceView.setFitWidth(66.36);
        piece2View.setFitHeight(66.36);
        piece2View.setFitWidth(66.36);
        */

        MouseControlUtil.makeDraggable(pieceView);
        pieceBox.getChildren().add(pieceView);

        MouseControlUtil.makeDraggable(piece2View);
        pieceBox.getChildren().add(piece2View);

        pieceView.setLayoutX(40);
        pieceView.setLayoutY(40);
        piece2View.setLayoutX(100);
        piece2View.setLayoutY(40);


//----------------------------------------------------------------------------------------------------------------------

        //BOARD MATRIXI INITIALIZE EDILIYOR VE BIR MATRIX XPOSITIONLARI TUTUYOR BIR MATRIX YPOSITIONLARI TUTUYOR
        //BIR MATRIX TUM BOARD ENTRYLERININ BOS OLUP OLMADIGINI TUTUYOR

        //Boardun constructorinda initialize edilecek
        int xTopLeft = 40;
        int yTopLeft = -468;

        double [][]XboardMatrix = new double[5][11];
        double [][]YboardMatrix = new double[5][11];

        int [][] isFull = game.levelOne.getLevelMatrix();


        for(int i = 0; i < 5; i++) {
            for(int j =0; j < 11; j++) {
                XboardMatrix[i][j] = xTopLeft + (66.36)*j;
                YboardMatrix[i][j] = yTopLeft + (66.36)*i;
            }
        }

        //Piece classinda release count olacak
        int pieceCount = 2;
        int [] pieceDragCounter = new int [pieceCount]; // We have 2 pieces for now

//--------------------------------------------------------------------------------------------------

        //MOUSE RELEASED EVENT HANDLER
        //This code calculates the position of piece
        EventHandler handler = new EventHandler() {
            @Override
            public void handle(Event event) {

                //if(event.getSource())



                System.out.println("X: " +pieceView.getLayoutX());
                System.out.println("Y: " +pieceView.getLayoutY());

                if(board.checkPieceBoundary(pieceView, 40, 40)) {
                    board.putPiece(pieceView, XboardMatrix, YboardMatrix, isFull);
                }

                if(board.checkPieceBoundary(piece2View, 100, 40))
                    board.putPiece(piece2View, XboardMatrix, YboardMatrix, isFull);

                for(int i = 0; i < 5; i++) {
                    for(int j =0; j < 11; j++) {
                        System.out.print(isFull[i][j]);
                    }
                    System.out.println();
                }
            }
        };

//--------------------------------------------------------------------------------------------------

        //ADDING EVENTHANDLER TO PIECES
        pieceView.addEventHandler(MouseEvent.MOUSE_RELEASED, handler);
        piece2View.addEventHandler(MouseEvent.MOUSE_RELEASED, handler);

//--------------------------------------------------------------------------------------------------

        //SETTING THE PANE
        board.getBoardView().setFitHeight(400);
        board.getBoardView().setFitWidth(800);
        board.getBoardView().setLayoutX(200);
        board.getBoardView().setLayoutY(400);

        pieceBox.setMaxSize(300, 300);
        pieceBox.setMinSize(300,300);

        String style = "-fx-background-color: rgba(193, 66, 66, 0.8);";
        backgroundPane.setStyle(style);
        boardPane.getChildren().addAll(board.getBoardView());
        backgroundPane.setCenter(boardPane);
        backgroundPane.setBottom(pieceBox);
        backgroundPane.setTop(menuPane);

//--------------------------------------------------------------------------------------------------

        // add the scalable pane to the scene
        Scene scene = new Scene(backgroundPane, 800, 1000);

        // setup the stage
        primaryStage.setTitle("IQ PUZZLER PRO");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

    }


    /*
    public boolean checkPieceBoundary(ImageView piece, double xPosition, double yPosition){
        //Board Borders
        //Boundary Locations
        final int threshold = 10;
        int xTopLeft = 40;
        int yTopLeft = -468;
        int xTopRight = 770;
        int yTopRight = -468;
        int xBottomLeft = 40;
        int yBottomLeft = -194;
        int xBottomRight = 770;
        int yBottomRight = -194;

        if((piece.getLayoutX() < xTopLeft - threshold) || (piece.getLayoutX() > xTopRight + threshold) || (piece.getLayoutY() > yBottomLeft + threshold) || (piece.getLayoutY() < yTopRight - threshold)) {
            piece.setLayoutX(xPosition);
            piece.setLayoutY(yPosition);
            return false;
        }
        else {
            return true;
        }
    }

*/





}
