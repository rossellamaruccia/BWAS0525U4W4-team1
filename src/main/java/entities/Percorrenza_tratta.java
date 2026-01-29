package entities;

import exceptions.NotPossibleException;
import jakarta.persistence.*;

@Entity
@Table(name = "percorrenze_per_tratta")
public class Percorrenza_tratta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "tratta")
    private Tratta tratta;

    @ManyToOne
    @JoinColumn(name = "mezzo")
    private Parco_mezzi mezzo;

//    @Column(name = "percorrenza_standard")
//    private double percorrenza_standard;

    @Column(name = "percorrenza_effettiva")
    private double percorrenza_effettiva;

//    @Column(name = "partenza")
//    private String partenza;
//
//    @Column(name = "capolinea")
//    private String capolinea;

    public Percorrenza_tratta() {
    }

    public Percorrenza_tratta(Tratta tratta, Parco_mezzi mezzo, double percorrenza_effettiva) {
        this.tratta = tratta;
        if (mezzo.getTratta() == tratta) {
            this.mezzo = mezzo;
        } else {
            throw new NotPossibleException();
        }
        this.percorrenza_effettiva = percorrenza_effettiva;
    }

    public double getPercorrenza_standard() {
        return tratta.getTempo_percorrenza_standard();
    }

    public double getPercorrenza_effettiva() {
        return percorrenza_effettiva;
    }

    public String getPartenza() {
        return tratta.getPartenza();
    }

    public String getCapolinea() {
        return tratta.getCapolinea();
    }


}
