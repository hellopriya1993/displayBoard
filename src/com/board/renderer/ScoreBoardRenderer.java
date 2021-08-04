package com.board.renderer;

import com.board.ball.BallEvent;
import com.board.calucator.CricketStatisticsCalculatorImpl;
import com.board.displayboard.CricketDisplayBoardImpl;
import com.board.match.MatchInfo;
import com.board.team.CricketTeam;
import com.board.team.CricketTeamManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreBoardRenderer {

    public static void main(String args[]){
        MatchInfo firstMatch=new MatchInfo();
        Scanner in=new Scanner(System.in);
        System.out.println("No. of Players for each team:");
        int noOfPlayers=in.nextInt();
        System.out.println("No. of overs:");
        int noOfOvers=in.nextInt();

        /**
         * TODO : Add support for 2 teams currently only 1 team score is being displayed
         */

        List<String> namesList=new ArrayList<>();
        System.out.println("Order of Players");
        for (int i=1;i<=noOfPlayers;i++){
            namesList.add(in.next());
        }


        CricketTeam cricketTeam=firstMatch.createTeam(namesList,1);
        for (int i=1;i<=noOfOvers;i++){
            for(int j=1;j<=6;j++){
                System.out.println("Run in "+j+" ball");
                BallEvent ballEvent=new BallEvent(in.next());
                 firstMatch.calculateStatisticsForTeam(cricketTeam,ballEvent);
            }
            firstMatch.displayTeamScore(cricketTeam);
        }







    }

}
