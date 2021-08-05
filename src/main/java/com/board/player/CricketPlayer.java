package com.board.player;

public class CricketPlayer extends Player {

    private int totalScore;
    private int noOfFours;
    private int noOfSix;
    private int noOfBalls;
    private boolean isCurrentlyPlaying;

    public CricketPlayer(String name) {
        super(name);
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getNoOfFours() {
        return noOfFours;
    }

    public void setNoOfFours(int noOfFours) {
        this.noOfFours = noOfFours;
    }

    public int getNoOfSix() {
        return noOfSix;
    }

    public void setNoOfSix(int noOfSix) {
        this.noOfSix = noOfSix;
    }

    public int getNoOfBalls() {
        return noOfBalls;
    }

    public void setNoOfBalls(int noOfBalls) {
        this.noOfBalls = noOfBalls;
    }

    public boolean isCurrentlyPlaying() {
        return isCurrentlyPlaying;
    }

    public void setCurrentlyPlaying(boolean currentlyPlaying) {
        isCurrentlyPlaying = currentlyPlaying;
    }

    public void updateNoOfBalls() {
        this.noOfBalls++;
    }

    public void updateFours() {
        this.noOfFours++;
    }

    public void updateSix() {
        this.noOfSix++;
    }

    public void updateTotalScore(int run) {
        this.totalScore += run;
    }
}