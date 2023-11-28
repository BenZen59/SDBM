package fr.bz.sdbm.dao;

import fr.bz.sdbm.metier.*;

import java.sql.ResultSet;
import java.sql.Statement;
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
        String sqlRequest = "select A.ID_ARTICLE, A.NOM_ARTICLE, A.PRIX_ACHAT, A.VOLUME, A.TITRAGE, A.STOCK\n" +
                "       M.ID_MARQUE, M.NOM_MARQUE,\n" +
                "       C.ID_COULEUR, C.NOM_COULEUR,\n" +
                "       T.ID_TYPE, T.NOM_TYPE\n, " +
                "from ARTICLE AS A\n" +
                "JOIN MARQUE AS M on A.ID_MARQUE = M.ID_MARQUE\n" +
                "LEFT JOIN COULEUR C on A.ID_COULEUR = C.ID_COULEUR\n" +
                "LEFT JOIN TYPEBIERE T on A.ID_TYPE = T.ID_TYPE\n";

        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                liste.add(new Article(rs.getInt(1), rs.getString(2),
                        rs.getFloat(3), rs.getInt(4), rs.getFloat(5),
                        new Marque(rs.getInt(6), rs.getString(7)),
                        new Couleur(rs.getInt(8), rs.getString(9)),
                        new TypeBiere(rs.getInt(10), rs.getString(11))
                        ,rs.getInt(12)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Article> getTableView() {
        ArrayList<Article> liste = new ArrayList<>();
        String sqlRequest = "SELECT ID_ARTICLE AS ID, NOM_ARTICLE AS 'Nom Article', VOLUME AS Volume, TITRAGE AS Titrage FROM ARTICLE";

        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nomArticle = rs.getString("Nom Article");
                int volume = rs.getInt("Volume");
                float titrage = rs.getFloat("Titrage");
                Article article = new Article(id, nomArticle, volume, titrage);
                liste.add(article);
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
