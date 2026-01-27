package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "titoli_di_viaggio")
@Inheritance(strategy = InheritanceType.JOINED)
public class TitoloDiViaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Codice univoco del titolo di viaggio
    @Column(name = "codice_univoco", nullable = false, unique = true)
    private String codiceUnivoco;

    // Data/ora di emissione del titolo
    @Column(name = "data_emissione", nullable = false)
    private LocalDateTime dataEmissione;

    @ManyToOne
    @JoinColumn(name = "emittente_id")
    private Emittente emittente;
    

    public TitoloDiViaggio() {
    }

    protected TitoloDiViaggio(String codiceUnivoco, LocalDateTime dataEmissione) {
        this.codiceUnivoco = codiceUnivoco;
        this.dataEmissione = dataEmissione;
    }

    public Long getId() {
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

    public Emittente getEmittenteId() {
        return emittente;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "id=" + id +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                ", dataEmissione=" + dataEmissione +
                ", emittenteId=" + emittente +
                '}';
    }
}
