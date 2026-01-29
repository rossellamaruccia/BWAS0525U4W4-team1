package entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //DA DECIDERE
@DiscriminatorColumn(name = "tipo_emittente")
@Table(name = "emittenti")
public abstract class Emittente {

    @Id
    @GeneratedValue
    private UUID emittenteId;
    // questo valore va collegato al biglietto

    @OneToMany(mappedBy = "id")
    private List<TitoloDiViaggio> titoliDiViaggio;

    public Emittente() {
    }

    public UUID getId() {
        return emittenteId;
    }

    @Override
    public String toString() {
        return
                "id=" + emittenteId
                ;
    }

    public List<TitoloDiViaggio> getTitoliDiViaggio() {
        return titoliDiViaggio;
    }

    public UUID getEmittenteId() {
        return emittenteId;
    }


}
