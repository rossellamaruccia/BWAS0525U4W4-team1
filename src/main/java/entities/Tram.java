package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.UUID;
@Entity
@DiscriminatorValue("Tram")
public class Tram extends Parco_mezzi{
    private static int capienza=50;
    public Tram(){};
    public Tram(UUID id) {
        super(id,capienza);

    }

    @Override
    public String toString() {
        return "Tram{}"+super.toString();
    }
}
