package org.example;

import dao.Parco_mezziDAO;
import entities.Bus;
import entities.Stato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

import static entities.Stato.IN_FUNZIONE;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
        System.out.println("Hello World!!");
    }
}
