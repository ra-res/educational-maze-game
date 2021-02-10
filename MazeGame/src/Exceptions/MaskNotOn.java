package Exceptions;

public class MaskNotOn extends RuntimeException {
    public MaskNotOn(String message) {
        super(message);
    }
}