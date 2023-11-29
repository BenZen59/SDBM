package fr.bz.sdbm;

import fr.bz.sdbm.bean.ArticleSearchBean;
import fr.bz.sdbm.dao.DAOFactory;
import fr.bz.sdbm.metier.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import org.controlsfx.control.SearchableComboBox;

import java.util.List;

public class MainController {
    @FXML
    private TextField filterArticle;
    @FXML
    private ComboBox<Couleur> couleurSearch;
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
        ArticleSearchBean articleSearchBean = new ArticleSearchBean();
        articleSearchBean.init();
        filterArticle = new TextField();
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomTableColumn.setCellValueFactory(new PropertyValueFactory<>("nomArticle"));
        volumeTableColumn.setCellValueFactory(new PropertyValueFactory<>("volume"));
        titrageTableColumn.setCellValueFactory(new PropertyValueFactory<>("titrage"));
        articleTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        // Chargez les données depuis la base de données
        articleTableView.setItems(articleSearchBean.getObservableArticles());
        couleurSearch.setItems(articleSearchBean.getObservableColors());
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
        typeSearch.setItems(articleSearchBean.getObservableTypes());
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
        fabriquantSearch.setItems(articleSearchBean.getObservableFabriquants());
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
        marqueSearch.setItems(articleSearchBean.getObservableMarques());
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
        continentSearch.setItems(articleSearchBean.getObservableContinents());
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
        paysSearch.setItems(articleSearchBean.getObservablePays());
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
        volumeSearch.setItems(articleSearchBean.getObservableVolume());
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

    }

    public void filterController(){
        ArticleSearchBean articleSearchBean = new ArticleSearchBean();
        articleSearchBean.init();
        filterArticle.textProperty().addListener((observable, oldValue, newValue) -> {
            articleSearchBean.filter(newValue);

        });
    }
}


