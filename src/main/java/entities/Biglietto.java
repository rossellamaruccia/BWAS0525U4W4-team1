package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
 @Table(name = "biglietto")
public class Biglietto extends TitoloDiViaggio{

    @Column(name = "data_vidimazione")
    private LocalDate dataVidimazione;

}
