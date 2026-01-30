package org.example;


import dao.*;
import exceptions.NotPossibleException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {
            UtenteDAO ud = new UtenteDAO(em);
            TesseraDAO td = new TesseraDAO(em);
            TrattaDAO trad = new TrattaDAO(em);
            Parco_mezziDAO pmd = new Parco_mezziDAO(em);
            ManutenzioneDAO md = new ManutenzioneDAO(em);
            EmittenteDAO ed = new EmittenteDAO(em);
            TitoloDiViaggioDAO tdvd = new TitoloDiViaggioDAO(em);


        } catch (NotPossibleException ex) {
            System.out.println(ex.getMessage());
        }

        em.close();
        emf.close();
    }

}
