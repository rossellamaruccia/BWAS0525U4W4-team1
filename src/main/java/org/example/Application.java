package org.example;


import dao.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        UtenteDAO ud = new UtenteDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        EmittenteDAO ed = new EmittenteDAO(em);
        AbbonamentoDAO ad = new AbbonamentoDAO(em);
        BigliettoDAO bd = new BigliettoDAO(em);
        Parco_mezziDAO pmd = new Parco_mezziDAO(em);
        TrattaDAO trattad = new TrattaDAO(em);
        TitoloDiViaggioDAO tdvd = new TitoloDiViaggioDAO(em);


        trattad.trovaPerID("c9b7efb9-0d23-404e-bae3-bd4675253995");
        pmd.findById("af70e450-f7ca-4bf7-b9bf-723e62a6667b");


        System.out.println("Hello World!");

        em.close();
        emf.close();
    }

}
