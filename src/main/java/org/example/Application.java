import dao.UtenteDAO;
import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti");
        EntityManager em = emf.createEntityManager();

        UtenteDAO utenteDAO = new UtenteDAO(em);

        // Crea un utente
        Utente mario = new Utente("Mario", "Rossi", 30);
        utenteDAO.save(mario);

        em.close();
        emf.close();
    }
}