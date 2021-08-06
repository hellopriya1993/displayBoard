package com.board.match;

import com.board.ball.BallEvent;
import com.board.calucator.CricketStatisticsCalculatorImpl;
import com.board.displayboard.CricketDisplayBoardImpl;
import com.board.exceptions.InningsOverException;
import com.board.exceptions.MatchOverException;
import com.board.team.CricketTeam;
import com.board.team.CricketTeamManager;
import com.board.team.Team;

import java.util.List;

public class MatchInfo {
    Team[] listOfTeams = new Team[2];
    Team winningTeam;
    int runDiff;
    private CricketDisplayBoardImpl displayBoard = new CricketDisplayBoardImpl();
    private CricketStatisticsCalculatorImpl statisticsCalculator = new CricketStatisticsCalculatorImpl();

    public int getRunDiff() {
        return runDiff;
    }

    public void setRunDiff(int runDiff) {
        this.runDiff = runDiff;
    }

    public Team getWinner() {
        return winningTeam;
    }

    public void setWinner(Team winner) {
        this.winningTeam = winner;
    }

    public CricketTeam createTeam(List<String> names, int teamNo) {
        CricketTeamManager cricketTeamManager = new CricketTeamManager();
        CricketTeam team = cricketTeamManager.createTeam(names, teamNo);
        listOfTeams[teamNo] = team;
        return team;
    }

    public void calculateStatisticsForTeam(Team team, BallEvent ballEvent) throws InningsOverException, MatchOverException {
        statisticsCalculator.calculateStatistics(team, ballEvent);
        checkMatchOver(team);
    }

    public void displayTeamScore(Team team) {

        displayBoard.displayTeamScore(team);
    }

    public void displayWinner() {
        if (listOfTeams[0].getTotalScore() == listOfTeams[1].getTotalScore()) {
            displayBoard.displayDraw();
        } else {
            if (listOfTeams[0].getTotalScore() > listOfTeams[1].getTotalScore()) {
                this.runDiff = listOfTeams[0].getTotalScore() - listOfTeams[1].getTotalScore();
                this.setWinner(listOfTeams[0]);
            } else {
                this.runDiff = listOfTeams[1].getTotalScore() - listOfTeams[0].getTotalScore();
                this.setWinner(listOfTeams[1]);
            }
            displayBoard.displayWinner(this.winningTeam, this.runDiff);
        }

    }

    public void checkMatchOver(Team team) throws MatchOverException {
        if (!getTeam1().equals(team) && getTeam1().getTotalScore() < team.getTotalScore()) {
            throw new MatchOverException();
        }
    }

    private Team getTeam1() {
        return listOfTeams[0];
    }

}
