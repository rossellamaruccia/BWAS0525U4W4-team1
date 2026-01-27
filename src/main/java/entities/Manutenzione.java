package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Manutenzione")
public class Manutenzione {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private LocalDate data_inizio;
    @Column
    private LocalDate data_fine;
    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private Parco_mezzi id_mezzo;

    public Manutenzione(){};
public Manutenzione (LocalDate data_inizio,LocalDate data_fine,Parco_mezzi id_mezzo){
    this.data_inizio=data_inizio;
    this.data_fine=data_fine;
    this.id_mezzo=id_mezzo;
};

    public UUID getId() {
        return id;
    }

    public LocalDate getData_inizio() {
        return data_inizio;
    }

    public LocalDate getData_fine() {
        return data_fine;
    }

    public Parco_mezzi getId_mezzo() {
        return id_mezzo;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setData_inizio(LocalDate data_inizio) {
        this.data_inizio = data_inizio;
    }

    public void setData_fine(LocalDate data_fine) {
        this.data_fine = data_fine;
    }

    public void setId_mezzo(Parco_mezzi id_mezzo) {
        this.id_mezzo = id_mezzo;
    }

    @Override
    public String toString() {
        return "Manutenzione{" +
                "id=" + id +
                ", data_inizio=" + data_inizio +
                ", data_fine=" + data_fine +
                ", id_mezzo=" + id_mezzo +
                '}';
    }
}
