package entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //DA DECIDERE

public abstract class Emittente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // questo valore va collegato al biglietto

    
    public Emittente() {
    }

    public long getId() {
        return id;
    }
}
