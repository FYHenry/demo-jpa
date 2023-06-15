package fr.diginamic.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private int id;
    @Column(name = "titre")
    private String titre;
    @Column(name = "auteur", length = 50)
    private String auteur;
    public Livre(){}
    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }
    @Override
    public String toString() {
        return String.format("""
                {
                    "id":%d,
                    "titre":"%s",
                    "auteur":"%s"
                }
                """,
                this.id,
                this.titre,
                this.auteur);
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
}
