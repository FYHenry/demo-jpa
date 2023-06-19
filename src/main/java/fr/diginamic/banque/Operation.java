package fr.diginamic.banque;

import java.time.LocalDate;
/** Opération */
public abstract class Operation {
    /** Identifiant */
    private int id;
    /** Date */
    private LocalDate date;
    /** Montant */
    private double montant;
    /** Motif */
    private String motif;
    /** Construction d’opération. */
    public Operation() {}

    /** Construction d’opération par les paramètres.
     *
     * @param date Date
     * @param montant Montant
     * @param motif Motif
     */
    public Operation(LocalDate date, double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }
}
