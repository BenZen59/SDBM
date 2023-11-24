package fr.bz.sdbm.dao;

import java.sql.Connection;
public class DAOFactory {
  public static CouleurDAO getCouleurDAO(){
      return new CouleurDAO();
  }
}
