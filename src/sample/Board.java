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


    final int boardWidth = 770;
    final int boardHeight = 350;

    Image boardImage;
    ImageView  boardView;
    int[][] boardMatrix;
    private int sceneWidth;
    private int sceneHeight;
    private int leftXCoordinate;
    private int topYCoordinate;
    private int rightXCoordinate;
    private int bottomYCoordinate;
    private int treshold;
    private Game game = Game.getInstance();

    public Board(int[][] matrix,int sceneWidth, int sceneHeight){

        boardImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/boardLast.png");
        boardView = new ImageView(boardImage);
        boardMatrix = matrix;
        this.sceneHeight = sceneHeight;
        this.sceneWidth = sceneWidth;

        leftXCoordinate = (this.sceneWidth - boardWidth) / 2 ;
        topYCoordinate = 0;
        rightXCoordinate = leftXCoordinate + boardWidth;
        bottomYCoordinate = boardHeight + topYCoordinate;
        treshold = 10;
    }



    public ImageView getBoardView(){
        return boardView;
    }

    public int getBoardWidth(){
        return boardWidth;
    }

    public void updateBoard(){
        game = Game.getInstance();
        boardMatrix = game.twoDLevels[game.getCurrent2DLevel()].getLevelMatrix();

    }


    // no two piece on each other
    public boolean isAvailable(int rowIndex, int columnIndex, int[][] pieceMatrix){
        for(int m = 0; m <4; m++){
            for (int n = 0; n < 4; n++){
                if(n + columnIndex >= 11){
                    int fazlalikColumn = (n + columnIndex) - 11;
                    if(pieceMatrix[m][n] != 0 && boardMatrix[rowIndex+m][columnIndex+n-fazlalikColumn] != 0) {
                        if(pieceMatrix[m][n] != 0 && boardMatrix[rowIndex+m][columnIndex+n-fazlalikColumn] != -2){
                            return false;
                        }
                    }
                }
                if(rowIndex + m >= 5){
                    int fazlalikRow = (rowIndex + m) - 5;
                    if(pieceMatrix[m][n] != 0 && boardMatrix[rowIndex+m-fazlalikRow][columnIndex+n] != 0) {
                        if(pieceMatrix[m][n] != 0 && boardMatrix[rowIndex+m-fazlalikRow][columnIndex+n] != -2){
                            return false;
                        }
                    }
                }

                if(pieceMatrix[m][n] != 0 && boardMatrix[rowIndex+m][columnIndex+n] != 0) {
                    if(pieceMatrix[m][n] != 0 && boardMatrix[rowIndex+m][columnIndex+n] != -2){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    //check is board full
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
    public boolean checkPieceBoundary(ImageView pieceView, double xPosition, double yPosition){
        double currentX = pieceView.getLayoutX();
        double currentY = pieceView.getLayoutY();

        if((currentX < leftXCoordinate || currentX > rightXCoordinate) || (currentY < topYCoordinate ||currentY > bottomYCoordinate)){
            //set piece to its initial place
            pieceView.relocate(xPosition,yPosition);
            System.out.println(leftXCoordinate);
            System.out.println(topYCoordinate);
            System.out.println(rightXCoordinate);
            System.out.print(bottomYCoordinate);
            return false;
        }

        else{
            return true;
        }
    }

    //PIECEI BIRAZ DISARI KOYDUGUMUZDA PICECEI BOARDA FIX EDEN FONKSIYON
    public void putPiece(Piece piece, double [][]XboardMatrix, double [][]YboardMatrix, double initX, double initY){
        updateBoard();

        double currentX = piece.getCurrentImage().getLayoutX();
        double currentY = piece.getCurrentImage().getLayoutY();

        int indexColumn = ((int)currentX - leftXCoordinate) / 70;
        int indexRow = ((int)currentY - topYCoordinate) / 70;


        System.out.println("index row is : " + indexRow);
        System.out.println("index column is: " + indexColumn);


        if(isAvailable(indexRow, indexColumn, piece.getMatrix())){
            System.out.println("buraya girdi 1");
            if (((XboardMatrix[indexRow][indexColumn] - treshold < currentX) && (currentX < XboardMatrix[indexRow][indexColumn + 1])) || ((YboardMatrix[indexRow][indexColumn] - treshold < currentY) && (currentY < YboardMatrix[indexRow + 1][indexColumn]))) {
                System.out.print("buraya girdi 2");
                piece.getCurrentImage().relocate(XboardMatrix[indexRow][indexColumn], YboardMatrix[indexRow][indexColumn]);

            }

            //set empty locations to 1
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {

                    if(piece.getMatrix()[i][j] == 1) {
                        boardMatrix[indexRow+i][j+indexColumn] = piece.getPieceId();
                    }
                }
            }
        }
        //if place is occupied return iinitial position do not update board
        else{
           // System.out.println("buraya girdi 3");
            piece.getCurrentImage().relocate(100,100);
        }


        //print board matrix----------------------------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println();
        printBoardMatrix();
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //----------------------------------------------------------------------------------------------------------------------------------------------------------------
        if(isFull()){

            try {
                Parent root = FXMLLoader.load(getClass().getResource("PauseAlertBox.fxml"));
                Stage window = Main.getMainStage();
                Scene scene = new Scene(root);
                window.setTitle("Pause");
                window.setScene(scene);
                window.centerOnScreen();
                Main.setMainStage(window);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    }

    public void printBoardMatrix() {
        for(int i = 0; i < 5; i++) {
            for(int j =0; j < 11; j++) {
                System.out.print("(");
                System.out.print(boardMatrix[i][j]);
                System.out.print(")");
            }
            System.out.println();
        }
    }

}
