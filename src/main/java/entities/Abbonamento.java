package entities;

import enums.FrequenzaAbbonamento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "abbonamento")
public class Abbonamento extends TitoloDiViaggio {

    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;

    @Column(name = "durata")
    @Enumerated(EnumType.ORDINAL)
    private FrequenzaAbbonamento durata;

    @OneToOne
    @JoinColumn(name = "id_tessera")
    private Tessera tessera;

    public Abbonamento() {
    }

    public Abbonamento(int year, int month, int day, Emittente emittente, FrequenzaAbbonamento durata, Tessera tessera) {
        super(year, month, day, emittente);
        this.durata = durata;
        this.tessera = tessera;
        if (this.durata == FrequenzaAbbonamento.SETTIMANALE) {
            this.dataScadenza = this.getDataEmissione().plusWeeks(1);
        } else if (this.durata == FrequenzaAbbonamento.MENSILE) {
            this.dataScadenza = this.getDataEmissione().plusMonths(1);
        }
    }

    public FrequenzaAbbonamento getDurata() {
        return durata;
    }

    public void setDurata(FrequenzaAbbonamento durata) {
        this.durata = durata;
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

    @Override
    public String toString() {
        return "Abbonamento{" +
                "id=" + getId() +
                ", dataEmissione=" + getDataEmissione() +
                ", emittente=" + getEmittente() +
                ", durata=" + durata +
                ", dataScadenza=" + dataScadenza +
                ", tessera=" + tessera +
                '}';
    }
}
