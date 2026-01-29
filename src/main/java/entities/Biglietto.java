package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "biglietto")
public class Biglietto extends TitoloDiViaggio {

    @Column(name = "data_vidimazione")
    private LocalDate data_vidimazione;

    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private Parco_mezzi mezzo;

    public Biglietto() {
    }

    public Biglietto(Emittente emittente) {
        super(emittente);
    }

    public LocalDate getDataVidimazione() {
        return data_vidimazione;
    }

    public void setDataVidimazione(LocalDate data_vidimazione) {

        this.data_vidimazione = data_vidimazione;
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
                ", data_vidimazione=" + data_vidimazione +
                ", mezzo=" + mezzo +
                '}';
    }
}
