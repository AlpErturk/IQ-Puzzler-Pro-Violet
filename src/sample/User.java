package sample;

public class User {

    //User variables

    String username;
    //String password;

    int score;
    int lastPassedLevel;
    int currentLevel;

    int []passedTwoDimLevels;
    int []passedThreeDimLevels;

    //Constructor
    public User() {
        username = "";
        score = 0;
        lastPassedLevel = 0;
        currentLevel = 0;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int[] getPassedTwoDimLevels() {
        return this.passedTwoDimLevels;
    }

    public void setPassedTwoDimLevels(int[] passedTwoDimLevels) {
        this.passedTwoDimLevels = passedTwoDimLevels;
    }

    public int getLastPassedLevel() {
        return this.lastPassedLevel;
    }

    public void setLastPassedLevel(int lastPassedLevel) {
        this.lastPassedLevel = lastPassedLevel;
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public void setCurrentLevel(int currentLevel){
        this.currentLevel = currentLevel;
    }

}
