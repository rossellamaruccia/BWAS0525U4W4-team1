package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("rivenditore_ufficiale")
public class RivenditoreUfficiale extends Emittente {
    public RivenditoreUfficiale() {
    }
}
