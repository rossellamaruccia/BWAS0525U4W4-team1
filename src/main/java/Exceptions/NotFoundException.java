package Exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Distributore non trovato.");
    }
}
