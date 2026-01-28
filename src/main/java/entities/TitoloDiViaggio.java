package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "titoli_di_viaggio")
@Inheritance(strategy = InheritanceType.JOINED)
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

    protected TitoloDiViaggio(LocalDate dataEmissione, Emittente emittente) {
        this.dataEmissione = dataEmissione;
        this.emittente = emittente;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public Emittente getEmittente() {
        return emittente;
    }

    public void setEmittenteId(Emittente emittente) {
        this.emittente = emittente;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", emittenteId=" + emittente +
                '}';
    }
}
