package entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Tratta {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "partenza")
    private String partenza;
    @Column(name = "capolinea")
    private String capolinea;
    @Column(name = "tempo_percorrenza_standard")
    private double tempo_percorrenza_standard;


    public Tratta() {
    }

    public Tratta(String partenza, String capolinea, double tempo_percorrenza_standard) {
        this.partenza = partenza;
        this.capolinea = capolinea;
        this.tempo_percorrenza_standard = tempo_percorrenza_standard;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public double getTempo_percorrenza_standard() {
        return tempo_percorrenza_standard;
    }

    public void setTempo_percorrenza_standard(double tempo_percorrenza_standard) {
        this.tempo_percorrenza_standard = tempo_percorrenza_standard;
    }
}
