package entities;

import enums.FrequenzaAbbonamento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Abbonamento extends TitoloDiViaggio {

    LocalDate dataScadenza;
    @Column(name = "frequenza")
    @Enumerated(EnumType.STRING)
    private FrequenzaAbbonamento frequenza;
    @OneToOne
    @JoinColumn(name = "tessera")
    private Tessera tessera;

    public Abbonamento() {
    }

    public Abbonamento(Emittente emittente, FrequenzaAbbonamento frequenza, Tessera tessera, int year, int month, int day) {
        super(year, month, day, emittente);
        this.frequenza = frequenza;
        this.tessera = tessera;
        if (frequenza == FrequenzaAbbonamento.SETTIMANALE) {
            this.dataScadenza = this.getDataEmissione().plusWeeks(1);
        } else if (frequenza == FrequenzaAbbonamento.MENSILE) {
            this.dataScadenza = this.getDataEmissione().plusMonths(1);
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

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }
}
