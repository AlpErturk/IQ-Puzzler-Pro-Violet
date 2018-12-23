package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Board {

    int[][] boardMatrix;
    Image boardImage;
    ImageView  boardView;


    public Board(int[][] matrix){
        boardImage = new Image("file:/Users/safaaskin/IdeaProjects/Deneme/images/boardpic.png");
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

    //PIECEI BIRAZ DISARI KOYDUGUMUZDA PICECEI BOARDA FIX EDEN FONKSIYON
    public void putPiece(ImageView piece, double [][]XboardMatrix, double [][]YboardMatrix, int [][]isFull) {

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

        double piecePositionX = piece.getLayoutX();
        double piecePositionY = piece.getLayoutY();

        int indexX = (int) (piecePositionX / (66.36));
        int indexY = (int) ((piecePositionY+468) / (66.36));

        if(((piecePositionX > (XboardMatrix[indexY][indexX] - 10)) && (piecePositionX < (XboardMatrix[indexY][indexX] + 66.36)) && (((piecePositionY > (YboardMatrix[indexY][indexX] - 10)) && (piecePositionY < (YboardMatrix[indexY][indexX] + 66.36)))))){

            System.out.println(indexX);
            System.out.println(indexY);

            piece.setLayoutX(XboardMatrix[indexY][indexX] + 3);
            piece.setLayoutY(YboardMatrix[indexY][indexX] + 13);
            isFull[indexY][indexX] = 1;

        }


    }
}
