package org.example;

import dao.*;
import entities.*;
import enums.Stato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        TitoloDiViaggioDAO td = new TitoloDiViaggioDAO(em);
        EmittenteDAO ed = new EmittenteDAO(em);
        RivenditoreUfficiale emi1 = new RivenditoreUfficiale();
        Parco_mezziDAO pmd = new Parco_mezziDAO(em);
        TrattaDAO trd = new TrattaDAO(em);
        BigliettoDAO bd = new BigliettoDAO(em);

        Tratta tra1 = new Tratta("Piazza Santa", "Piazza piatta", 20);

        //trd.save(tra1);

        Tratta tra1FromDB = trd.trovaPerID("f80b46a3-e82a-4f7a-8f78-331af6578477");

        //ed.save(emi1);

        Emittente emFromDB = ed.trovaPerId("972fd782-7726-4662-9f2a-392c1da4a879");

        Bus bus1 = new Bus(Stato.IN_FUNZIONE, 2020, 2, 10, tra1FromDB);

        //pmd.saveParco_mezzi(bus1);

        Parco_mezzi bus1FromDB = pmd.findById("d7f907e4-4f23-4bd2-a482-1241d0fbb5cb");

        //System.out.println(bus1FromDB);

        Biglietto bigl = new Biglietto(2026, 8, 2, emFromDB, bus1FromDB);

        //bd.salvaBiglietto(bigl);

        System.out.println("Hello World!");
    }
}
