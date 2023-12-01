package fr.bz.sdbm.metier;

import lombok.*;

@Getter
@Setter
public class Pays {
    private int id;
    private String nomPays;
    private Continent continent;

    public Pays() {

    }

    public Pays(int id, String nomPays) {
        this.id = id;
        this.nomPays = nomPays;
        this.continent = new Continent();
    }

    public Pays(int id, String nomPays, Continent continent) {
        this.id = id;
        this.nomPays = nomPays;
        this.continent = continent;
    }
    @Override
    public String toString() {
        return nomPays;
    }
}