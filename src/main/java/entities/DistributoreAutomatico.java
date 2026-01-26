package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("distributore_automatico")
public class DistributoreAutomatico extends Emittente {
    @Column(name = "in_servizio")
    private boolean in_servizio;

    public DistributoreAutomatico() {
    }

    public DistributoreAutomatico(boolean in_servizio) {
        this.in_servizio = in_servizio;
    }

    public boolean isIn_servizio() {
        return in_servizio;
    }

    public void setIn_servizio(boolean in_servizio) {
        this.in_servizio = in_servizio;
    }
}
