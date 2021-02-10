package Game;

import Configuration.Constants;
import Exceptions.PlayerWonException;

public class GameRound {

    public void startGame() {
        Constants.TIMER.startTimer();
    }

    public void endGame(RuntimeException runtimeException) {
        Constants.TIMER.stopTimer();
        if (runtimeException instanceof PlayerWonException) {
            update();
        }
    }

    public void update() {
        Constants.SCORE_MANAGER.addScore(Constants.TIMER.getTimeInMilliseconds());
        Constants.SCORE_MANAGER.saveScores();
    }
}
