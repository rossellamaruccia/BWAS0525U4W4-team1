package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Tessera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numTessera;

    @Column(nullable = false)
    private LocalDate dataEmissione;

    private LocalDate dataScadenza;

    public Tessera() {
    }

    public Tessera(int year, int month, int day) {
        this.dataEmissione = LocalDate.of(year, month, day);

        this.dataScadenza = dataEmissione.plusYears(1);
    }

    public long getNumTessera() {
        return numTessera;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "numTessera=" + numTessera +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                '}';
    }

}
