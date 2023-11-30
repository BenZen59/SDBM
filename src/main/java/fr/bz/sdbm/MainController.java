package fr.bz.sdbm;

import fr.bz.sdbm.bean.ArticleBean;
import fr.bz.sdbm.metier.*;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import org.controlsfx.control.SearchableComboBox;

import static javafx.collections.FXCollections.observableArrayList;

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
    private ComboBox<Continent> continentSearch;
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
    @FXML
    private TextField detailsId;
    @FXML
    private TextField detailsNomArticle;
    @FXML
    private TextField detailsPrixAchat;
    @FXML
    private TextField detailsVolume;
    @FXML
    private TextField detailsTitrage;
    @FXML
    private TextField detailsMarque;
    @FXML
    private TextField detailsFabriquant;
    @FXML
    private TextField detailsCouleur;
    @FXML
    private TextField detailsType;
    @FXML
    private TextField detailsPays;
    @FXML
    private TextField detailsContinent;
    @FXML
    private TextField detailsStock;
    private ArticleBean articleBean = new ArticleBean();

    public void initialize() {
        articleBean.init();
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomTableColumn.setCellValueFactory(new PropertyValueFactory<>("nomArticle"));
        volumeTableColumn.setCellValueFactory(new PropertyValueFactory<>("volume"));
        titrageTableColumn.setCellValueFactory(new PropertyValueFactory<>("titrage"));
        articleTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        // Chargez les données depuis la base de données
        articleTableView.setItems(articleBean.getObservableArticles());
        couleurSearch.setItems(articleBean.getObservableColors());
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
        typeSearch.setItems(articleBean.getObservableTypes());
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
        fabriquantSearch.setItems(articleBean.getObservableFabriquants());
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
        marqueSearch.setItems(articleBean.getObservableMarques());
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
        continentSearch.setItems(articleBean.getObservableContinents());
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
        paysSearch.setItems(articleBean.getObservablePays());
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
        volumeSearch.setItems(articleBean.getObservableVolume());
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

    public void filterController() {
        if (articleBean != null) {
            // Utilisez la même instance de FilteredList pour éviter de créer une nouvelle instance à chaque appel
            FilteredList<Article> filteredData = new FilteredList<>(articleBean.getObservableArticles(), p -> true);

            filterArticle.textProperty().addListener((observable, oldValue, newValue) -> {
                articleBean.getObservableNameFilter();
                filteredData.setPredicate(article -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    return article.getNomArticle().toLowerCase().contains(lowerCaseFilter);
                });
            });

            // Lier la FilteredList à votre TableView
            SortedList<Article> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(articleTableView.comparatorProperty());
            articleTableView.setItems(sortedData);
        }
    }
}


