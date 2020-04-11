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
        "INSERT INTO ProjektData (projektID, sysrr, sysdia, pulse, weightkg, bmi, commentar)" +
            "VALUES (?,?,?,?,?,?,?)";
    PreparedStatement statement = con.prepareStatement(INSERT_USER_STATEMENT);
    statement.setString(1, projektData.getProjekteID());
    statement.setFloat(2, projektData.getSysrr());
    statement.setFloat(3, projektData.getSysdia());
    statement.setFloat(4, projektData.getPulse());
    statement.setFloat(5, projektData.getWeightkg());
    statement.setFloat(6, projektData.getBmi());
    statement.setString(7, projektData.getCommentar());
    return statement;
  }
}
