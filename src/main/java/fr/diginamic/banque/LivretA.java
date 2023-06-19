package fr.diginamic.banque;
/** Livret A */
public class LivretA extends Compte {
    /** Taux */
    private double taux;
    /** Construction du Livret A. */
    public LivretA() {
        super();
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
