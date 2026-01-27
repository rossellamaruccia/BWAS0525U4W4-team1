package org.example;

import dao.Parco_mezziDAO;
import dao.PercorrenzaTrattaDAO;
import dao.TrattaDAO;
import entities.Bus;
import entities.Percorrenza_tratta;
import entities.Tratta;
import enums.Stato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");
        EntityManager em = emf.createEntityManager();

        Parco_mezziDAO pmd = new Parco_mezziDAO(em);
        TrattaDAO td = new TrattaDAO(em);
        PercorrenzaTrattaDAO ptd = new PercorrenzaTrattaDAO(em);

        Tratta tratta6 = new Tratta("via Marx 3", "via Engels 6", 21);
        Tratta tratta5 = new Tratta("via S.Martino 32", "via Lenin 56", 15);
        td.save(tratta6);
        td.save(tratta5);

        Bus bus5 = new Bus(Stato.IN_FUNZIONE, LocalDate.of(2025, 12, 23), tratta6);
        pmd.saveParco_mezzi(bus5);

        //Percorrenza_tratta pt4 = new Percorrenza_tratta(tratta6, bus5, 15);
        //Percorrenza_tratta pt5 = new Percorrenza_tratta(tratta6, bus5, 45);
        Percorrenza_tratta pt6 = new Percorrenza_tratta(tratta5, bus5, 35);

        //ptd.save(pt4);
        //ptd.save(pt5);
        ptd.save(pt6);

        em.close();
        emf.close();
        System.out.println("Hello World!!");
    }
}
