package org.example;

import dao.Parco_mezziDAO;
import entities.Bus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Parco_mezziDAO pmd = new Parco_mezziDAO(em);

        Bus bus = new Bus();

        pmd.saveParco_mezzi(bus);

        em.close();
        emf.close();

    }

}
