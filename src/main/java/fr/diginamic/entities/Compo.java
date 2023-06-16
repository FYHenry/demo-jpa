package fr.diginamic.entities;

import jakarta.persistence.*;

/** Composition */
@Entity
@Table(name = "Compo")
public class Compo {
    /** Identifiant */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /** Livre */
    @ManyToOne
    @JoinColumn(name = "id_liv", nullable=false)
    private Livre livre;
    /** Emprunt */
    @ManyToOne
    @JoinColumn(name = "id_emp", nullable=false)
    private Emprunt emprunt;

    /**
     * Construire la composition.
     */
    public Compo() {
    }

    /**
     * Construire la composition par livre et emprunt.
     * @param livre Livre
     * @param emprunt Emprunt
     */
    public Compo(Livre livre, Emprunt emprunt) {
        this.livre = livre;
        this.emprunt = emprunt;
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
                    "livre":%s,
                    "auteur":%s
                }
                """,
                this.id,
                this.livre,
                this.emprunt);
    }

    public Livre getLivre() {
        return livre;
    }
}
