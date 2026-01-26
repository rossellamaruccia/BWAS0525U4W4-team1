package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.UUID;
@Entity
@DiscriminatorValue("Bus")
public class Bus extends Parco_mezzi{
private static  int capienza=30;
public Bus(){};
public Bus (UUID id){
super(id,capienza);

    }
    @Override
    public String toString() {
        return "Bus{}"+super.toString();
    }
}
