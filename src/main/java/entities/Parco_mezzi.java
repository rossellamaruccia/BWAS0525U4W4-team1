package entities;

import enums.Stato;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Stato stato;
    @Column
    private LocalDate data_attivazione;

    @OneToOne
    @JoinColumn(name = "tratta_associata")
    private Tratta tratta;


    public Parco_mezzi() {
    }


    public Parco_mezzi(Stato stato, int year, int month, int day, Tratta tratta) {
        this.stato = stato;
        this.data_attivazione = LocalDate.of(year, month, day);
        this.tratta = tratta;
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

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public LocalDate getData_attivazione() {
        return data_attivazione;
    }

    public void setData_attivazione(LocalDate data_attivazione) {
        this.data_attivazione = data_attivazione;
    }

    public Tratta getTratta() {
        return tratta;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", stato=" + stato +
                        ", data_attivazione=" + data_attivazione
                ;
    }
}
