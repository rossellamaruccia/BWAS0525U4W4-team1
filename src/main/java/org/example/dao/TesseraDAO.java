package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Tessera;
import org.example.exceptions.NotFoundException;
import org.hibernate.annotations.NotFound;

public class TesseraDAO {

    private final EntityManager em;

    public TesseraDAO(EntityManager em){
        this.em=em;
    }

    public void salvaTessera(Tessera tessera){

        EntityTransaction transaction=em.getTransaction();

        transaction.begin();

        em.persist(tessera);

        transaction.commit();

        System.out.println("La tessera "+tessera.getNumTessera()+" é stata salvata con successo");
    }

    public Tessera trovaTesseraDalNumero(long numTessera){

        Tessera found=em.find(Tessera.class,numTessera);

        if (found==null){
            throw new NotFoundException(numTessera);
        }
        return found;
    }

    public void cancellaTesseraDalNumero(long numTessera) {
        Tessera found=trovaTesseraDalNumero(numTessera);

        EntityTransaction transaction=em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("Tessera con numero "+numTessera+" eliminata con successo");
    }

    }
