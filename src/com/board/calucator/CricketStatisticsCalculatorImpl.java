package com.board.calucator;

import com.board.ball.BallEvent;
import com.board.ball.BallType;
import com.board.player.CricketPlayer;
import com.board.team.CricketTeam;
import com.board.team.Team;

public class CricketStatisticsCalculatorImpl implements StatisticsCalulator {
    @Override
    public void calculateStatistics(Team team, BallEvent ballEvent) {
        CricketTeam cricketTeam = (CricketTeam) team;
        switch (ballEvent.getBallType()){
            case NB:
                handleNoBall(cricketTeam);
                break;
            case WD:
                handleWideBall(cricketTeam);
                break;
            case W:
                handleWideBall(cricketTeam);
                break;
            default:
                handleRun(cricketTeam,ballEvent.getRun());
            }
        }


    private void handleWideBall(CricketTeam team){
        updateScore((CricketPlayer)team.getBattingPlayer(),1 );
    }

    private void handleNoBall(CricketTeam team){

    }

    private void handleWicket(CricketTeam team){
        team.getBattingPlayer().setCurrentlyPlaying(false);
        int nextPlayerPosition=team.getNextPlayerPosition();
        if(nextPlayerPosition<team.getPlayerList().size()){
            team.setBattingPlayer((CricketPlayer) team.getPlayerList().get(nextPlayerPosition));
            team.setNextPlayerPosition(++nextPlayerPosition);
        }
    }

    private void handleRun(CricketTeam team,int run){
        updateScore((CricketPlayer)team.getBattingPlayer(),run );
        team.setTotalScore(team.getTotalScore()+run);
        if(run==1||run==3){
            CricketPlayer player=team.getBattingPlayer();
            team.setBattingPlayer(team.getPitchPlayer());
            team.setPitchPlayer(player);
        }

    }

    private CricketPlayer updateScore(CricketPlayer player,int run){
        int currentScore=player.getTotalScore();
        player.setTotalScore(run+currentScore);
        player.setNoOfBalls(player.getNoOfBalls()+1);
        if(run==4){
            player.setNoOfFours(player.getNoOfFours()+1);
        }else if(run==6){
            player.setNoOfFours(player.getNoOfSix()+1);
        }

        return player;

    }


}
