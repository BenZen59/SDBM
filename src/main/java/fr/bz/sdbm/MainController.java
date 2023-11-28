package fr.bz.sdbm;

import fr.bz.sdbm.dao.DAOFactory;
import fr.bz.sdbm.metier.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import org.controlsfx.control.SearchableComboBox;

import java.util.List;

public class MainController {
    @FXML
    private SearchableComboBox<Couleur> couleurSearch;
    @FXML
    private SearchableComboBox<TypeBiere> typeSearch;
    @FXML
    private SearchableComboBox<Fabriquant> fabriquantSearch;
    @FXML
    private SearchableComboBox<Marque> marqueSearch;
    @FXML
    private SearchableComboBox<Continent> continentSearch;
    @FXML
    private SearchableComboBox<Pays> paysSearch;
    @FXML
    private ComboBox<Integer> volumeSearch;
    @FXML
    private TableView<Article> articleTableView;
    @FXML
    private TableColumn<Article, Integer> idTableColumn;
    @FXML
    private TableColumn<Article, String> nomTableColumn;
    @FXML
    private TableColumn<Article, Integer> volumeTableColumn;
    @FXML
    private TableColumn<Article, Float> titrageTableColumn;

    public void initialize() {
        List<Couleur> allColors = DAOFactory.getCouleurDAO().getAll();
        List<TypeBiere> allTypes = DAOFactory.getTypeDAO().getAll();
        List<Fabriquant> allFabricants = DAOFactory.getFabricantDAO().getAll();
        List<Marque> allMarques = DAOFactory.getMarqueDAO().getAll();
        List<Continent> allContinents = DAOFactory.getContinentDAO().getAll();
        List<Pays> allPays = DAOFactory.getPaysDAO().getAll();
        List<Integer> allVolumes = DAOFactory.getArticleDAO().getVolume();
        List<Article> allArticles = DAOFactory.getArticleDAO().getTableView();
        ObservableList<Couleur> observableColors = FXCollections.observableArrayList(allColors);
        ObservableList<TypeBiere> observableTypes = FXCollections.observableArrayList(allTypes);
        ObservableList<Fabriquant> observableFabriquants = FXCollections.observableArrayList(allFabricants);
        ObservableList<Marque> observableMarques = FXCollections.observableArrayList(allMarques);
        ObservableList<Continent> observableContinents = FXCollections.observableArrayList(allContinents);
        ObservableList<Pays> observablePays = FXCollections.observableArrayList(allPays);
        ObservableList<Integer> observableVolume = FXCollections.observableArrayList(allVolumes);
        ObservableList<Article> observableArticle = FXCollections.observableArrayList(allArticles);
        couleurSearch.setItems(observableColors);
        couleurSearch.setPromptText("Couleur");
        // Définissez un StringConverter pour afficher seulement le nom de la couleur
        couleurSearch.setConverter(new StringConverter<Couleur>() {
            @Override
            public String toString(Couleur couleur) {
                return (couleur != null) ? couleur.getNomCouleur() : "";
            }

            @Override
            public Couleur fromString(String string) {
                // Vous pouvez implémenter cette méthode si nécessaire, mais généralement,
                // elle n'est pas utilisée pour une SearchableComboBox.
                return null;
            }
        });
        typeSearch.setItems(observableTypes);
        typeSearch.setPromptText("Type");
        // Définissez un StringConverter pour afficher seulement le nom de la couleur
        typeSearch.setConverter(new StringConverter<TypeBiere>() {
            @Override
            public String toString(TypeBiere typeBiere) {
                return (typeBiere != null) ? typeBiere.getNomType() : "";
            }

            @Override
            public TypeBiere fromString(String string) {
                // Vous pouvez implémenter cette méthode si nécessaire, mais généralement,
                // elle n'est pas utilisée pour une SearchableComboBox.
                return null;
            }
        });
        fabriquantSearch.setItems(observableFabriquants);
        fabriquantSearch.setPromptText("Fabriquant");
        // Définissez un StringConverter pour afficher seulement le nom de la couleur
        fabriquantSearch.setConverter(new StringConverter<Fabriquant>() {
            @Override
            public String toString(Fabriquant fabriquant) {
                return (fabriquant != null) ? fabriquant.getNomFabricant() : "";
            }

            @Override
            public Fabriquant fromString(String string) {
                // Vous pouvez implémenter cette méthode si nécessaire, mais généralement,
                // elle n'est pas utilisée pour une SearchableComboBox.
                return null;
            }
        });
        marqueSearch.setItems(observableMarques);
        marqueSearch.setPromptText("Marque");
        // Définissez un StringConverter pour afficher seulement le nom de la couleur
        marqueSearch.setConverter(new StringConverter<Marque>() {
            @Override
            public String toString(Marque marque) {
                return (marque != null) ? marque.getNomMarque() : "";
            }

            @Override
            public Marque fromString(String string) {
                // Vous pouvez implémenter cette méthode si nécessaire, mais généralement,
                // elle n'est pas utilisée pour une SearchableComboBox.
                return null;
            }
        });
        continentSearch.setItems(observableContinents);
        continentSearch.setPromptText("Continent");
        // Définissez un StringConverter pour afficher seulement le nom de la couleur
        continentSearch.setConverter(new StringConverter<Continent>() {
            @Override
            public String toString(Continent continent) {
                return (continent != null) ? continent.getNomContinent() : "";
            }

            @Override
            public Continent fromString(String string) {
                // Vous pouvez implémenter cette méthode si nécessaire, mais généralement,
                // elle n'est pas utilisée pour une SearchableComboBox.
                return null;
            }
        });
        paysSearch.setItems(observablePays);
        paysSearch.setPromptText("Pays");
        // Définissez un StringConverter pour afficher seulement le nom de la couleur
        paysSearch.setConverter(new StringConverter<Pays>() {
            @Override
            public String toString(Pays pays) {
                return (pays != null) ? pays.getNomPays() : "";
            }

            @Override
            public Pays fromString(String string) {
                // Vous pouvez implémenter cette méthode si nécessaire, mais généralement,
                // elle n'est pas utilisée pour une SearchableComboBox.
                return null;
            }
        });
        volumeSearch.setItems(observableVolume);
        volumeSearch.setPromptText("Volume");
        // Définissez un StringConverter pour afficher seulement le nom de la couleur
        volumeSearch.setConverter(new StringConverter<Integer>() {
            @Override
            public String toString(Integer integer) {
                return (integer != null) ? integer.toString() : "";
            }

            @Override
            public Integer fromString(String s) {
                return null;
            }
        });
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nomTableColumn.setCellValueFactory(new PropertyValueFactory<>("Nom Article"));
        volumeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Volume"));
       titrageTableColumn.setCellValueFactory(new PropertyValueFactory<>("Titrage"));
    }
}


