package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
// @Table(name = "titoli_di_viaggio")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TitoloDiViaggio {

    @Id
    @GeneratedValue
    private UUID id;

    // Data/ora di emissione del titolo
    @Column(name = "data_emissione", nullable = false)
    private LocalDate dataEmissione;

    @ManyToOne
    @JoinColumn(name = "emittente_id", nullable = false)
    private Emittente emittente;

    public TitoloDiViaggio() {
    }

    public TitoloDiViaggio(Emittente emittente) {
        this.dataEmissione = LocalDate.now();
        this.emittente = emittente;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public Emittente getEmittente() {
        return emittente;
    }


    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", ID =" + emittente +
                '}';
    }
}
