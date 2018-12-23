package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Board {

    //Board Borders
    //Boundary Locations
    final int threshold = 10;
    final int xTopLeft = 0;
    final int yTopLeft = -495;
    final int xTopRight = 772;
    final int yTopRight = -495;
    final int xBottomLeft = 0;
    final int yBottomLeft = -145;
    final int xBottomRight = 772;
    final int yBottomRight = -145;


    int[][] boardMatrix;
    Image boardImage;
    ImageView  boardView;


    public Board(int[][] matrix){
        boardImage = new Image("file:/Users/egeakin/IdeaProjects/Deneme/images/boardLast.png");
        boardView = new ImageView(boardImage);
        boardMatrix = matrix;
    }


    public ImageView getBoardView(){
        return boardView;
    }

    public boolean isAvailable(int i, int j, int[][] pieceMatrix){

        for(int m = 0; m <4; m++){
            for (int n = 0; n < 4; n++){
                if(pieceMatrix[m][n] == 1 && boardMatrix[i+m][j+n] == 1)
                    return false;
            }
        }
        return true;
    }


    public boolean isFull(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 11; j++){
                if(boardMatrix[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

    //Puzlle piecelerinin dogru yerde oluip olmadigini kontrol eden fonksiyon degilse boardun boundarylerinin disindaysa
    //initial positiona geri donecek

    public boolean checkPieceBoundary(ImageView piece, double xPosition, double yPosition){

        if((piece.getLayoutX() < xTopLeft - threshold) || (piece.getLayoutX() > xTopRight + threshold) || (piece.getLayoutY() > yBottomLeft + threshold) || (piece.getLayoutY() < yTopRight - threshold)) {
            piece.setLayoutX(xPosition);
            piece.setLayoutY(yPosition);
            return false;
        }
        else {
            return true;
        }
    }

    //PIECEI BIRAZ DISARI KOYDUGUMUZDA PICECEI BOARDA FIX EDEN FONKSIYON
    public void putPiece(Piece piece, double [][]XboardMatrix, double [][]YboardMatrix, double initX, double initY){

        //Boardun constructorinda initialize edilecek
//        double [][]XboardMatrix = new double[5][11];
//        double [][]YboardMatrix = new double[5][11];
//
//        int [][] isFull = new int[5][11];
//
//
//        for(int i = 0; i < 5; i++) {
//            for(int j =0; j < 11; j++) {
//                XboardMatrix[i][j] = xTopLeft + (66.36)*j;
//                YboardMatrix[i][j] = yTopLeft + (66.36)*i;
//            }
//        }

        double piecePositionX = piece.getCurrentImage().getLayoutX();
        double piecePositionY = piece.getCurrentImage().getLayoutY();

        int indexX = (int) (piecePositionX / (70));
        int indexY = (int) ((piecePositionY + 495) / (70));

        //check that is there any piece on selected place isAvaiable?


        //if(isAvailable(indexX, indexY, piece.getMatrix())){

            if (((piecePositionX > (XboardMatrix[indexY][indexX] - threshold)) && (piecePositionX < (XboardMatrix[indexY][indexX] + 70)) && (((piecePositionY > (YboardMatrix[indexY][indexX] - threshold)) && (piecePositionY < (YboardMatrix[indexY][indexX] + 70)))))) {

                System.out.println("Koydugumuz yer");
                System.out.println(piecePositionX);
                System.out.println(piecePositionY);

                System.out.println("Fix ettigi yer");
                System.out.println(XboardMatrix[indexY][indexX]);
                System.out.println(YboardMatrix[indexY][indexX]);


                piece.getCurrentImage().setLayoutX(XboardMatrix[indexY][indexX]);
                piece.getCurrentImage().setLayoutY(YboardMatrix[indexY][indexX]);


                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j < 4; j++) {

                        if(piece.getMatrix()[i][j] == 1) {
                            boardMatrix[indexY+j][i+indexX] = 1;
                        }

                    }
                }

                boardMatrix[indexY][indexX] = 1;

                for(int i = 0; i < 5; i++) {
                    for(int j =0; j < 11; j++) {
                        System.out.print(boardMatrix[i][j]);
                    }
                    System.out.println();
                }

                if(isFull()){
                    System.out.println("GAME OVER");
                    Stage window = new Stage();
                    window.initModality(Modality.APPLICATION_MODAL);
                    window.setTitle("Pause");

                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("PauseAlertBox.fxml"));
                        Scene scene = new Scene(root);
                        window.setScene(scene);
                        window.showAndWait();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
    }
}
