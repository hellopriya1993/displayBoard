package com.board.calucator;

import com.board.ball.BallEvent;
import com.board.player.CricketPlayer;
import com.board.team.CricketTeam;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CricketStatisticsCalculatorImplTest {

    @Test
    public void testCalculateStatisticsForWide() throws Exception {
        CricketStatisticsCalculatorImpl statisticsCalculator = new CricketStatisticsCalculatorImpl();
        CricketTeam cricketTeam = new CricketTeam();
        CricketPlayer player1 = new CricketPlayer("P1");
        player1.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player1);
        cricketTeam.setBattingPlayer(player1);

        CricketPlayer player2 = new CricketPlayer("P2");
        player2.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player2);
        cricketTeam.setPitchPlayer(player2);

        CricketPlayer player3 = new CricketPlayer("P3");
        cricketTeam.addPlayers(player3);


        BallEvent ballEvent = new BallEvent("WD");

        statisticsCalculator.calculateStatistics(cricketTeam, ballEvent);

        assertEquals(player1, cricketTeam.getBattingPlayer());
        assertEquals(1,
                cricketTeam.getTotalScore());


    }

    @Test
    public void testCalculateStatisticsForSix() throws Exception {
        CricketStatisticsCalculatorImpl statisticsCalculator = new CricketStatisticsCalculatorImpl();
        CricketTeam cricketTeam = new CricketTeam();
        CricketPlayer player1 = new CricketPlayer("P1");
        player1.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player1);
        cricketTeam.setBattingPlayer(player1);

        CricketPlayer player2 = new CricketPlayer("P2");
        player2.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player2);
        cricketTeam.setPitchPlayer(player2);

        CricketPlayer player3 = new CricketPlayer("P3");
        cricketTeam.addPlayers(player3);

        BallEvent ballEvent = new BallEvent("6");

        statisticsCalculator.calculateStatistics(cricketTeam, ballEvent);

        assertEquals(player1, cricketTeam.getBattingPlayer());
        assertEquals(6, cricketTeam.getBattingPlayer().getTotalScore());
        assertEquals(1, cricketTeam.getBattingPlayer().getNoOfSix());


    }


    @Test
    public void testCalculateStatisticsForFour() throws Exception {
        CricketStatisticsCalculatorImpl statisticsCalculator = new CricketStatisticsCalculatorImpl();
        CricketTeam cricketTeam = new CricketTeam();
        CricketPlayer player1 = new CricketPlayer("P1");
        player1.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player1);
        cricketTeam.setBattingPlayer(player1);

        CricketPlayer player2 = new CricketPlayer("P2");
        player2.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player2);
        cricketTeam.setPitchPlayer(player2);

        CricketPlayer player3 = new CricketPlayer("P3");
        cricketTeam.addPlayers(player3);


        BallEvent ballEvent = new BallEvent("4");

        statisticsCalculator.calculateStatistics(cricketTeam, ballEvent);

        assertEquals(player1, cricketTeam.getBattingPlayer());
        assertEquals(4, cricketTeam.getBattingPlayer().getTotalScore());
        assertEquals(1, cricketTeam.getBattingPlayer().getNoOfFours());
    }

    @Test
    public void testCalculateStatisticsForTwo() throws Exception {
        CricketStatisticsCalculatorImpl statisticsCalculator = new CricketStatisticsCalculatorImpl();
        CricketTeam cricketTeam = new CricketTeam();
        CricketPlayer player1 = new CricketPlayer("P1");
        player1.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player1);
        cricketTeam.setBattingPlayer(player1);

        CricketPlayer player2 = new CricketPlayer("P2");
        player2.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player2);
        cricketTeam.setPitchPlayer(player2);

        CricketPlayer player3 = new CricketPlayer("P3");
        cricketTeam.addPlayers(player3);

        BallEvent ballEvent = new BallEvent("2");

        statisticsCalculator.calculateStatistics(cricketTeam, ballEvent);

        assertEquals(player1, cricketTeam.getBattingPlayer());
        assertEquals(2, cricketTeam.getBattingPlayer().getTotalScore());
        assertEquals(0, cricketTeam.getBattingPlayer().getNoOfFours());
        assertEquals(0, cricketTeam.getBattingPlayer().getNoOfSix());
    }


    @Test
    public void testCalculateStatisticsForOne() throws Exception {
        CricketStatisticsCalculatorImpl statisticsCalculator = new CricketStatisticsCalculatorImpl();
        CricketTeam cricketTeam = new CricketTeam();
        CricketPlayer player1 = new CricketPlayer("P1");
        player1.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player1);
        cricketTeam.setBattingPlayer(player1);

        CricketPlayer player2 = new CricketPlayer("P2");
        player2.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player2);
        cricketTeam.setPitchPlayer(player2);

        CricketPlayer player3 = new CricketPlayer("P3");
        cricketTeam.addPlayers(player3);

        BallEvent ballEvent = new BallEvent("1");

        statisticsCalculator.calculateStatistics(cricketTeam, ballEvent);

        assertEquals(player2, cricketTeam.getBattingPlayer());
        assertEquals(player1, cricketTeam.getPitchPlayer());
        assertEquals(1, cricketTeam.getPitchPlayer().getTotalScore());
        assertEquals(0, cricketTeam.getBattingPlayer().getNoOfFours());
        assertEquals(0, cricketTeam.getBattingPlayer().getNoOfSix());
    }

    @Test
    public void testCalculateStatisticsForWicket() throws Exception {
        CricketStatisticsCalculatorImpl statisticsCalculator = new CricketStatisticsCalculatorImpl();
        CricketTeam cricketTeam = new CricketTeam();
        CricketPlayer player1 = new CricketPlayer("P1");
        player1.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player1);
        cricketTeam.setBattingPlayer(player1);

        CricketPlayer player2 = new CricketPlayer("P2");
        player2.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player2);
        cricketTeam.setPitchPlayer(player2);

        CricketPlayer player3 = new CricketPlayer("P3");
        cricketTeam.addPlayers(player3);

        cricketTeam.setNextPlayerPosition(2);
        BallEvent ballEvent = new BallEvent("W");

        statisticsCalculator.calculateStatistics(cricketTeam, ballEvent);

        assertEquals(player3, cricketTeam.getBattingPlayer());
        assertEquals(player2, cricketTeam.getPitchPlayer());
        assertEquals(0, cricketTeam.getPitchPlayer().getTotalScore());
        assertEquals(0, cricketTeam.getBattingPlayer().getNoOfFours());
        assertEquals(0, cricketTeam.getBattingPlayer().getNoOfSix());
    }

    @Test
    public void testCalculateStatisticsForLastBall() throws Exception {
        CricketStatisticsCalculatorImpl statisticsCalculator = new CricketStatisticsCalculatorImpl();
        CricketTeam cricketTeam = new CricketTeam();
        CricketPlayer player1 = new CricketPlayer("P1");
        player1.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player1);
        cricketTeam.setBattingPlayer(player1);

        CricketPlayer player2 = new CricketPlayer("P2");
        player2.setCurrentlyPlaying(true);
        cricketTeam.addPlayers(player2);
        cricketTeam.setPitchPlayer(player2);

        CricketPlayer player3 = new CricketPlayer("P3");
        cricketTeam.addPlayers(player3);

        cricketTeam.setNextPlayerPosition(2);
        BallEvent ballEvent = new BallEvent("1");
        cricketTeam.setNoOfOverBall(6);

        statisticsCalculator.calculateStatistics(cricketTeam, ballEvent);

        assertEquals(player1, cricketTeam.getBattingPlayer());
        assertEquals(player2, cricketTeam.getPitchPlayer());
        assertEquals(0, cricketTeam.getPitchPlayer().getTotalScore());
        assertEquals(1, cricketTeam.getBattingPlayer().getTotalScore());
        assertEquals(1, cricketTeam.getOvers());
    }


}