package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Parco_mezzi")
@DiscriminatorColumn(name = "mezzo")
public abstract class Parco_mezzi {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;
    @Column (nullable = false)
    private Stato stato;
    @Column
    private LocalDate data_attivazione;
    @Column
    private double percorrenza_effettivaKm;
    @Column
    private int num_percorrenze;

    public Parco_mezzi(){};
    public Parco_mezzi(Stato stato,LocalDate data_attivazione,double percorrenza_effettivaKm,int num_percorrenze) {
        this.stato=stato;
        this.data_attivazione=data_attivazione;
        this.percorrenza_effettivaKm=percorrenza_effettivaKm;
        this.num_percorrenze=num_percorrenze;
    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public Stato getStato() {
        return stato;
    }

    public LocalDate getData_attivazione() {
        return data_attivazione;
    }

    public double getPercorrenza_effettivaKm() {
        return percorrenza_effettivaKm;
    }

    public int getNum_percorrenze() {
        return num_percorrenze;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setData_attivazione(LocalDate data_attivazione) {
        this.data_attivazione = data_attivazione;
    }

    public void setPercorrenza_effettivaKm(double percorrenza_effettivaKm) {
        this.percorrenza_effettivaKm = percorrenza_effettivaKm;
    }

    public void setNum_percorrenze(int num_percorrenze) {
        this.num_percorrenze = num_percorrenze;
    }

    @Override
    public String toString() {
        return "Parco_mezzi{" +
                "id=" + id +
                ", stato=" + stato +
                ", data_attivazione=" + data_attivazione +
                ", percorrenza_effettivaKm=" + percorrenza_effettivaKm +
                ", num_percorrenze=" + num_percorrenze +
                '}';
    }
}
