package Assignment2.Exceptions;

public class IllegalMove extends RuntimeException {
    public IllegalMove(String message) {
        super(message);
    }
}
