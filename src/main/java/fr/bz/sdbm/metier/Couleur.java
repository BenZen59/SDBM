package fr.bz.sdbm.metier;

import lombok.*;
@Getter
@Setter
public class Couleur {
    private int id;
    private String nomCouleur;

    public Couleur() {

    }
    public Couleur(int id, String nomCouleur){
        this.id = id;
        this.nomCouleur = nomCouleur;
    }
    @Override
    public String toString() {
        return nomCouleur;
    }

}
