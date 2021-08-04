package com.board.displayboard;

import com.board.match.MatchInfo;
import com.board.team.Team;

public interface DisplayBoard {
    void displayTeamScore(Team team);
    void displayWinner(MatchInfo matchInfo);
}
