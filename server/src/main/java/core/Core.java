package core;

import datatypes.dbtypes.Patient;
import db.MySQLConnection;

public class Core {
  private final MySQLConnection _dbcon;

  public Core(MySQLConnection dbcon) {
    this._dbcon = dbcon;
  }

}
