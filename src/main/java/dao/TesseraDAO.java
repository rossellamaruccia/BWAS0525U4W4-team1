package dao;

import entities.Tessera;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
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

        //System.out.println("La tessera " + tessera.getIdTessera() + " é stata salvata con successo");
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

        //System.out.println("Tessera con numero " + numTessera + " eliminata con successo");
    }

    public boolean verificaValiditaTessera(Tessera tessera) {
        if (tessera.getDataScadenza().isBefore(LocalDate.now())) {
            //System.out.println("La tua tessera é scaduta");
            return false;
        } else {
            //System.out.println("La tua tessera é valida fino al " + tessera.getDataScadenza());
            return true;
        }
    }

    public void rinnovaTessera(Tessera tessera) {
        this.verificaValiditaTessera(tessera);

        if (!this.verificaValiditaTessera(tessera)) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            tessera.setDataScadenza();

            transaction.commit();

            //System.out.println("La tua tessera é stato rinnovato fino al " + tessera.getDataScadenza());

        }
    }
}
