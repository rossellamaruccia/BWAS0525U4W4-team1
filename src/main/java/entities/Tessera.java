package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tessere")
public class Tessera {

    @Id
    @GeneratedValue
    private UUID tesseraId;

    @Column(nullable = false)
    private LocalDate dataEmissione;

    private LocalDate dataScadenza;

    public Tessera() {
    }

    public Tessera(int year, int month, int day) {
        this.dataEmissione = LocalDate.of(year, month, day);

        this.dataScadenza = dataEmissione.plusYears(1);
    }

    public UUID getIdTessera() {
        return tesseraId;
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
                "numTessera=" + tesseraId +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                '}';
    }

}
