package entities;

import java.util.UUID;

public abstract class Parco_mezzi {
    private UUID id;
    private int capienza;
    public Parco_mezzi(UUID id,int capienza){
        this.id=id;
        this.capienza=capienza;
    }

    public UUID getId() {
        return id;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }
}
