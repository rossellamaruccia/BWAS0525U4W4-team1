package entities;

import enums.Stato;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Bus")
public class Bus extends Parco_mezzi {
    @Column
    private int capienza;

    public Bus() {
    }

    ;

    public Bus(Stato stato, LocalDate data_attivazione, double percorrenza_effettivaKm, int num_percorrenze) {
        super(stato, data_attivazione, percorrenza_effettivaKm, num_percorrenze);
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
