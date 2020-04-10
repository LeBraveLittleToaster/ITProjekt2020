package db;

import datatypes.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbStatements {

  public static PreparedStatement createInsertPatientStatement(Connection con, Patient patient) throws SQLException {
    final String INSERT_PATIENT_STATEMENT = "INSERT INTO Patients (PatientID, LastName, FirstName, Address, City)VALUES (?, ?, ? , ? , ?)";
    PreparedStatement statement = con.prepareStatement(INSERT_PATIENT_STATEMENT);
    statement.setString(1, patient.getPatientID());
    statement.setString(2, patient.getLastName());
    statement.setString(3, patient.getFirstName());
    statement.setString(4, patient.getAddress());
    statement.setString(5, patient.getCity());
    return statement;
  }

  public static PreparedStatement createPatientByIdStatement(Connection con, int patientID) throws SQLException {
    final String SELECT_PATIENT_BY_ID = "SELECT * FROM Patients WHERE PatientID=?";
    PreparedStatement statement = con.prepareStatement(SELECT_PATIENT_BY_ID);
    statement.setInt(1, patientID);
    return statement;
  }
}
