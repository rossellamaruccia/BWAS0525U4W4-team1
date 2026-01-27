package entities;

import enums.Stato;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Tram")
public class Tram extends Parco_mezzi {
    @Column
    private int capienza;

    public Tram() {
    }

    ;

    public Tram(Stato stato, LocalDate data_attivazione, Tratta tratta) {
        super(stato, data_attivazione, tratta);
        this.capienza = 50;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    @Override
    public String toString() {
        return "Tram{}" + super.toString();
    }
}
