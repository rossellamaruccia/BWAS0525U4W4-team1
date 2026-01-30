package org.example;


import dao.*;
import entities.*;
import enums.FrequenzaAbbonamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        UtenteDAO ud = new UtenteDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        TitoloDiViaggioDAO tdvd = new TitoloDiViaggioDAO(em);
        Parco_mezziDAO pmd = new Parco_mezziDAO(em);
        EmittenteDAO ed = new EmittenteDAO(em);

        System.out.println(tdvd.trovaTitoliperEmittenteEDate("d0fb19a4-41f4-4405-be6e-2e6ad3c081f7", LocalDate.of(2026, 1, 29), LocalDate.of(2026, 1, 30)).size());

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("--- Benvenut* ---");
            try {
                System.out.println("Seleziona 1 se sei un utente, 2 se sei un amministratore");
                int scelta;
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
                                        Tessera tessera1 = new Tessera(utente);
                                        td.salvaTessera(tessera1);
                                        System.out.println("tessera creata con id: " + tessera1.getTesseraId());
                                        break;
                                    case 3:
                                        //trova scadenza tessera
                                        System.out.println("Inserisci il codice id della tua tessera: ");
                                        String id_tessera = scanner.nextLine();
                                        Tessera tessera2 = td.trovaTesseraDalNumero(id_tessera);
                                        System.out.println(tessera2.getDataScadenza());
                                        break;
                                    case 4:
                                        //comprare o rinnovare un abbonamento
                                        System.out.println("Inserisci il tuo numero di tessera:");
                                        Tessera tessera3 = td.trovaTesseraDalNumero(scanner.nextLine());
                                        if (tessera3.getAbbonamento() != null) {
                                            Abbonamento a1 = tessera3.getAbbonamento();
                                            tdvd.rinnovaAbbonamento(a1, a1.getDurata());
                                        } else {
                                            Emittente d1 = ed.trovaPerId("d0fb19a4-41f4-4405-be6e-2e6ad3c081f7");
                                            System.out.println("seleziona 1 per abbonamento settimanale, 2 per mensile");
                                            scelta = Integer.parseInt(scanner.nextLine());
                                            switch (scelta) {
                                                case 1:
                                                    Abbonamento a2 = new Abbonamento(d1, FrequenzaAbbonamento.SETTIMANALE, tessera3);
                                                    tdvd.salvaTitoloDiViaggio(a2);
                                                    System.out.println("Abbonamento con id: " + a2.getId() + "creato. Scadrà il " + a2.getDataScadenza());
                                                    break;
                                                case 2:
                                                    Abbonamento a3 = new Abbonamento(d1, FrequenzaAbbonamento.MENSILE, tessera3);
                                                    tdvd.salvaTitoloDiViaggio(a3);
                                                    System.out.println("Abbonamento con id: " + a3.getId() + "creato. Scadrà il " + a3.getDataScadenza());
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                        break;
                                    case 5:
                                        //comprare un biglietto
                                        Emittente d1 = ed.trovaPerId("d0fb19a4-41f4-4405-be6e-2e6ad3c081f7");
                                        Biglietto b1 = new Biglietto(d1);
                                        tdvd.salvaTitoloDiViaggio(b1);
                                        System.out.println("Biglietto acquistato! Scegli una tratta su cui Validarlo:");
                                        System.out.println("Premi 1 per tratta: via Cagliari 3 - via Bari 300");
                                        System.out.println("Premi 2 per tratta: via Palermo 2 - via Torino 200");
                                        System.out.println("Premi 3 per tratta: via Roma 1 - via Milano 100");
                                        System.out.println("Premi 0 per uscire.");
                                        scelta = Integer.parseInt(scanner.nextLine());
                                        switch (scelta) {
                                            case 1:
                                                Parco_mezzi bus1 = pmd.findById("2dce0f07-d0bc-4569-8edb-4c370d673260");
                                                ud.vidimaBiglietto(b1, bus1);
                                                break;
                                            case 2:
                                                Parco_mezzi tram1 = pmd.findById("39d11496-2526-4521-add6-986493666629");
                                                ud.vidimaBiglietto(b1, tram1);
                                                break;
                                            case 3:
                                                Parco_mezzi bus2 = pmd.findById("b110a465-181b-45d8-ba90-d37760db4dd5");
                                                ud.vidimaBiglietto(b1, bus2);
                                                break;
                                            case 0:
                                                System.out.println("Grazie e arrivederci!");
                                                break;
                                        }
                                    default:
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Seleziona 1 per creare il tuo profilo utente, 2 per comprare un biglietto senza registrarti, 0 per uscire. ");
                                scelta = Integer.parseInt(scanner.nextLine());
                                switch (scelta) {
                                    case 1:
                                        System.out.println("Inserisci il tuo nome: ");
                                        String nome = scanner.nextLine();
                                        System.out.println("Inserisci il tuo cognome: ");
                                        String cognome = scanner.nextLine();
                                        System.out.println("Inserisci il tuo anno di nascita");
                                        int anno = Integer.parseInt(scanner.nextLine());
                                        System.out.println("Inserisci il tuo mese di nascita");
                                        int mese = Integer.parseInt(scanner.nextLine());
                                        System.out.println("Inserisci il tuo giorno di nascita");
                                        int giorno = Integer.parseInt(scanner.nextLine());
                                        Utente u2 = new Utente(nome, cognome, anno, mese, giorno);
                                        ud.save(u2);

                                        break;
                                    case 2:
                                        //comprare un biglietto
                                        Emittente d1 = ed.trovaPerId("d0fb19a4-41f4-4405-be6e-2e6ad3c081f7");
                                        Biglietto b1 = new Biglietto(d1);
                                        tdvd.salvaTitoloDiViaggio(b1);
                                        System.out.println("Biglietto acquistato! Scegli una tratta su cui Validarlo:");
                                        System.out.println("Premi 1 per tratta: via Cagliari 3 - via Bari 300");
                                        System.out.println("Premi 2 per tratta: via Palermo 2 - via Torino 200");
                                        System.out.println("Premi 3 per tratta: via Roma 1 - via Milano 100");
                                        System.out.println("Premi 0 per uscire.");
                                        scelta = Integer.parseInt(scanner.nextLine());
                                        switch (scelta) {
                                            case 1:
                                                Parco_mezzi bus1 = pmd.findById("2dce0f07-d0bc-4569-8edb-4c370d673260");
                                                ud.vidimaBiglietto(b1, bus1);
                                                break;
                                            case 2:
                                                Parco_mezzi tram1 = pmd.findById("39d11496-2526-4521-add6-986493666629");
                                                ud.vidimaBiglietto(b1, tram1);
                                                break;
                                            case 3:
                                                Parco_mezzi bus2 = pmd.findById("b110a465-181b-45d8-ba90-d37760db4dd5");
                                                ud.vidimaBiglietto(b1, bus2);
                                                break;
                                            case 0:
                                                System.out.println("Grazie e arrivederci!");
                                                break;
                                        }
                                    case 0:
                                        System.out.println("Grazie e arrivederci!");
                                }
                                break;
                            default:
                                break;
                        }
                    case 2:
                        ;
                        //amministratore

//                    case 0:
//                        running = false;
//                        System.out.println("Grazie e arrivederci!");
//                        break;
                    default:
                        System.out.println("Hai inserito un valore non valido. Riprova.");
                        break;

                }
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("L'operazione non è andata a buon fine. Hai inserito un dato non valido. Riprova!");
            }
        }

        em.close();
        emf.close();
    }

}
