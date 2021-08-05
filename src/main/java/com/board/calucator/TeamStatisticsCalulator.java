package com.board.calucator;

import com.board.ball.BallEvent;
import com.board.team.Team;

public interface TeamStatisticsCalulator {

    void calculateStatistics(Team team, BallEvent ballEvent) throws Exception;
}
