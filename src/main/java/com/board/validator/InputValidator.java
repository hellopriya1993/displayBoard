package com.board.validator;

import com.board.exceptions.InputException;

public class InputValidator {

    public void validdateNoPlayers(int noOfPlayers) throws InputException {
        if (noOfPlayers < 2) {
            throw new InputException("Players should be greater than 2");

        }
    }

    public void validdateNoOfOvers(int noOfOvers) throws InputException {
        if (noOfOvers < 1) {
            throw new InputException("Overs should be greater than 0");

        }
    }

    public void validdateNoOfRuns(int noOfRuns) throws InputException {
        if (noOfRuns < 0) {
            throw new InputException("Runs should be greater than or equal to 0");

        }
    }

}
