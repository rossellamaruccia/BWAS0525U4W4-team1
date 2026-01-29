package exceptions;

public class NotPossibleException extends RuntimeException {
    public NotPossibleException() {
        super(
                "Il mezzo è associato ad un'altra tratta"
        );
    }

    public NotPossibleException(String id_mezzo) {
        super(
                "Il mezzo con id: " + id_mezzo + " é giá in manutenzione"
        );
    }
}
