package Exceptions;

/**
 * class CovidInfectionException extends RuntimeException This is a custom
 * exception that is thrown when the user did not respect social distancing
 * rules.
 */
public class CovidInfectionException extends RuntimeException {
    public CovidInfectionException(String message) {
        super(message);
    }
}
