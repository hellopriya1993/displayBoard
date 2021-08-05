package com.board.renderer;

import com.board.ball.BallEvent;
import com.board.exceptions.InningsOverException;
import com.board.match.MatchInfo;
import com.board.team.CricketTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreBoardRenderer {

    public static void main(String[] args) {
        MatchInfo matchInfo = new MatchInfo();
        Scanner in = new Scanner(System.in);
        System.out.println("No. of Players for each team:");
        int noOfPlayers = in.nextInt();
        System.out.println("No. of overs:");
        int noOfOvers = in.nextInt();


        for (int k = 1; k <= 2; k++) {
            List<String> namesList = new ArrayList<>();
            System.out.println("Order of Players for " + noOfPlayers + " players");
            for (int i = 1; i <= noOfPlayers; i++) {
                namesList.add(in.next());
            }


            CricketTeam cricketTeam = matchInfo.createTeam(namesList, k - 1);
            for (int i = 1; i <= noOfOvers; i++) {
                System.out.println("Over Being Bowled: " + i);
                try {
                    for (int j = 1; j <= 6; j++) {
                        System.out.println("Run in " + j + " ball");
                        cricketTeam.setNoOfOverBall(j);
                        BallEvent ballEvent = new BallEvent(in.next());
                        matchInfo.calculateStatisticsForTeam(cricketTeam, ballEvent);
                        /**
                         * extra ball handling
                         */
                        if (ballEvent.isOneMoreBall()) {
                            System.out.println("Value in wide ball");
                            ballEvent = new BallEvent(in.next());
                            matchInfo.calculateStatisticsForTeam(cricketTeam, ballEvent);
                        }
                    }
                } catch (InningsOverException inningsOverException) {

                }

                matchInfo.displayTeamScore(cricketTeam);
            }

        }

        matchInfo.displayWinner();


    }

}
