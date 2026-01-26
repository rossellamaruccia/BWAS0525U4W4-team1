package entities;

import jakarta.persistence.*;

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


    public Parco_mezzi() {
    }

    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


//    @Override
//    public String toString() {
//        return "Parco_mezzi{" +
//                "id=" + id +
//                ", capienza=" + capienza +
//                '}';
//    }
}
