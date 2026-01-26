package org.example.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long numTessera) {
        super("La tessera con numero "+numTessera+" non é stata trovata");
    }
}
