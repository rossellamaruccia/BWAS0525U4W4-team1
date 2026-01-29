package exceptions;

public class NotPossibleException extends RuntimeException {
    public NotPossibleException() {
        super(
                "L'operazione non è andata a buon fine."
        );
    }

    public NotPossibleException(String id_mezzo) {
        super(
                "Il mezzo con id: " + id_mezzo + " é giá in manutenzione"
        );
    }
}
