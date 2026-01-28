package entities;

import enums.FrequenzaAbbonamento;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Abbonamento extends TitoloDiViaggio {

    LocalDateTime dataScadenza;
    @Column(name = "frequenza")
    @Enumerated(EnumType.STRING)
    private FrequenzaAbbonamento frequenza;
    @OneToOne
    @JoinColumn(name = "tessera")
    private Tessera tessera;

    public Abbonamento() {
    }

    public Abbonamento(Emittente emittente, FrequenzaAbbonamento frequenza, Tessera tessera, LocalDateTime dataEmissione) {
        super(dataEmissione, emittente);
        this.frequenza = frequenza;
        this.tessera = tessera;
        if (this.frequenza == FrequenzaAbbonamento.SETTIMANALE) {
            this.dataScadenza = dataEmissione.plusWeeks(1);
        } else if (this.frequenza == FrequenzaAbbonamento.MENSILE) {
            this.dataScadenza = dataEmissione.plusMonths(1);
        }
    }

    public FrequenzaAbbonamento getFrequenza() {
        return frequenza;
    }

    public void setFrequenza(FrequenzaAbbonamento frequenza) {
        this.frequenza = frequenza;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public LocalDateTime getDataScadenza() {
        return dataScadenza;
    }
}
