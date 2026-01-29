package org.example;


import dao.*;
import entities.*;
import exceptions.NotFoundException;
import exceptions.NotPossibleException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        UtenteDAO ud = new UtenteDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        TitoloDiViaggioDAO tdvd = new TitoloDiViaggioDAO(em);
        TrattaDAO trad = new TrattaDAO(em);
        Parco_mezziDAO pmd = new Parco_mezziDAO(em);
        ManutenzioneDAO md = new ManutenzioneDAO(em);

        EmittenteDAO ed = new EmittenteDAO(em);
        System.out.println("Hello World!");

        try {
            Utente u1 = new Utente("Enzo", "Ghinazzi", 1950, 2, 12);
            Utente u2 = new Utente("Stefano", "Casasola", 1978, 6, 7);
            Utente u1FromDB = ud.getById("90a9bee2-9eee-4c8f-99d6-39a3998eb3e0");
            //ud.save(u1);
            //ud.save(u2);

            Tessera t1 = new Tessera(u1FromDB);
            //td.salvaTessera(t1);

            DistributoreAutomatico d1 = new DistributoreAutomatico(true);
            DistributoreAutomatico d2 = new DistributoreAutomatico(false);
            //ed.save(d2);

            Emittente d1FromDB = ed.trovaPerId("d6e08f65-4edf-4932-8f7c-6961bb0b9222");
            Emittente d2FromDB = ed.trovaPerId("f2300d1b-b044-4d4e-9819-d4b304cba272");

            Biglietto b1 = new Biglietto(d1FromDB);
            //Biglietto b2 = new Biglietto(d2FromDB);
            //tdvd.salvaTitoloDiViaggio(b1);
            //tdvd.salvaTitoloDiViaggio(b2);

            Tratta tra1 = new Tratta("Piazza dei pesci", "Piazza dei cani", 20);
            //trad.save(tra1);

            Tratta tra1FromDB = trad.trovaPerID("af97da88-ccc6-470f-99b6-8ec948034b51");

            Bus bus1 = new Bus(tra1FromDB);
            //pmd.saveParco_mezzi(bus1);

            Parco_mezzi bus1FromDB = pmd.findById("8d5c9ffd-b136-4f48-9ee9-651b6b3a0218");
            //System.out.println(bus1FromDB);

            Manutenzione man1 = new Manutenzione(bus1FromDB);
            //md.save(man1);
            //md.fineManutenzione(bus1FromDB);

            Manutenzione man2 = new Manutenzione(bus1FromDB);
            Manutenzione man3 = new Manutenzione(bus1FromDB);
            //md.save(man2);
            md.save(man3);
            //md.fineManutenzione(bus1FromDB);

            //Abbonamento ab1 = new Abbonamento(d1, FrequenzaAbbonamento.SETTIMANALE, t1);
            //tdvd.salvaTitoloDiViaggio(ab1);

        } catch (NotFoundException | NotPossibleException ex) {
            System.out.println(ex.getMessage());
        }

        em.close();
        emf.close();
    }

}
