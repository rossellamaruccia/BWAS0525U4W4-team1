package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("rivenditore")
public class RivenditoreUfficiale extends Emittente {

    public RivenditoreUfficiale() {
    }

    @Override
    public String toString() {
        return "Rivenditore{" + super.toString() + "}";
    }
}
