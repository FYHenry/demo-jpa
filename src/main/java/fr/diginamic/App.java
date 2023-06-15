package fr.diginamic;

import fr.diginamic.entities.Livre;
import jakarta.persistence.*;


public class App {
    public static void main(String[] args) {
        try(EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("demo-jpa-bis");
            EntityManager em = emf.createEntityManager()){
            printLivre(em, 2);
            em.getTransaction().begin();
            final Livre livre = new Livre("Titre", "Auteur");
            em.persist(livre);
            printLivreFromQuery(em, "SELECT l FROM Livre l " +
                    "WHERE l.auteur='Auteur' " +
                    "AND l.titre='Titre'");
            livre.setTitre("Titre autre");
            printLivreFromQuery(em, "SELECT l FROM Livre l " +
                    "WHERE l.auteur='Auteur' " +
                    "AND l.titre='Titre autre'");
            em.remove(livre);
            em.getTransaction().commit();
            if(em.find(Livre.class, 6) == null){
                System.out.println("Livre n°6 supprimé.");
            } else {
                System.out.println("Livre n°6 gardé.");
            }
            modifyLivreTitre(em, 5, "Du plaisir dans la cuisine");
            String[] queries ={"SELECT l FROM Livre l",
                    "SELECT l FROM Livre l WHERE l.auteur='Emile Zola'",
                    "SELECT l FROM Livre l WHERE " +
                            "l.titre='Apprendre à parler aux animaux'"};
            for (String query: queries) {
                printLivreFromQuery(em, query);
            }
        }
    }
    private static void printLivre(EntityManager em, int id){
        final Livre livre = em.find(Livre.class, id);
        if(livre != null){
            System.out.println(livre);
        } else {
            System.out.println("NULL");
        }
    }
    private static void modifyLivreTitre(EntityManager em,
                               int id,
                               String nouveauTitre){
        final Livre livre = em.find(Livre.class, id);
        if(livre != null){
            em.getTransaction().begin();
            livre.setTitre(nouveauTitre);
            em.getTransaction().commit();
        } else {
            System.out.println("NULL");
        }
    }
    private static void printLivreFromQuery(EntityManager em, String query){
        final TypedQuery<Livre> q = em.createQuery(query, Livre.class);
        for (Livre l : q.getResultList()) {
            System.out.println(l);
        }

    }
}
