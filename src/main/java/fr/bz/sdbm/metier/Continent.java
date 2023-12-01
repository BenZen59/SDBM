package fr.bz.sdbm.metier;

import lombok.*;
@Getter
@Setter

public class Continent {
    private int id;
    public String nomContinent;

    public Continent() {
    }

    public Continent(int id, String nomContinent) {
        this.id = id;
        this.nomContinent = nomContinent;
    }

    @Override
    public String toString() {
        return nomContinent;
    }
}


