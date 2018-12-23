package sample;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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


    public Piece(int pieceId, ImageView image, int[][] matrix){
        this.matrix = matrix;
        //this.images = images;
        rotation = 0;
        currentImage  = image;
        isUsed = true;
        this.positionX = 0;
        this.positionY = 0;
        this.pieceId = pieceId;
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
        System.out.println("BEFORE: ");

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {

                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        swapRows(this.matrix);
        transpose(this.matrix);
        System.out.println("AFTER: ");

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {

                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        for(int i = 0; i < 3; i++) {
            shiftLeftMost(this.matrix);
        }

        System.out.println("AFTER SHIFT LEFT");
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {

                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        for(int i = 0; i < 3; i++) {
            shiftUpMost(this.matrix);
        }
        System.out.println("AFTER SHIFT UP");

    }


    public void rotateMatrixRight(){

    }

    private static void transpose(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[0].length; j++) {
                int x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }
    }

    public static void swapRows(int[][] m) {
        for (int  i = 0, k = m.length - 1; i < k; ++i, --k) {
            int[] x = m[i];
            m[i] = m[k];
            m[k] = x;
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

    //Sonradan eklendi
    public int [][] getMatrix() {
        return matrix;
    }

    public int getPieceId() {
        return this.pieceId;
    }

}
