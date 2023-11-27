package fr.bz.sdbm.dao;

import fr.bz.sdbm.metier.TypeBiere;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static fr.bz.sdbm.dao.SDBMConnect.connexion;
public class TypeDAO extends DAO<TypeBiere,TypeBiere, Integer>{
    @Override
    public TypeBiere getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<TypeBiere> getAll() {
        ArrayList<TypeBiere> liste = new ArrayList<>();
        String sqlRequest = "SELECT ID_TYPE,NOM_TYPE from TYPEBIERE";
        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                liste.add(new TypeBiere(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public ArrayList<TypeBiere> getLike(TypeBiere object) {
        return null;
    }

    @Override
    public boolean insert(TypeBiere object) {
        return false;
    }

    @Override
    public boolean update(TypeBiere object) {
        return false;
    }

    @Override
    public boolean delete(TypeBiere object) {
        return false;
    }
}
