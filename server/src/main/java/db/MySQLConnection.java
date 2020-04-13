package db;

import com.mysql.cj.protocol.Resultset;
import datatypes.dbtypes.Patient;
import datatypes.dbtypes.Projekt;
import datatypes.dbtypes.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySQLConnection {

  private String url;
  private String username;
  private String password;
  private Connection _conn;


  public MySQLConnection(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  public void connect() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    this._conn = DriverManager.getConnection(this.url, this.username, this.password);
  }

  public void close() throws SQLException {
    if (this._conn != null) {
      this._conn.close();
    }
  }

  public User getUserByCredentials(String username, String pwhash) {
    try {
      ResultSet set = DbStatements.createGetUserByCredentialsStatement(this._conn, username, pwhash).executeQuery();
      if(set.next()) {
        return new User(
            set.getInt(1),
            set.getString(2),
            set.getString(3),
            set.getInt(4),
            set.getString(5),
            null
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  public Patient getPatientByUserID(String userID) {
    try {
      ResultSet set = DbStatements.createGetPatientByUserIDStatement(this._conn, userID).executeQuery();
      if(set.next()) {
        return new Patient(
            set.getInt(1),
            set.getString(2),
            set.getString(3),
            set.getString(4),
            set.getString(5),
            set.getString(6),
            set.getString(7),
            set.getString(8)
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Projekt> getProjektsFromUserID(String userID) {
    try {
      ResultSet set = DbStatements.createGetProjektsByUserID(this._conn, userID).executeQuery();
      List<Projekt> projektLst = new LinkedList<>();
      if(set.next()) {
        projektLst.add(new Projekt(
            set.getInt(1),
            set.getString(2),
            set.getString(3),
            set.getString(4),
            set.getString(5)
        ));
      }
      return projektLst;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}