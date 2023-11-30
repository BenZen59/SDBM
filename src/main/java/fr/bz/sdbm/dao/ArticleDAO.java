package fr.bz.sdbm.dao;

import fr.bz.sdbm.metier.*;

import java.sql.*;
import java.util.ArrayList;

import static fr.bz.sdbm.dao.SDBMConnect.connexion;

public class ArticleDAO extends DAO<Article, ArticleSearch, Integer> {
    @Override
    public Article getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Article> getAll() {
        ArrayList<Article> liste = new ArrayList<>();
        try (CallableStatement callableStatement = connexion.prepareCall("{call PS_QBE_Vue_Article(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {
            // Définir les paramètres de la procédure stockée
            callableStatement.setString(1, "");  // @nom
            callableStatement.setInt(2, 0);      // @volume
            callableStatement.setFloat(3, 0.5f); // @titragemin
            callableStatement.setFloat(4, 26f);   // @titragemax
            callableStatement.setInt(5, 0);      // @marque
            callableStatement.setInt(6, 0);      // @fabricant
            callableStatement.setInt(7, 0);      // @pays
            callableStatement.setInt(8, 0);      // @continent
            callableStatement.setInt(9, 0);      // @couleur
            callableStatement.setInt(10, 0);     // @type
            callableStatement.setInt(11, 1);     // @page
            callableStatement.setInt(12, 0);     // @lgpage
            callableStatement.registerOutParameter(13, Types.INTEGER); // @nbligne

            // Exécutez la procédure stockée
            callableStatement.execute();

            // Récupérez le résultat de la procédure stockée
            int nbligne = callableStatement.getInt(13);

            // Vous pouvez utiliser le résultat comme nécessaire
            System.out.println("Nombre de lignes: " + nbligne);
            try (Statement statement = connexion.createStatement()) {
                ResultSet rs = statement.executeQuery("SELECT * FROM VUE_ARTICLES ORDER BY ID_ARTICLE");
                while (rs.next()) {
                    liste.add(new Article(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getFloat(5), new Marque(rs.getInt(6), rs.getString(7)), new Couleur(rs.getInt(8), rs.getString(9)), new TypeBiere(rs.getInt(10), rs.getString(11)), rs.getInt(12)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Article> getTableView() {
        ArrayList<Article> liste = new ArrayList<>();
        try (CallableStatement callableStatement = connexion.prepareCall("{call PS_QBE_Vue_Article(?, ?, ?, ?)}")) {
            // Définir les paramètres de la procédure stockée
            callableStatement.setInt(1, 0);
            callableStatement.setString(2, "");  // @nom
            callableStatement.setInt(3, 0);      // @volume
            callableStatement.setFloat(4, 0.5f); // @titragemin
            // Exécutez la procédure stockée
            callableStatement.execute();


            try (Statement statement = connexion.createStatement()) {
                ResultSet rs = statement.executeQuery("SELECT ID_ARTICLE AS ID, NOM_ARTICLE AS 'Nom Article', VOLUME AS Volume, TITRAGE AS Titrage FROM VUE_ARTICLES ORDER BY ID_ARTICLE");
                while (rs.next()) {
                    liste.add(new Article(rs.getInt("ID"), rs.getString("Nom Article"), rs.getInt("Volume"), rs.getFloat("Titrage")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Article> filterName(String nameInTextField) {
        System.out.println(nameInTextField);
        ArrayList<Article> liste = new ArrayList<>();
        try (CallableStatement callableStatement = connexion.prepareCall("{call PS_QBE_Vue_Article(?, ?, ?, ?)}")) {
            // Définir les paramètres de la procédure stockée
            callableStatement.setInt(1, 0);
            callableStatement.setString(2, "");  // @nom
            callableStatement.setInt(3, 0);      // @volume
            callableStatement.setFloat(4, 0.5f); // @titragemin
            // Exécutez la procédure stockée
            callableStatement.execute();

            String sqlRequest = "SELECT ID_ARTICLE AS ID, NOM_ARTICLE AS 'Nom Article', VOLUME AS Volume, TITRAGE AS Titrage FROM VUE_ARTICLES WHERE NOM_ARTICLE LIKE ?";
            try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest)) {
                preparedStatement.setString(1, "%" + nameInTextField + "%");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    liste.add(new Article(rs.getInt("ID"), rs.getString("Nom Article"), rs.getInt("Volume"), rs.getFloat("Titrage")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Integer> getVolume() {
        ArrayList<Integer> liste = new ArrayList<>();
        String sqlRequest = "SELECT DISTINCT VOLUME FROM ARTICLE";

        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                liste.add(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }


    @Override
    public ArrayList<Article> getLike(ArticleSearch object) {
        return null;
    }

    @Override
    public boolean insert(Article object) {
        return false;
    }

    @Override
    public boolean update(Article object) {
        return false;
    }

    @Override
    public boolean delete(Article object) {
        return false;
    }
}
