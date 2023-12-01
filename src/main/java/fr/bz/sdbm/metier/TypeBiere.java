package fr.bz.sdbm.metier;

import lombok.*;

@Getter
@Setter

public class TypeBiere {
    private int id;
    private String nomType;

    public TypeBiere() {

    }
    public TypeBiere(int id, String nomType) {
        this.id = id;
        this.nomType = nomType;
    }
    @Override
    public String toString() {
        return nomType;
    }

}
