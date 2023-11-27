package fr.bz.sdbm;

import fr.bz.sdbm.dao.CouleurDAO;
import fr.bz.sdbm.dao.DAOFactory;
import fr.bz.sdbm.metier.Couleur;
import fr.bz.sdbm.metier.Fabriquant;
import fr.bz.sdbm.metier.TypeBiere;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
public void initialize(){
        List<Couleur> allColors = DAOFactory.getCouleurDAO().getAll();
        List<TypeBiere> allTypes = DAOFactory.getTypeDAO().getAll();
        List<Fabriquant> allFabricants = DAOFactory.getFabricantDAO().getAll();
        ObservableList<Couleur> observableColors = FXCollections.observableArrayList(allColors);
        ObservableList<TypeBiere> observableTypes = FXCollections.observableArrayList(allTypes);
        ObservableList<Fabriquant> observableFabriquants = FXCollections.observableArrayList(allFabricants);
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
    }
}


