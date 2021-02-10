package Game;

public class Timer {
/**
 * Class Timer
 * Allows to timing how long it takes for the player to finish the game
 */
    private long startTime;
    private long endTime;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public int getTimeInMilliseconds() {
        return (int) ((endTime - startTime) / 1000000 / 1000);
    }

    public static void main(String[] args) {
        Timer time = new Timer();
        time.startTimer();
        time.stopTimer();
    }
}