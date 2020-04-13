package db;

import datatypes.dbtypes.Patient;
import datatypes.dbtypes.Projekt;
import datatypes.dbtypes.ProjektData;
import datatypes.dbtypes.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbStatements {

  public static PreparedStatement createInsertPatientStatement(Connection con, Patient patient) throws SQLException {
    final String INSERT_PATIENT_STATEMENT =
        "INSERT INTO Patients (userID, lastname, firstname, street, plz, postcode, cityname)" +
            "VALUES (?,?,?,?,?,?,?)";
    PreparedStatement statement = con.prepareStatement(INSERT_PATIENT_STATEMENT);
    statement.setString(1, patient.getUserID());
    statement.setString(2, patient.getLastname());
    statement.setString(3, patient.getFirstname());
    statement.setString(4, patient.getStreet());
    statement.setString(5, patient.getPlz());
    statement.setString(6, patient.getPostcode());
    statement.setString(7, patient.getCityname());
    return statement;
  }

  public static PreparedStatement createInsertUserStatement(Connection con, User user) throws SQLException {
    final String INSERT_USER_STATEMENT =
        "INSERT INTO Users (userID, crDate, roleID, loginname, pwhash)" +
            "VALUES (?,?,?,?,?)";
    PreparedStatement statement = con.prepareStatement(INSERT_USER_STATEMENT);
    statement.setString(1, user.getUserID());
    statement.setString(2, user.getCrDate());
    statement.setInt(3, user.getRoleID());
    statement.setString(4, user.getLoginname());
    statement.setString(5, user.getPwhash());
    return statement;
  }

  public static PreparedStatement createInsertProjektStatement(Connection con, Projekt projekt) throws SQLException {
    final String INSERT_Projekt_STATEMENT =
        "INSERT INTO Projekts (userID, projektID, projektname, crDate)" +
            "VALUES (?,?,?,?)";
    PreparedStatement statement = con.prepareStatement(INSERT_Projekt_STATEMENT);
    statement.setString(1, projekt.getUserID());
    statement.setString(2, projekt.getProjektID());
    statement.setString(3, projekt.getProjektName());
    statement.setString(4, projekt.getCrDate());
    return statement;
  }

  public static PreparedStatement createInsertProjektDataStatement(Connection con, ProjektData projektData) throws SQLException {
    final String INSERT_USER_STATEMENT =
        "INSERT INTO ProjektData (projektID, sysrr, sysdia, pulse, weightkg, bmi, commentar, crDate)" +
            "VALUES (?,?,?,?,?,?,?,?)";
    PreparedStatement statement = con.prepareStatement(INSERT_USER_STATEMENT);
    statement.setString(1, projektData.getProjekteID());
    statement.setDouble(2, projektData.getSysrr());
    statement.setDouble(3, projektData.getSysdia());
    statement.setDouble(4, projektData.getPulse());
    statement.setDouble(5, projektData.getWeightkg());
    statement.setDouble(6, projektData.getBmi());
    statement.setString(7, projektData.getCommentar());
    statement.setString(8, projektData.getCrDate());
    return statement;
  }

  public static PreparedStatement createGetUserByCredentialsStatement(Connection con, String username, String pwhash) throws SQLException {
    final String SELECT_USER_STATEMENT = "SELECT * FROM Users WHERE loginname=? AND pwhash=?";
    PreparedStatement statement = con.prepareStatement(SELECT_USER_STATEMENT);
    statement.setString(1, username);
    statement.setString(2, pwhash);
    return statement;
  }

  public static PreparedStatement createGetPatientByUserIDStatement(Connection con, String userID) throws SQLException {
    final String SELECT_PATIENT_STATEMENT = "SELECT p.id, p.userID, p.lastname, p.firstname, p.street, p.plz, p.postcode, p.cityname FROM Users AS u JOIN Patients AS p ON u.userID=p.userID WHERE u.userID=?";
    PreparedStatement statement = con.prepareStatement(SELECT_PATIENT_STATEMENT);
    statement.setString(1, userID);
    return statement;
  }

  public static PreparedStatement createGetProjektsByUserID(Connection con, String userID) throws SQLException {
    final String SELECT_PATIENT_STATEMENT = "SELECT id, userID, projektID, projektname, crDate FROM Projekts WHERE userID=?";
    PreparedStatement statement = con.prepareStatement(SELECT_PATIENT_STATEMENT);
    statement.setString(1, userID);
    return statement;
  }

  public static PreparedStatement createGetProjektDataByProjektID(Connection con, String projektID, String userID) throws SQLException {
    final String SELECT_STATEMENT = "SELECT pd.id, pd.projektID, pd.sysrr, pd.sysdia, pd.pulse, pd.weightkg, pd.bmi, pd.commentar\n" +
        "FROM ProjektData AS pd JOIN Projekts AS p ON pd.projektID=p.projektID WHERE p.userID=? AND p.projektID=?";
    PreparedStatement statement = con.prepareStatement(SELECT_STATEMENT);
    statement.setString(1, userID);
    statement.setString(2, projektID);
    return statement;
  }
}
