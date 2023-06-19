package fr.diginamic.banque;

import java.time.LocalDate;
/** Assurance vie */
public class AssuranceVie extends Compte{
    /** Date de fin */
    private LocalDate dateFin;
    /** Taux */
    private double taux;
    /** Construction de l’assurance vie. */
    public AssuranceVie() {
        super();
    }

    /** Construction de l’assurance vie par ses paramètres.
     *
     * @param numero Numéro
     * @param solde Solde
     * @param dateFin Date de fin
     * @param taux Taux
     */
    public AssuranceVie(String numero,
                        double solde,
                        LocalDate dateFin,
                        double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }
}
