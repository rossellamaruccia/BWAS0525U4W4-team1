package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Abbonamento extends TitoloDiViaggio {
    @Column(name = "durata")
    private int durata;

    @OneToOne
    @JoinColumn(name = "tessera")
    private Tessera tessera;

    public Abbonamento() {
    }

    public Abbonamento(int durata, Tessera tessera) {
        this.durata = durata;
        this.tessera = tessera;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }
}
