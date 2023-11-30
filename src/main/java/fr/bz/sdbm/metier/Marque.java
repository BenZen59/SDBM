package fr.bz.sdbm.metier;

import lombok.*;
@Getter
@Setter
@ToString
public class Marque {
    private int id;
    public String nomMarque;
    private Pays pays;
    private Fabriquant fabriquant;
    public Marque() {

    }

    public Marque(int id, String nomMarque) {
        this.id = id;
        this.nomMarque = nomMarque;
        this.pays = new Pays();
        this.fabriquant = new Fabriquant();
    }

    public Marque(int id, String nomMarque,Pays pays, Fabriquant fabriquant) {
        this.id = id;
        this.nomMarque = nomMarque;
        this.pays = pays;
        this.fabriquant = fabriquant;
    }


}


