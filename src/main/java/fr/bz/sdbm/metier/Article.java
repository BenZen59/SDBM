package fr.bz.sdbm.metier;

import lombok.*;

@Getter
@Setter
@ToString
public class Article {
    private int id;
    private String nomArticle;
    private float prixAchat;
    private int volume;
    private float titrage;
    private Marque marque;
    private Couleur couleur;
    private TypeBiere typeBiere;
    private int stock;

    public Article() {
        marque = new Marque();
        couleur = new Couleur();
        typeBiere = new TypeBiere();
    }

    public Article(int id, String nomArticle, float prixAchat, int volume, float titrage, Marque marque, int stock) {
        this.id = id;
        this.nomArticle = nomArticle;
        this.prixAchat = prixAchat;
        this.volume = volume;
        this.titrage = titrage;
        this.marque = marque;
        this.stock = stock;
    }

    public Article(int id, String nomArticle, float prixAchat, int volume, float titrage, Marque marque, Couleur couleur, TypeBiere typeBiere, int stock) {
        this.id = id;
        this.nomArticle = nomArticle;
        this.prixAchat = prixAchat;
        this.volume = volume;
        this.titrage = titrage;
        this.marque = marque;
        this.couleur = couleur;
        this.typeBiere = typeBiere;
        this.stock = stock;
    }

    public Article(int id, String nomArticle, int volume, float titrage) {
        this.id = id;
        this.nomArticle = nomArticle;
        this.volume = volume;
        this.titrage = titrage;
    }
}
