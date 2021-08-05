package com.board.displayboard;

import com.board.team.Team;

public interface DisplayBoard {
    void displayTeamScore(Team team);

    void displayWinner(Team team, int run);

    void displayDraw();
}
