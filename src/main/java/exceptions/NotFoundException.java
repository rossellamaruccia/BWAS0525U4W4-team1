package exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        System.out.println("Elemento con id: " + id + " non trovato.");
    }
}
