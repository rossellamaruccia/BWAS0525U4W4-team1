package entities;

import java.util.UUID;

public class Tram extends Parco_mezzi{
    private static int capienza=50;
    public Tram(UUID id) {
        super(id,capienza);

    }
}
