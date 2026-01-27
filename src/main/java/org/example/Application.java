package org.example;

import dao.TesseraDAO;
import dao.TitoloDiViaggioDAO;
import entities.Abbonamento;
import entities.Tessera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        TesseraDAO td = new TesseraDAO(em);
        Tessera tessera1 = new Tessera(2026, 1, 27);
        TitoloDiViaggioDAO tdvd = new TitoloDiViaggioDAO(em);
        Abbonamento abbonamento1 = new Abbonamento(30, tessera1);
        tdvd.save(abbonamento1);

        em.close();
        emf.close();
        System.out.println("Hello World!!");
    }
}
