package org.example;

import dao.Parco_mezziDAO;
import entities.Bus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Parco_mezziDAO ad= new Parco_mezziDAO(em);
        Bus c1=new Bus();
        ad.saveParco_mezzi(c1);
        em.close();
        emf.close();
        System.out.println("Hello World!!");

    }


}
