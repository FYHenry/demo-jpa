package fr.diginamic.banque;
/** Compte */
public abstract class Compte {
    /** Identifiant */
    private int id;
    /** Numéro */
    private String numero;
    /** Solde */
    private double solde;

    protected Compte() {
    }

    protected Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }
}
