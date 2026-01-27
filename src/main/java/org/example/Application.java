package org.example;

import dao.Parco_mezziDAO;
import dao.TesseraDAO;
import dao.UtenteDAO;
import entities.Tessera;
import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Parco_mezziDAO pmd = new Parco_mezziDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        //EmittenteDAO ed = new EmittenteDAO(em);

        //Bus bus = new Bus();
        //Tram tram = new Tram();

        //pmd.saveParco_mezzi(bus);
        //pmd.saveParco_mezzi(tram);

        Utente pupoFromDB = ud.getById("b61611fc-0d08-45c9-9513-c80614f0424e");

        Tessera tessera = new Tessera(2026, 1, 10, pupoFromDB);

        td.salvaTessera(tessera);

        //Utente utente = new Utente("Enzo", "Ghinazzi", 190);

        //ud.save(utente);

        //DistributoreAutomatico automatic = new DistributoreAutomatico(true);

        //RivenditoreUfficiale official = new RivenditoreUfficiale();

        //ed.save(automatic);
        //ed.save(official);

        em.close();
        emf.close();

    }

}
