package db;

import core.Core;
import datatypes.Patient;

import java.sql.*;
import java.util.UUID;

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

  public void getDrugsClaims() throws SQLException {
    String query = "select * from Patients";
    Statement st = this._conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    ResultSetMetaData rsmd = rs.getMetaData();

    int columnsNumber = rsmd.getColumnCount();
    while (rs.next()) {
      //Print one row
      for (int i = 1; i <= columnsNumber; i++) {
        System.out.print(rs.getString(i) + " ");
      }
      System.out.println();
    }
  }

  public void close() throws SQLException {
    if (this._conn != null) {
      this._conn.close();
    }
  }

  public Patient getPatientById(int patientID) {
    try {
      ResultSet set = DbStatements.createPatientByIdStatement(this._conn, patientID).executeQuery();
      if (set.next()) {
        return new Patient(
            set.getInt(1),
            set.getString(2),
            set.getString(3),
            set.getString(4),
            set.getString(5),
            set.getString(5));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public Patient addPatient(Patient patient) {
    patient.setPatientID(UUID.randomUUID().toString());
    try {
      DbStatements.createInsertPatientStatement(this._conn, patient).execute();
      return patient;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }


}