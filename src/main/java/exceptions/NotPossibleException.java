package exceptions;

public class NotPossibleException extends RuntimeException {
    public NotPossibleException() {
        super(
                "Il mezzo è associato ad un'altra tratta"
        );
    }
}
