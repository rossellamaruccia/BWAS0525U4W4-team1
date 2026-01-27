package dao;

import entities.Parco_mezzi;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
// manca import Biglietto
import java.time.LocalDateTime;
import java.util.UUID;

public class VidimazioneDAO {
    private final EntityManager em;

    public VidimazioneDAO(EntityManager em) {
        this.em = em;
    }

    // metodo
    public void vidimaBiglietto(UUID bigliettoId, UUID mezzoId) {
        // cerco il mezzo su parco mezzi
        Parco_mezzi mezzo = em.find(Parco_mezzi.class, mezzoId);
        if (mezzo == null) {
            System.out.println("Mezzo non trovato");
            return;
        }

        Biglietto biglietto = em.find(Biglietto.class, bigliettoId);
        if (biglietto == null) {
            System.out.println("Biglietto non trovato");
            return;
        }

        // transazione
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // data vidimazione
        biglietto.setDataVidimazione(LocalDateTime.now());
        //salva modifica
        transaction.commit();
        System.out.println("Biglietto vidimato sul mezzo " + mezzoId);
    }

}
