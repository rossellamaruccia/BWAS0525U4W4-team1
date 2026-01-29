package org.example;


import dao.*;
import entities.Bus;
import entities.Manutenzione;
import entities.Parco_mezzi;
import entities.Tratta;
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

            Tratta tra1 = new Tratta("Piazza piatta", "Piazza chiatta", 15);
            //trad.save(tra1);
            //Tratta tra1FromDB = trad.trovaPerID("323bda3a-6a9c-4eb9-97e7-4eb9032ba30e");

            Bus bus1 = new Bus(tra1);
            //pmd.saveParco_mezzi(bus1);
            Parco_mezzi bus1FromDB = pmd.findById("7de303d1-0a28-4f78-952a-588b392f2684");

            Manutenzione m1 = new Manutenzione(bus1FromDB);
            Manutenzione m2 = new Manutenzione(bus1FromDB);
            //md.save(m1);
            //md.save(m2);

            //md.fineManutenzione(bus1FromDB);

            //TypedQuery<Manutenzione> query = em.createQuery("SELECT m FROM Manutenzione m WHERE m.statoManutenzione = IN_CORSO", Manutenzione.class);
            //Manutenzione found = query.getSingleResultOrNull();
            //System.out.println(found);

            //md.trovaPerIdEcancella("31827cde-2398-4781-abff-bf064e02a8e9");
            //md.trovaPerIdEcancella("389aaa2a-cd12-4fb2-84b3-94204d50ebef");
            //md.trovaPerIdEcancella("af0795f4-72bf-4663-af3f-555ef757ade3");
        } catch (NotPossibleException ex) {
            System.out.println(ex.getMessage());
        }

        em.close();
        emf.close();
    }

}
