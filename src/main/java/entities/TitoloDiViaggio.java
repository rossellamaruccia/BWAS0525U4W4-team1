package entities;

import exceptions.NotPossibleException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
// @Table(name = "titoli_di_viaggio")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TitoloDiViaggio {

    // Data/ora di emissione del titolo
    @Column(name = "data_emissione", nullable = false)
    protected LocalDate dataEmissione;
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "emittente_id", nullable = false)
    private Emittente emittente;

    public TitoloDiViaggio() {
    }

    public TitoloDiViaggio(Emittente emittente) {
        this.dataEmissione = LocalDate.now();
        if (emittente instanceof DistributoreAutomatico && ((DistributoreAutomatico) emittente).isIn_servizio()) {
            this.emittente = emittente;
        } else if (emittente instanceof DistributoreAutomatico && !((DistributoreAutomatico) emittente).isIn_servizio()) {
            throw new NotPossibleException();
        } else {
            this.emittente = emittente;
        }
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
