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

        Tratta tra1FromDB = trd.trovaPerID("fe1f17ab-997b-49de-8dc2-453c14fc79f8");

        //ed.save(emi1);

        Emittente emFromDB = ed.trovaPerId("f0a23f1a-47b1-466a-8e79-12b8d5d56663");

        Bus bus1 = new Bus(Stato.IN_FUNZIONE, 2020, 2, 10, tra1FromDB);

        //pmd.saveParco_mezzi(bus1);

        Parco_mezzi bus1FromDB = pmd.findById("a154e129-6b6b-43ce-8028-5de5542ca08b");

        //System.out.println(bus1FromDB);

        Biglietto bigl = new Biglietto(2026, 8, 2, emFromDB, bus1FromDB);

        //bd.salvaBiglietto(bigl);

        System.out.println(bd.trovaBigliettoDaId("1a64861d-a4c6-487b-b8f2-24183c3d3c39"));

        System.out.println("Hello World!");
    }
}
