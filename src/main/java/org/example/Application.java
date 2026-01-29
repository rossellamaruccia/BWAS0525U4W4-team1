package org.example;


import dao.TesseraDAO;
import dao.UtenteDAO;
import entities.Tessera;
import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        UtenteDAO ud = new UtenteDAO(em);
        TesseraDAO td = new TesseraDAO(em);

        Utente u1 = new Utente("Rossella", "Maruccia", 1994, 2, 6);


        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("--- Benvenut* ---");
            System.out.println("Seleziona 1 se sei un utente, 2 se sei un amministratore. ");

            int scelta;
            try {
                scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1:
                        //utente
                        System.out.println("Seleziona 1 se sei registrato, altrimenti seleziona 2.");
                        scelta = Integer.parseInt(scanner.nextLine());
                        switch (scelta) {
                            case 1:
                                System.out.println("---menu----");
                                System.out.println("seleziona 1 per cancellare il tuo profilo");
                                System.out.println("seleziona 2 per creare la tua tessera");
                                System.out.println("seleziona 3 per controllare la scadenza della tua tessera");
                                System.out.println("seleziona 4 per comprare o rinnovare un abbonamento");
                                System.out.println("seleziona 5 per comprare un biglietto");
                                System.out.println("seleziona 6 per scegliere una tratta");
                                System.out.println("seleziona 0 per uscire");
                                scelta = Integer.parseInt(scanner.nextLine());
                                switch (scelta) {
                                    case 1:
                                        //cancella utente
                                        System.out.println("Inserisci il codice id del tuo profilo utente");
                                        ud.removeById((scanner.nextLine()));
                                        break;
                                    case 2:
                                        //crea tessera
                                        System.out.println("Inserisci il codice id del tuo profilo utente: ");
                                        String id_utente = scanner.nextLine();
                                        Utente utente = ud.getById(id_utente);
                                        Tessera t1 = new Tessera(utente);
                                        td.salvaTessera(t1);
                                        System.out.println("tessera creata con id: " + t1.getTesseraId());
                                        break;
                                    case 3:
                                        //trova scadenza tessera
                                        System.out.println("Inserisci il codice id della tua tessera: ");
                                        String id_tessera = scanner.nextLine();
                                        Tessera t2 = td.trovaTesseraDalNumero(id_tessera);
                                        System.out.println(t2.getDataScadenza());
                                        break;
                                    case 4:
                                        ;
                                    case 5:
                                        ;
                                    default:
                                        System.out.println("Hai inserito un valore non valido, scemo");
                                        break;
                                }

                                break;
                            case 2:
                                System.out.println("Seleziona 1 per creare il tuo profilo utente, 2 per comprare un biglietto senza registrarti. ");
                                break;
                            default:
                                System.out.println("Hai inserito un valore non valido, scemo");
                                break;
                        }
                    case 2:
                        //amministratore

//                    case 0:
//                        running = false;
//                        System.out.println("Grazie e arrivederci!");
//                        break;
                    default:
                        System.out.println("Selezione non valida.");
                        break;
                }
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Errore");
            }
        }


        em.close();
        emf.close();
    }

}
