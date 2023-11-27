package fr.bz.sdbm.dao;

public class DAOFactory {
    public static CouleurDAO getCouleurDAO() {
        return new CouleurDAO();
    }

    public static TypeDAO getTypeDAO() {
        return new TypeDAO();
    }
    public static  FabricantDAO getFabricantDAO(){
        return new FabricantDAO();
    }
}