package core;

import datatypes.Patient;
import db.MySQLConnection;

public class Core {
  private final MySQLConnection _dbcon;

  public Core(MySQLConnection dbcon) {
    this._dbcon = dbcon;
  }

  public Patient handlePatientRequestById(int patientID){
    return this._dbcon.getPatientById(patientID);
  }

  public Patient handleAddPatient(Patient patient) {
    return this._dbcon.addPatient(patient);
  }
}
