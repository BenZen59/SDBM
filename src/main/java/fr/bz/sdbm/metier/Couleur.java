package fr.bz.sdbm.metier;

import lombok.*;
@Getter
@Setter
@ToString
public class Couleur {
    private int id;
    private String nomCouleur;
    public Couleur(int id, String nomCouleur){
        this.id = id;
        this.nomCouleur = nomCouleur;
    }
}
