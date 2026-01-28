package org.example;

import dao.EmittenteDAO;
import dao.Parco_mezziDAO;
import dao.TitoloDiViaggioDAO;
import dao.TrattaDAO;
import entities.Biglietto;
import entities.Bus;
import entities.DistributoreAutomatico;
import entities.Tratta;
import enums.Stato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");
        EntityManager em = emf.createEntityManager();

        EmittenteDAO ed = new EmittenteDAO(em);
        DistributoreAutomatico distributore1 = new DistributoreAutomatico(true);
        ed.save(distributore1);

        TrattaDAO td = new TrattaDAO(em);
        Tratta tratta9 = new Tratta("via Romero 4", "via Potjomkin 5", 32);
        td.save(tratta9);

        Parco_mezziDAO pmd = new Parco_mezziDAO(em);
        Bus bus7 = new Bus(Stato.IN_FUNZIONE, LocalDate.of(2024, 4, 2), tratta9);
        pmd.saveParco_mezzi(bus7);

        TitoloDiViaggioDAO tdvd = new TitoloDiViaggioDAO(em);
        Biglietto ticket1 = new Biglietto(LocalDate.of(2026, 1, 12), distributore1, bus7);
        tdvd.save(ticket1);
        System.out.println(tdvd.trovaTitoliperEmittenteEDate(UUID.fromString("450848dc-c36f-480e-8da4-bf9e968eb9f1"), LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 25)));

        System.out.println("Hello World!");
    }

}
