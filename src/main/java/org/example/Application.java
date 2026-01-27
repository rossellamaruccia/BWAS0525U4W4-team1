package org.example;

import dao.Parco_mezziDAO;
import dao.TesseraDAO;
import entities.Bus;
import entities.Stato;
import entities.Tessera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

import static entities.Stato.IN_FUNZIONE;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");
        EntityManager em = emf.createEntityManager();
        TesseraDAO td =new TesseraDAO(em);
        Tessera ab=new Tessera(2020,11,10);
        td.salvaTessera(ab);
        td.trovaTesseraDalNumero("6c55bb2a-6853-4d78-867d-80fd731c058b");
        em.close();
        emf.close();
        System.out.println("Hello World!!");
    }
}
