package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //DA DECIDERE
public abstract class Emittente {

    @OneToMany(mappedBy = "emittente")
    List<TitoloDiViaggio> titoli_di_viaggio = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "emittente_id")
    private UUID id;

    public Emittente() {
    }

    public UUID getId() {
        return id;
    }
}
