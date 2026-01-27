package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String cognome;
    private LocalDate data_di_nascita;

    public Utente() {
    }

    // costruttore con parametri
    public Utente(String nome, String cognome, int yyyy, int dd, int mm) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_di_nascita = LocalDate.of(yyyy, mm, dd);
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

    public LocalDate getDataDiNascita() {
        return data_di_nascita;
    }

    public void setEta(int yyyy, int mm, int dd) {
        this.data_di_nascita = LocalDate.of(yyyy, mm, dd);
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                '}';
    }
}
