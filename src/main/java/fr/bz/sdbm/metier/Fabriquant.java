package fr.bz.sdbm.metier;

import lombok.*;
@Getter
@Setter
@ToString
public class Fabriquant {
    private int id;
    private String nomFabricant;

    public Fabriquant() {

    }

    public Fabriquant(int id, String nomFabricant) {
        this.id = id;
        this.nomFabricant = nomFabricant;
    }


}
