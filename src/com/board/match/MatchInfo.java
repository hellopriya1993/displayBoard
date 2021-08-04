package com.board.match;

import com.board.ball.BallEvent;
import com.board.calucator.CricketStatisticsCalculatorImpl;
import com.board.calucator.StatisticsCalulator;
import com.board.displayboard.CricketDisplayBoardImpl;
import com.board.team.CricketTeam;
import com.board.team.CricketTeamManager;
import com.board.team.Team;

import java.util.ArrayList;
import java.util.List;

public class MatchInfo {
    Team[] listOfTeams=new Team[2];
    Team winner;

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public CricketTeam createTeam(List<String> names,int teamNo){
        CricketTeamManager cricketTeamManager=new CricketTeamManager();
        CricketTeam team=  cricketTeamManager.createTeam(names,teamNo);
        listOfTeams[teamNo]=team;
        return team;
    }

    public void calculateStatisticsForTeam(Team team, BallEvent ballEvent) {
        CricketStatisticsCalculatorImpl statisticsCalculator=new CricketStatisticsCalculatorImpl();
        statisticsCalculator.calculateStatistics(team,ballEvent);
    }
    public void displayTeamScore(Team team) {
        CricketDisplayBoardImpl displayBoard =new CricketDisplayBoardImpl();
        displayBoard.displayTeamScore(team);
    }
}
