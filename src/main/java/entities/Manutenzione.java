package entities;

import enums.StatoManutenzione;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Manutenzione")
public class Manutenzione {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private LocalDate data_inizio;
    @Column
    private LocalDate data_fine;
    @ManyToOne
    @JoinColumn(name = "mezzo")
    private Parco_mezzi mezzo;

    @Enumerated(EnumType.STRING)
    private StatoManutenzione statoManutenzione;

    public Manutenzione() {
    }

    ;

    public Manutenzione(Parco_mezzi mezzo) {
        this.data_inizio = LocalDate.now();
        this.mezzo = mezzo;
    }

    ;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getData_inizio() {
        return data_inizio;
    }

    public LocalDate getData_fine() {
        return data_fine;
    }

    public Parco_mezzi getMezzo() {
        return mezzo;
    }

    public void setId_mezzo(Parco_mezzi id_mezzo) {
        this.mezzo = id_mezzo;
    }

    public void setFineManutenzione() {
        this.data_fine = LocalDate.now();
    }

    public StatoManutenzione getStatoManutenzione() {
        return statoManutenzione;
    }

    public void setStatoManutenzione(StatoManutenzione statoManutenzione) {
        this.statoManutenzione = statoManutenzione;
    }

    @Override
    public String toString() {
        return "Manutenzione{" +
                "id=" + id +
                ", data_inizio=" + data_inizio +
                ", data_fine=" + data_fine +
                ", mezzo=" + mezzo +
                '}';
    }
}
