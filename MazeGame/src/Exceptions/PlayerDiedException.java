package Exceptions;

/**
 * class PlayerDiedException extends RuntimeException Custom exception thrown
 * when the player lost the game.
 */
public class PlayerDiedException extends RuntimeException {
    public PlayerDiedException(String message) {
        super(message);
    }
}
