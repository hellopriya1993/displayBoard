package com.board.team;

import com.board.player.CricketPlayer;
import com.board.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private int totalScore;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }


}
