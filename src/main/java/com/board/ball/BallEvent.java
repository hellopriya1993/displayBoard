package com.board.ball;

import com.board.exceptions.InputException;
import com.board.validator.InputValidator;

/**
 * This class is to get Event associated with each ball
 */
public class BallEvent {

    private BallType ballType;
    private int run;
    private boolean oneMoreBall;

    public boolean isOneMoreBall() {
        return oneMoreBall;
    }

    public void setOneMoreBall(boolean oneMoreBall) {
        this.oneMoreBall = oneMoreBall;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }


    public BallEvent(String currentBall) throws InputException {
        this.ballType = assignBallType(currentBall);
    }

    public BallType getBallType() {
        return ballType;
    }

    /**
     * @return BallType
     */
    private BallType assignBallType(String ball) throws InputException {
        try {
            if (ball.equalsIgnoreCase(BallType.W.name())) {
                return BallType.W;
            } else if (ball.equalsIgnoreCase(BallType.NB.name())) {
                return BallType.NB;
            } else if (ball.equalsIgnoreCase(BallType.WD.name())) {
                this.oneMoreBall = true;
                return BallType.WD;
            } else {
                this.setRun(Integer.parseInt(ball));
                new InputValidator().validdateNoOfRuns(this.run);
                return BallType.RUN;
            }
        } catch (NumberFormatException | InputException e) {
            throw new InputException("Provide a valid value for ball (W,Wd,Nb,{0-6})");
        }
    }
}



