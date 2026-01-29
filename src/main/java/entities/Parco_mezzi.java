package entities;

import enums.StatoMezzo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Parco_mezzi")
@DiscriminatorColumn(name = "tipo_mezzo")
public abstract class Parco_mezzi {
    @Id
    @GeneratedValue
    @Column(name = "id_mezzo")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatoMezzo stato;
    @Column
    private LocalDate data_attivazione;

    @OneToOne
    @JoinColumn(name = "tratta_associata")
    private Tratta tratta;

    @OneToMany(mappedBy = "mezzo")
    private List<Manutenzione> manutenzioni;

    public Parco_mezzi() {
    }


    public Parco_mezzi(Tratta tratta) {
        this.data_attivazione = LocalDate.now();
        this.tratta = tratta;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Manutenzione> getManutenzioni() {
        return manutenzioni;
    }

    public StatoMezzo getStatoMezzo() {
        return stato;
    }

    public void setStatoMezzo(StatoMezzo stato) {
        this.stato = stato;
    }

    public LocalDate getData_attivazione() {
        return data_attivazione;
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
