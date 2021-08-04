package com.board.team;

import com.board.player.CricketPlayer;

import java.util.List;

public class CricketTeamManager implements TeamManager  {


    public CricketTeam createTeam(List<String> names,int teamNo) {
        CricketTeam cricketTeam=new CricketTeam();
        cricketTeam.setName("Team"+teamNo);
       for(int i=0;i<names.size();i++){
           CricketPlayer cricketPlayer=new CricketPlayer(names.get(i));
           if(i==0||i==1){
               cricketPlayer.setCurrentlyPlaying(true);
               if(i==0)
                   cricketTeam.setBattingPlayer(cricketPlayer);
               else if(i==1)
                   cricketTeam.setPitchPlayer(cricketPlayer);
           }
           cricketTeam.addPlayers(cricketPlayer);
       }
       cricketTeam.setNextPlayerPosition(2);
       return cricketTeam;
    }

}
