package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.UUID;
@Entity
@DiscriminatorValue("Bus")
public class Bus extends Parco_mezzi{

public Bus(){};
public Bus (UUID id){
super(id);
    this.capienza=30;
    }
    @Override
    public String toString() {
        return "Bus{}"+super.toString();
    }
}
