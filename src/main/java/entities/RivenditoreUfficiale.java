package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("rivenditore")
public class RivenditoreUfficiale extends Emittente {
    public RivenditoreUfficiale() {
    }
}
