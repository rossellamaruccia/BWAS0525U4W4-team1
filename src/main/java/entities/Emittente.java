package entities;

import jakarta.persistence.*;

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
    
    public Emittente() {
    }

    public UUID getId() {
        return emittenteId;
    }
}
