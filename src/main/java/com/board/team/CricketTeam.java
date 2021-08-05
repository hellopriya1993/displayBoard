package com.board.team;

import com.board.player.CricketPlayer;

import java.util.ArrayList;
import java.util.List;

public class CricketTeam extends Team {

    private int wickets;
    private int overs;
    private CricketPlayer battingPlayer;
    private CricketPlayer pitchPlayer;
    private int nextPlayerPosition;
    private List<CricketPlayer> cricketPlayers;
    private int noOfOverBall;

    public int getNoOfOverBall() {
        return noOfOverBall;
    }

    public void setNoOfOverBall(int noOfOverBall) {
        this.noOfOverBall = noOfOverBall;
    }

    public int getLeadingNoOfRuns() {
        return leadingNoOfRuns;
    }

    public void setLeadingNoOfRuns(int leadingNoOfRuns) {
        this.leadingNoOfRuns = leadingNoOfRuns;
    }

    private int leadingNoOfRuns;

    public int getNextPlayerPosition() {
        return nextPlayerPosition;
    }

    public void setNextPlayerPosition(int nextPlayerPosition) {
        this.nextPlayerPosition = nextPlayerPosition;
    }

    public CricketTeam() {
        this.cricketPlayers = new ArrayList<>();
    }


    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public CricketPlayer getBattingPlayer() {
        return (CricketPlayer) battingPlayer;
    }

    public void setBattingPlayer(CricketPlayer battingPlayer) {
        this.battingPlayer = battingPlayer;
    }

    public CricketPlayer getPitchPlayer() {
        return (CricketPlayer) pitchPlayer;
    }

    public void setPitchPlayer(CricketPlayer pitchPlayer) {
        this.pitchPlayer = pitchPlayer;
    }

    public void addPlayers(CricketPlayer cricketPlayer) {
        cricketPlayers.add(cricketPlayer);
    }

    public List<CricketPlayer> getPlayerList() {
        return cricketPlayers;
    }

    public void updateBattingPlayer() {

    }

    public void updateTotalScore(int run) {
        super.setTotalScore(super.getTotalScore() + run);
    }

    public boolean isLastBall() {
        return noOfOverBall == 6;
    }

    public void updateWickets() {
        this.wickets++;
    }

    public void updateOvers() {
        this.overs++;
    }

    public String getDisplayOvers() {
        if (noOfOverBall != 0) {
            return overs + "." + noOfOverBall;
        } else {
            return String.valueOf(overs);
        }
    }
}
