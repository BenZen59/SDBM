package fr.bz.sdbm.bean;

import fr.bz.sdbm.dao.DAOFactory;
import fr.bz.sdbm.metier.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ArticleSearchBean {
    private ArrayList<Article> allArticles;
    private ArrayList<Couleur> allColors;
    private ArrayList<TypeBiere> allTypes;
    private ArrayList<Fabriquant> allFabricants;
    private ArrayList<Marque> allMarques;
    private ArrayList<Continent> allContinents;
    private ArrayList<Pays> allPays;
    private ArrayList<Integer> allVolumes;

    public void init() {
        allArticles = DAOFactory.getArticleDAO().getTableView();
        allColors = DAOFactory.getCouleurDAO().getAll();
        allTypes = DAOFactory.getTypeDAO().getAll();
        allFabricants = DAOFactory.getFabricantDAO().getAll();
        allMarques = DAOFactory.getMarqueDAO().getAll();
        allContinents = DAOFactory.getContinentDAO().getAll();
        allPays = DAOFactory.getPaysDAO().getAll();
        allVolumes = DAOFactory.getArticleDAO().getVolume();
    }

    public ObservableList<Article> getObservableArticles() {
        return FXCollections.observableArrayList(allArticles);
    }

    public ObservableList<Couleur> getObservableColors() {
        return FXCollections.observableArrayList(allColors);
    }

    public ObservableList<TypeBiere> getObservableTypes() {
        return FXCollections.observableArrayList(allTypes);
    }

    public ObservableList<Fabriquant> getObservableFabriquants() {
        return FXCollections.observableArrayList(allFabricants);
    }

    public ObservableList<Marque> getObservableMarques() {
        return FXCollections.observableArrayList(allMarques);
    }

    public ObservableList<Continent> getObservableContinents() {
        return FXCollections.observableArrayList(allContinents);
    }

    public ObservableList<Pays> getObservablePays() {
        return FXCollections.observableArrayList(allPays);
    }

    public ObservableList<Integer> getObservableVolume() {
        return FXCollections.observableArrayList(allVolumes);
    }

    public void filter(String newValue) {

        List<Article> filteredArticle = new ArrayList<>();
        for (Article article : allArticles) {
            if (article.getNomArticle().contains(newValue)) {
                filteredArticle.add(article);
            }
        }
        updateList(filteredArticle);
    }

    private void updateList(List<Article> filteredArticle) {
        allArticles.clear();
        allArticles.addAll(filteredArticle);
    }
}