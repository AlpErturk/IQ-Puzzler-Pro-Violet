package sample;

public class AdditionModel {

    final int sceneWidth = 1500;
    final int sceneHeight = 1000;

    private double []xPositions = new double[9];
    private double []yPositions = new double[9];

    //----------------------------------------------------------------------------------------------------------------------

    //BOARD MATRIXI INITIALIZE EDILIYOR VE BIR MATRIX XPOSITIONLARI TUTUYOR BIR MATRIX YPOSITIONLARI TUTUYOR
    //BIR MATRIX TUM BOARD ENTRYLERININ BOS OLUP OLMADIGINI TUTUYOR
    //Boardun constructorinda initialize edilece

    private double [][]XboardMatrix = new double[5][11];
    private double [][]YboardMatrix = new double[5][11];

    //init x positions

    private Board board;
    private Game game;

    private int levelTime;


    public AdditionModel(){
        game = Game.getInstance();
        levelTime = game.twoDLevels[game.getCurrent2DLevel()].getTime();

        board = new Board(game.twoDLevels[game.getCurrent2DLevel()].getLevelMatrix(), sceneWidth, sceneHeight);

        xPositions[0] = 5;
        xPositions[1] = 290;
        xPositions[2] = 575;
        xPositions[3] = 860;
        xPositions[4] = 1145;
        xPositions[5] = 5;
        xPositions[6] = 5;
        xPositions[7] = 775;
        xPositions[8] = 775;

        yPositions[0] = 450;
        yPositions[1] = 450;
        yPositions[2] = 450;
        yPositions[3] = 450;
        yPositions[4] = 450;
        yPositions[5] = 0;
        yPositions[6] = 285;
        yPositions[7] = 0;
        yPositions[8] = 285;


        for(int i = 0; i < 5; i++) {
            for(int j =0; j < 11; j++) {
                XboardMatrix[i][j] = ((sceneWidth - board.getBoardWidth()) / 2)  + (70 * j);
                YboardMatrix[i][j] = 70 * i;
            }
        }
    }

    public int getSceneWidth(){
        return sceneWidth;
    }

    public int getSceneHeight(){
        return sceneHeight;
    }

    public Board getBoard(){
        return board;
    }

    public Game getGame(){
        return game;
    }

    public double[] getxPositions() {
        return xPositions;
    }

    public double[] getyPositions() {
        return yPositions;
    }

    public double[][] getXboardMatrix() {
        return XboardMatrix;
    }

    public double[][] getYboardMatrix() {
        return YboardMatrix;
    }

    public int getLevelTime(){
        return game.twoDLevels[game.getCurrent2DLevel()].getTime();
    }

    public void setElapsedTime(int time){ game.twoDLevels[game.getCurrent2DLevel()].setElapsedTime(time);}

    public int getElapsedTime(){ return game.twoDLevels[game.getCurrent2DLevel()].getElapsedTime();}

    public void incrementTime(){ game.twoDLevels[game.getCurrent2DLevel()].incrementElapsedTime();}

}


