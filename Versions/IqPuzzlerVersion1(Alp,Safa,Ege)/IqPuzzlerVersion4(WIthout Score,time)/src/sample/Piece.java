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
        positionX = 0;
        positionY = 0;
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

    }
    public void rotateMatrixRight(){

    }

    //Sonradan eklendi
    public int [][] getMatrix() {
        return matrix;
    }

}
