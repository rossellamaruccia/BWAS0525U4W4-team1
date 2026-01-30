package entities;

import exceptions.NotPossibleException;
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

    @OneToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente possessore;

    public Tessera() {
    }

    public Tessera(Utente possessore) {
        if (possessore.haTessera()) {
            throw new NotPossibleException();
        }
        this.dataEmissione = LocalDate.now();
        this.dataScadenza = dataEmissione.plusYears(1);
        this.possessore = possessore;
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

    public void setDataScadenza() {
        this.dataScadenza = LocalDate.now().plusYears(1);
    }

    public UUID getTesseraId() {
        return tesseraId;
    }

    public Utente getPossessore() {
        return possessore;
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
