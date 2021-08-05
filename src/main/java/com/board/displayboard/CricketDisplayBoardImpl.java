package com.board.displayboard;

import com.board.player.CricketPlayer;
import com.board.player.Player;
import com.board.team.CricketTeam;
import com.board.team.Team;


public class CricketDisplayBoardImpl implements DisplayBoard {
    @Override
    public void displayTeamScore(Team team) {
        CricketTeam cricketTeam = (CricketTeam) team;
        displayTeamScore(cricketTeam);

    }

    private void displayTeamScore(CricketTeam team) {
        System.out.println("ScoreCard for " + team.getName());
        System.out.println(String.format(getForamttedString(), getHeader()));
        for (Player player : team.getPlayerList()) {
            CricketPlayer cricketPlayer = (CricketPlayer) player;
            System.out.println(String.format(getForamttedString(), getPlayerInfo(cricketPlayer)));
        }
        System.out.println("Total: " + team.getTotalScore() + "/" + team.getWickets());
        System.out.println("Overs: " + team.getDisplayOvers());
    }

    @Override
    public void displayWinner(Team team, int run) {
        System.out.println(team.getName() + " won by " + run + " runs");
    }

    public void displayDraw() {
        System.out.println("Match was Draw");
    }

    private String getForamttedString() {
        String formattedString = ("%s     %s      %s      %s      %s");
        return formattedString;
    }

    private String[] getHeader() {
        String[] headers = new String[]{"PlayerName", "Score", "4s", "6s", "Balls"};
        return headers;
    }

    private String[] getPlayerInfo(CricketPlayer player) {
        String[] info = new String[5];
        info[0] = player.isCurrentlyPlaying() ? player.getName() + "*" : player.getName();
        info[1] = String.valueOf(player.getTotalScore());
        info[2] = getValueOf(player.getNoOfFours());
        info[3] = getValueOf(player.getNoOfSix());
        info[4] = getValueOf(player.getNoOfBalls());
        return info;
    }

    private String getValueOf(int value) {
        return String.valueOf(value);
    }

}
