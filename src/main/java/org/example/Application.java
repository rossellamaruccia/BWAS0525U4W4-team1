package org.example;


import dao.*;
import entities.DistributoreAutomatico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        UtenteDAO ud = new UtenteDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        TitoloDiViaggioDAO tdvd = new TitoloDiViaggioDAO(em);
        TrattaDAO trd = new TrattaDAO(em);
        Parco_mezziDAO pmd = new Parco_mezziDAO(em);
        EmittenteDAO ed = new EmittenteDAO(em);

//        Utente u1 = new Utente("Rossella", "Maruccia", 1994, 2, 6);
//        Tratta t1 = new Tratta("via Roma 1", "via Milano 100", 25);
//        Tratta t2 = new Tratta("via Torino 2", "via Palermo 200", 32);
//        Tratta t3 = new Tratta("via Cagliari 3", "via Bari 300", 50);
//        trd.save(t1);
//        trd.save(t2);
//        trd.save(t3);
//        Bus bus1 = new Bus(t1);
//        Tram tram1 = new Tram(t2);
//        Bus bus2 = new Bus(t3);
//        pmd.saveParco_mezzi(bus1);
//        pmd.saveParco_mezzi(tram1);
//        pmd.saveParco_mezzi(bus2);

        DistributoreAutomatico dis1 = new DistributoreAutomatico(false);
        //ed.save(dis1);
        //ed.rimettiInFunzioneDistributore("bd84c61b-f115-4d1d-9e09-052d98e1a23d");


        em.close();
        emf.close();
    }

}
