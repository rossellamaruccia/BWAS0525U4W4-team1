package entities;

import exceptions.NotPossibleException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue
    @Column(name = "id_utente")
    private UUID utenteId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private LocalDate dataDiNascita;

    @OneToOne(mappedBy = "possessore")
    private Tessera tessera;

    public Utente() {
    }

    // costruttore con parametri
    public Utente(String nome, String cognome, int year, int month, int day) {
        this.nome = nome;
        this.cognome = cognome;
        if (LocalDate.of(year, month, day).isAfter(LocalDate.now())) {
            throw new NotPossibleException();
        }
        this.dataDiNascita = LocalDate.of(year, month, day);
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public UUID getUtenteId() {
        return utenteId;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public boolean haTessera() {
        return this.tessera != null;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + utenteId +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
