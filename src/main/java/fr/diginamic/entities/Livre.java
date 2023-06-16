package fr.diginamic.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/** Livre */
@Entity
@Table(name = "Livre")
public class Livre {
    /** Identifiant */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10)
    private int id;
    /** Titre */
    @Column(name = "titre")
    private String titre;
    /** Auteur */
    @Column(name = "auteur", length = 50)
    private String auteur;
    /** Compositions */
    @OneToMany(mappedBy = "livre")
    private Set<Compo> compos = new HashSet<>();

    /**
     * Constructeur standard.
     */
    public Livre(){}

    /** Construction du livre selon titre et auteur.
     *
     * @param titre Titre
     * @param auteur Auteur
     */
    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    /** Texte d’affichage
     *
     * @return Texte
     */
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

    /**
     * Modifier le titre.
     * @param titre Titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }
}
