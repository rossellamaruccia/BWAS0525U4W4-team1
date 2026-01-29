package exceptions;

public class NotPossibleException extends RuntimeException {
    public NotPossibleException() {
        super(
                "L'operazione non è andata a buon fine."
        );
    }
}
