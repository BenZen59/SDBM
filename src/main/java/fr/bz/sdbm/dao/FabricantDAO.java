package fr.bz.sdbm.dao;

import fr.bz.sdbm.metier.Fabriquant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static fr.bz.sdbm.dao.SDBMConnect.connexion;
public class FabricantDAO extends DAO<Fabriquant, Fabriquant, Integer>{


    @Override
    public Fabriquant getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Fabriquant> getAll() {
        ArrayList<Fabriquant> liste = new ArrayList<>();
        String sqlRequest = "SELECT ID_FABRIQUANT, NOM_FABRIQUANT from FABRICANT";
        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                liste.add(new Fabriquant(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public ArrayList<Fabriquant> getLike(Fabriquant object) {
        return null;
    }

    @Override
    public boolean insert(Fabriquant object) {
        return false;
    }

    @Override
    public boolean update(Fabriquant object) {
        return false;
    }

    @Override
    public boolean delete(Fabriquant object) {
        return false;
    }
}
