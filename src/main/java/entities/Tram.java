package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.UUID;
@Entity
@DiscriminatorValue("Tram")
public class Tram extends Parco_mezzi{

    public Tram(){
        this.capienza=50;
    };
    @Override
    public String toString() {
        return "Tram{}"+super.toString();
    }
}
