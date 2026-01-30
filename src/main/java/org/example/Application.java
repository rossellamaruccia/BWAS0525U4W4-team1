package org.example;


import dao.*;
import entities.*;
import exceptions.NotPossibleException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {
            UtenteDAO ud = new UtenteDAO(em);
            TesseraDAO td = new TesseraDAO(em);
            TrattaDAO trad = new TrattaDAO(em);
            Parco_mezziDAO pmd = new Parco_mezziDAO(em);
            ManutenzioneDAO md = new ManutenzioneDAO(em);
            EmittenteDAO ed = new EmittenteDAO(em);
            TitoloDiViaggioDAO tdvd = new TitoloDiViaggioDAO(em);

            Tratta tratta1 = new Tratta("Piazza piatta", "Piazza matta", 15);
            //trad.save(tr1);
            Tratta tratta1FromDB = trad.trovaPerID("2748ffeb-1e75-4498-b4f2-a6a2fa162561");

            Tram tram1 = new Tram(tratta1FromDB);
            //pmd.saveParco_mezzi(tram1);
            Parco_mezzi tram1FromDB = pmd.findById("6ddd2281-26d6-41c9-8924-6ca061703cf6");

            Manutenzione man1 = new Manutenzione(tram1FromDB);
            //md.save(man1);

            //md.fineManutenzione(tram1FromDB);

            RivenditoreUfficiale riv1 = new RivenditoreUfficiale();
            //ed.save(em1);
            Emittente riv1FromDB = ed.trovaPerId("bd84c61b-f115-4d1d-9e09-052d98e1a23d");


            Biglietto b1 = new Biglietto(riv1FromDB);
            Biglietto b2 = new Biglietto(riv1FromDB);
            Biglietto b3 = new Biglietto(riv1FromDB);
            Biglietto b4 = new Biglietto(riv1FromDB);
//            tdvd.salvaTitoloDiViaggio(b1);
//            tdvd.salvaTitoloDiViaggio(b2);
//            tdvd.salvaTitoloDiViaggio(b3);
//            tdvd.salvaTitoloDiViaggio(b4);

            //ud.vidimaBiglietto("17a02a9d-8f4a-4f26-9145-f047f2a20898", "6ddd2281-26d6-41c9-8924-6ca061703cf6");
            //ud.vidimaBiglietto("2c1df233-3656-4b9f-86cf-245237999891", "6ddd2281-26d6-41c9-8924-6ca061703cf6");

            //System.out.println(tdvd.bigliettiVidimatiPerMezzo(tram1FromDB));

            //System.out.println(md.manutenzioniPerMezzo(tram1FromDB));

        } catch (NotPossibleException ex) {
            System.out.println(ex.getMessage());
        }

        em.close();
        emf.close();
    }

}
