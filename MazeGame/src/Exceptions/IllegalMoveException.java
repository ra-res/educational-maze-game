package Exceptions;

/**
 * class IllegalMoveException extends RuntimeException Custom exception thrown
 * when a Illegal move is made in the game
 */
public class IllegalMoveException extends RuntimeException {
    public IllegalMoveException(String message) {
        super(message);
    }
}
