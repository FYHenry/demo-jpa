package fr.diginamic.entities;

import jakarta.persistence.*;

/** Article */
@Entity
@Table(name="ARTICLE")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="REF")
    private String ref;
    @Column(name="DESIGNATION")
    private String designation;
    @Column(name="PRIX")
    private double prix;
    @Column(name = "ID_FOU")
    private int idFou;

    public Article(){}

    public Article(String ref, String designation, double prix, int idFou) {
        this.id = 0;
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.idFou = 0;
    }

    @Override
    public String toString() {
        return String.format("""
                {
                    "ID":%d,
                    "REF":"%s",
                    "DESIGNATION":"%s",
                    "PRIX":%.2f
                }
                """,
                this.id,
                this.ref,
                this.designation,
                this.prix);
    }
}
