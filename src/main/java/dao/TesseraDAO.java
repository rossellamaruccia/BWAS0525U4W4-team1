package dao;

import entities.Tessera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import exceptions.NotFoundException;

import java.util.UUID;


public class TesseraDAO {

    private final EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaTessera(Tessera tessera) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(tessera);

        transaction.commit();

        System.out.println("La tessera " + tessera.getIdTessera() + " é stata salvata con successo");
    }

    public Tessera trovaTesseraDalNumero(String numTessera) {

        Tessera found = em.find(Tessera.class, UUID.fromString(numTessera));

        if (found == null) {
            throw new NotFoundException(numTessera);
        }
        return found;
    }

    public void cancellaTesseraDalNumero(String numTessera) {
        Tessera found = trovaTesseraDalNumero(numTessera);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("Tessera con numero " + numTessera + " eliminata con successo");
    }

}
