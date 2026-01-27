package entities;

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

    public Utente() {
    }

    // costruttore con parametri
    public Utente(String nome, String cognome, int year, int month, int day) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = LocalDate.of(year, month, day);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getEta() {
        return dataDiNascita;
    }

    public void setDataDiNascita(int year, int month, int day) {
        this.dataDiNascita = LocalDate.of(year, month, day);
    }

    public UUID getUtenteId() {
        return utenteId;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
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
