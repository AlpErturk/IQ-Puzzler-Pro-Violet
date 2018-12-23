package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class Piece {
    final int WIDHT = 20;
    final int HEIGHT = 10;

    private int positionX;
    private int positionY;
    private int pieceId;
    private ImageView[] images;
    private int rotation;
    private boolean isUsed;
    private ImageView currentImage;
    private int[][] matrix;
    int rotationCount;


    public Piece(int pieceId, ImageView image, int[][] matrix){
        this.matrix = matrix;
        //this.images = images;
        rotation = 0;
        currentImage  = image;
        isUsed = true;
        this.positionX = 0;
        this.positionY = 0;
        this.pieceId = pieceId;
        rotationCount = 0;
    }

    public ImageView getCurrentImage() {
        return currentImage;
    }

    public void rotateLeft(){
        rotation--;
        currentImage = images[rotation];
        rotateMatrixLeft();
    }

    public void rotateRight(){
        rotation++;
        currentImage = images[rotation];
        rotateMatrixRight();
    }

    public void rotateMatrixLeft(){
//        System.out.println("BEFORE: ");
//
//        for(int i = 0; i < 4; i++) {
//            for(int j = 0; j < 4; j++) {
//
//                System.out.print(this.matrix[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

        swapRows();
        transpose();
        System.out.println("AFTER: ");

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {

                System.out.print(this.matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
//
//        for(int i = 0; i < 3; i++) {
//            shiftLeftMost(this.matrix);
//        }
//
//        System.out.println("AFTER SHIFT LEFT");
//        for(int i = 0; i < 4; i++) {
//            for(int j = 0; j < 4; j++) {
//
//                System.out.print(matrix[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//
//        for(int i = 0; i < 3; i++) {
//            shiftUpMost(this.matrix);
//        }
//        System.out.println("AFTER SHIFT UP");

    }


    public void rotateMatrixRight(){

    }

    private void transpose() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int x = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = x;
            }
        }
    }

    public void swapRows() {
        for (int  i = 0, k = matrix.length - 1; i < k; ++i, --k) {
            int[] x = matrix[i];
            matrix[i] = matrix[k];
            matrix[k] = x;
        }
    }

    public void shiftLeftMost(int [][]matrix) {

        System.out.println("BEFORE SHIFTLEFT");

        boolean oneObserved = false;

        for(int i = 0; i < 4; i++) {

            if(matrix[i][0] == 1) {
                oneObserved = true;
            }
        }

        if(!oneObserved) {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 3; j++) {
                    matrix[i][j] = matrix[i][j + 1];
                }
            }
            matrix[3][3] = 0;
            matrix[0][3] = 0;
            matrix[1][3] = 0;
            matrix[2][3] = 0;
        }
    }

    public void shiftUpMost(int [][]matrix) {

        System.out.println("BEFORE UPMOST");

        boolean oneObserved = false;

        for(int i = 0; i < 4; i++) {

            if(matrix[0][i] == 1) {
                oneObserved = true;
            }
        }

        if(!oneObserved) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 4; j++) {
                    matrix[i][j] = matrix[i+ 1][j];
                }
            }
            matrix[3][3] = 0;
            matrix[3][2] = 0;
            matrix[3][1] = 0;
            matrix[3][0] = 0;
        }

    }

    public void verticalMirror() {

        int [][] tempArray = new int [4][4];

        for(int i = 0; i <= 3; i++) {

            for(int j = 0; j <= 3; j++) {

                tempArray[i][3-j] = this.matrix[i][j];
            }
        }

        this.matrix = tempArray;

        System.out.println("IN VERTICAL");
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                System.out.print(this.matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

      //  Matrix matrix = new Matrix;

    }

    public void incrementRotationCount() {
        this.rotationCount++;
    }

    public int getRotationCount() {
        return this.rotationCount;
    }

    //Sonradan eklendi
    public int [][] getMatrix() {
        return matrix;
    }

    public int getPieceId() {
        return this.pieceId;
    }

}
