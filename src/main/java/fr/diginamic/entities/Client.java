package fr.diginamic.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/** Client */
@Entity
@Table(name = "Client")
public class Client {
    /** Identifiant */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /** Nom */
    @Column(name = "Nom")
    private String nom;
    /** Prénom */
    @Column(name = "Prenom")
    private String prenom;
    /** Emprunts */
    @OneToMany(mappedBy = "client")
    private final Set<Emprunt> emprunts = new HashSet<>();
    /**
     * Construire le client.
     */
    public Client() {
    }

    /**
     * Construire le client par nom et prénom.
     * @param nom Nom
     * @param prenom Prénom
     */
    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
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
                    "nom":"%s",
                    "prenom":"%s"
                }
                """,
                this.id,
                this.nom,
                this.prenom);
    }
}
