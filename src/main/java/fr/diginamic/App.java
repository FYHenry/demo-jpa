package fr.diginamic;

import fr.diginamic.entities.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        try(EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("demo-jpa");
            EntityManager em = emf.createEntityManager()){
            System.out.println("Salut.");
            Article article = em.find(Article.class, 2);
            if(article != null){
                System.out.println(article);
            }
            //em.getTransaction().begin();
            //em.getTransaction().commit();
        }
    }
}
