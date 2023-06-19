package fr.diginamic.banque;

import java.time.LocalDate;
/** Virement */
public class Virement extends Operation{
    /** Bénéficiaire */
    private String beneficiaire;
    /** Construction d’un virement. */
    public Virement() {
        super();
    }
    /** Construction d’un virement par ses paamètres.
     *
     * @param date Date
     * @param montant Montant
     * @param motif Motif
     * @param beneficiaire Bénéficiaire
     */
    public Virement(LocalDate date, double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }
}
