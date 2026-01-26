package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bus")
public class Bus extends Parco_mezzi {
    @Column
    private int capienza;


    public Bus() {
        this.capienza = 30;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    @Override
    public String toString() {
        return "Bus{}" + super.toString();
    }
}
