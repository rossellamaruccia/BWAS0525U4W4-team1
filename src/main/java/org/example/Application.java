package org.example;

import dao.EmittenteDAO;
import entities.DistributoreAutomatico;
import entities.RivenditoreUfficiale;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EmittenteDAO emittdao = new EmittenteDAO(em);
        DistributoreAutomatico distrib1 = new DistributoreAutomatico(true);

        DistributoreAutomatico distrib2 = new DistributoreAutomatico(false);

        RivenditoreUfficiale riven1 = new RivenditoreUfficiale();

        RivenditoreUfficiale riven2 = new RivenditoreUfficiale();
        emittdao.save(distrib1);
        emittdao.save(distrib2);
        emittdao.save(riven1);
        emittdao.save(riven2);

        em.close();
        emf.close();
        System.out.println("Hello World!!");
    }
}
