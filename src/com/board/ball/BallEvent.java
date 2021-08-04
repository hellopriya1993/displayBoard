package com.board.ball;

public class BallEvent {

    private BallType ballType;

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    private int run;

    public BallEvent(String currentBall){
        this.ballType=assignBallType(currentBall);
    }

    public BallType getBallType() {
        return ballType;
    }

    private BallType assignBallType(String ball){
        if(ball.equals(BallType.W.name())){
            return BallType.W;
        }
        else if(ball.equals(BallType.NB.name())){
            return BallType.NB;
        }
        else if(ball.equals(BallType.WD.name())){
            return BallType.WD;
        }
        else {
            this.setRun(Integer.parseInt(ball));
            return BallType.RUN;
        }
    }
}



