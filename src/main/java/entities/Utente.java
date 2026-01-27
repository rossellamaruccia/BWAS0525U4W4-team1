package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue
    private UUID utenteId;


    private String nome;
    private String cognome;
    private int eta;

    public Utente() {
    }

    // costruttore con parametri
    public Utente(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;

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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public UUID getUtenteId() {
        return utenteId;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + utenteId +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                '}';
    }
}
