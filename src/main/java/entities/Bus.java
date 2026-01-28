package entities;

import enums.Stato;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bus")
public class Bus extends Parco_mezzi {
    @Column
    private int capienza;

    public Bus() {
    }

    public Bus(Stato stato, int year, int month, int day, Tratta tratta) {
        super(stato, year, month, day, tratta);
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
