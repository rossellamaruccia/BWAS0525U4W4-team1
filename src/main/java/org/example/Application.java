package org.example;


import dao.*;
import entities.*;
import enums.FrequenzaAbbonamento;
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

        //Tratta tratta1 = new Tratta("piazza Manin 1", "via S. Francesco 2", 25);
        //trattad.save(tratta1);
        //Tratta tratta1FromDB = trattad.trovaPerID("9903e50b-128b-4960-9776-f95691353f36");
        //Bus bus1 = new Bus(Stato.IN_FUNZIONE, 2024, 4, 12, tratta1FromDB);
        //pmd.saveParco_mezzi(bus1);
        //Utente u2 = new Utente("Giovanni", "Pascoli", 1880, 12, 1);
        //ud.save(u2);
        //Utente u2FromDB = ud.getById("f7718a88-8c8a-4ad9-8fd6-621282a55678");
        //Tessera t1 = new Tessera(2026, 1, 27, u2FromDB);
        //td.salvaTessera(t1);
        Tessera t1FromDB = td.trovaTesseraDalNumero("39b64b97-ff8e-412e-8ca4-2cdc12fe0e92");

        //DistributoreAutomatico distributore2 = new DistributoreAutomatico(true);
        //ed.save(distributore2);
        Emittente distributore2FromDB = ed.trovaPerId("5b58a879-6115-4568-b6f5-8563ba8dcfb4");
        //distributore false non dovrebbe poter emettere biglietti

        //controllo su date abbonamento e tessera abbonamento non può avere data inferiore a tessera
        Abbonamento abb2 = new Abbonamento(2026, 1, 21, distributore2FromDB, FrequenzaAbbonamento.MENSILE, t1FromDB);
        //ad.save(abb2);
        Biglietto biglietto1 = new Biglietto(2026, 1, 10, distributore2FromDB);
        //bd.salvaBiglietto(biglietto1);

        Biglietto biglietto2 = new Biglietto(2026, 1, 12, distributore2FromDB);
        //bd.salvaBiglietto(biglietto2);
        Parco_mezzi bus1FromDB = pmd.findById("378c92e2-4530-462c-a1d2-8c023f6aff50");


        //ud.vidimaBiglietto("aae2a50e-3ab9-4867-a3e8-ff5e93b2027c", "378c92e2-4530-462c-a1d2-8c023f6aff50");
        ud.vidimaBiglietto("f12b0cf8-777c-40f7-889f-bf05e53711b0", "378c92e2-4530-462c-a1d2-8c023f6aff50");

        System.out.println(tdvd.cercaBigliettiVidimatiPerMezzo(bus1FromDB));

        System.out.println("Hello World!");

        em.close();
        emf.close();
    }

}
