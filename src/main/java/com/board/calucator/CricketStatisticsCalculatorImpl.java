package com.board.calucator;

import com.board.ball.BallEvent;
import com.board.exceptions.InningsOverException;
import com.board.player.CricketPlayer;
import com.board.team.CricketTeam;
import com.board.team.Team;

public class CricketStatisticsCalculatorImpl implements TeamStatisticsCalulator {
    @Override
    public void calculateStatistics(Team team, BallEvent ballEvent) throws InningsOverException {
        CricketTeam cricketTeam = (CricketTeam) team;
        switch (ballEvent.getBallType()) {
            case NB -> handleNoBall(cricketTeam);
            case WD -> handleWideBall(cricketTeam);
            case W -> handleWicket(cricketTeam);
            default -> handleRun(cricketTeam, ballEvent.getRun());
        }

    }

    /**
     * @param team This method is to handle wide ball assuming in wide 1 score is awarded to team
     */
    private void handleWideBall(CricketTeam team) {
        team.updateTotalScore(1);
    }

    /**
     * @param team assuming in no-ball 1 score is awarded to player
     */
    private void handleNoBall(CricketTeam team) {
        team.getBattingPlayer().updateTotalScore(1);
    }

    /**
     * @param team get next Player to strike
     *             In case if already at lastPlayer throw exception
     */
    private void handleWicket(CricketTeam team) throws InningsOverException {
        team.getBattingPlayer().setCurrentlyPlaying(false);
        team.getBattingPlayer().updateNoOfBalls();
        team.updateWickets();
        updateOvers(team);
        int nextPlayerPosition = team.getNextPlayerPosition();
        if (nextPlayerPosition < team.getPlayerList().size()) {
            CricketPlayer nextPlayer = team.getPlayerList().get(nextPlayerPosition);
            nextPlayer.setCurrentlyPlaying(true);
            team.setBattingPlayer(nextPlayer);
            team.setNextPlayerPosition(++nextPlayerPosition);
        } else {
            throw new InningsOverException();
        }
    }

    private void handleRun(CricketTeam team, int run) {
        CricketPlayer player = team.getBattingPlayer();
        player.updateTotalScore(run);
        player.updateNoOfBalls();
        if (run == 4) {
            player.updateFours();
        } else if (run == 6) {
            player.updateSix();
        }
        team.updateTotalScore(run);
        if (run == 1 || run == 3) {
            strikeChange(team);
        }
        if (team.isLastBall()) {
            strikeChange(team);
        }
        updateOvers(team);
    }


    private void strikeChange(CricketTeam team) {
        CricketPlayer player = team.getBattingPlayer();
        team.setBattingPlayer(team.getPitchPlayer());
        team.setPitchPlayer(player);
    }

    private void updateOvers(CricketTeam cricketTeam) {
        if (cricketTeam.isLastBall()) {
            cricketTeam.updateOvers();
            cricketTeam.setNoOfOverBall(0);
        }
    }
}
