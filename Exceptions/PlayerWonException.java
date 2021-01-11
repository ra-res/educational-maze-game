package Assignment2.Exceptions;

/**
 * class PlayerWonException extends RuntimeException
 * Custom exception thrown when the player won the game.
 */
public class PlayerWonException extends RuntimeException {
    public PlayerWonException(String message) {
        super(message);
    }
}
