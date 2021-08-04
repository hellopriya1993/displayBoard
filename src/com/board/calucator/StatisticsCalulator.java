package com.board.calucator;

import com.board.ball.BallEvent;
import com.board.team.Team;

public interface StatisticsCalulator {

    void calculateStatistics(Team team, BallEvent ballEvent);
}
