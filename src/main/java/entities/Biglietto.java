package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "biglietto")
public class Biglietto extends TitoloDiViaggio {

    @Column(name = "data_vidimazione")
    private LocalDate dataVidimazione;

    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private Parco_mezzi mezzo;

    public Biglietto() {
    }

    public Biglietto(LocalDate dataEmissione, Emittente emittente, Parco_mezzi mezzo) {
        super(dataEmissione, emittente);
        this.mezzo = mezzo;
    }

    public LocalDate getDataVidimazione() {
        return dataVidimazione;
    }

    public void setDataVidimazione(LocalDate dataVidimazione) {
        this.dataVidimazione = dataVidimazione;
    }

    public Parco_mezzi getMezzo() {
        return mezzo;
    }

    public void setMezzo(Parco_mezzi mezzo) {
        this.mezzo = mezzo;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "id=" + getId() +
                ", dataEmissione=" + getDataEmissione() +
                ", emittente=" + getEmittente() +
                ", dataVidimazione=" + dataVidimazione +
                ", mezzo=" + mezzo +
                '}';
    }
}
