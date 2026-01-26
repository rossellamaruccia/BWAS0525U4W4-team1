package org.example;

import dao.EmittenteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EmittenteDAO emittenteDAO = new EmittenteDAO(em);

        //DistributoreAutomatico distributore1 = new DistributoreAutomatico(true);
        //emittenteDAO.save(distributore1);
        emittenteDAO.setFuoriServizio(1);

        em.close();
        emf.close();
        System.out.println("Hello World!");
    }
}
