package org.example;


import dao.*;
import entities.Parco_mezzi;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        UtenteDAO ud = new UtenteDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        EmittenteDAO ed = new EmittenteDAO(em);
        AbbonamentoDAO ad = new AbbonamentoDAO(em);
        BigliettoDAO bd = new BigliettoDAO(em);
        Parco_mezziDAO pmd = new Parco_mezziDAO(em);
        TrattaDAO trattad = new TrattaDAO(em);
        TitoloDiViaggioDAO tdvd = new TitoloDiViaggioDAO(em);

//        Tratta tratta1 = new Tratta("piazza Manin 1", "via S. Francesco 2", 25);
//        trattad.save(tratta1);
        // Bus bus1 = new Bus(Stato.IN_FUNZIONE, 2024, 4, 12, tratta1);
//        pmd.saveParco_mezzi(bus1);
        //Utente u2 = new Utente("Giovanni", "Pascoli", 1880, 12, 1);
        //ud.save(u2);

        //Tessera t1 = new Tessera(2026, 1, 27, u1);
        //td.salvaTessera(t1);

//        DistributoreAutomatico distributore3 = new DistributoreAutomatico(true);
//        ed.save(distributore3);
        //distributore false non dovrebbe poter emettere biglietti

        //controllo su date abbonamento e tessera abbonamento non può avere data inferiore a tessera
        //Abbonamento abb2 = new Abbonamento(2026, 1, 21, distributore2, FrequenzaAbbonamento.MENSILE, t1);
        //ad.save(abb2);
        //Biglietto biglietto1 = new Biglietto(2026, 1, 10, distributore2);
        //bd.salvaBiglietto(biglietto1);

//        Biglietto biglietto2 = new Biglietto(2026, 1, 12, distributore3);
//        bd.salvaBiglietto(biglietto2);
        Parco_mezzi bus1 = pmd.findById("17e2c1a3-e716-4e17-b0c9-55d8442e5c7b");


        //ud.vidimaBiglietto("b5cd79de-77e1-452d-9518-2122fcf17f9d", "17e2c1a3-e716-4e17-b0c9-55d8442e5c7b");


        System.out.println("Hello World!");

        em.close();
        emf.close();
    }

}
