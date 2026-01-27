package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "titoli_di_viaggio")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TitoloDiViaggio {

    @Id
    @GeneratedValue
    private UUID id;

    // Codice univoco del titolo di viaggio
    @Column(name = "codice_univoco", nullable = false, unique = true)
    private String codiceUnivoco;

    // Data/ora di emissione del titolo
    @Column(name = "data_emissione", nullable = false)
    private LocalDateTime dataEmissione;

    @Column(name = "emittente_id", nullable = false)
    private Long emittenteId;

    public TitoloDiViaggio() {
    }

    protected TitoloDiViaggio(String codiceUnivoco, LocalDateTime dataEmissione, Long emittenteId) {
        this.codiceUnivoco = codiceUnivoco;
        this.dataEmissione = dataEmissione;
        this.emittenteId = emittenteId;
    }

    public UUID getId() {
        return id;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public LocalDateTime getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDateTime dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public Long getEmittenteId() {
        return emittenteId;
    }

    public void setEmittenteId(Long emittenteId) {
        this.emittenteId = emittenteId;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "id=" + id +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                ", dataEmissione=" + dataEmissione +
                ", emittenteId=" + emittenteId +
                '}';
    }
}
