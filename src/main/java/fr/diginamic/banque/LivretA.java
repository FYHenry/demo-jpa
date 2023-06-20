package fr.diginamic.banque;

import jakarta.persistence.*;

/** Livret A */
@Entity
@Table(name = "Livret_a")
@DiscriminatorValue("Livret A")
public class LivretA extends Compte {
    /** Taux */
    @Column(name = "taux")
    private double taux;
    /** Construction du Livret A. */
    public LivretA() {
        super();
        this.taux = 0;
    }

    /** Construction du livret A par ses paramètres.
     *
     * @param numero Numéro
     * @param solde Solde
     * @param taux Taux
     */
    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }
}
