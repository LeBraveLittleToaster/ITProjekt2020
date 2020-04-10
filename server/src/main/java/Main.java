import core.Core;
import db.MySQLConnection;
import network.Networker;

import java.sql.SQLException;

public class Main {

  private Networker _networker;
  private MySQLConnection _dbcon;
  private Core _core;

  public Main() {
  }

  public void start() throws SQLException, ClassNotFoundException {
    _dbcon = new MySQLConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
    _dbcon.connect();
    this._core = new Core(this._dbcon);
    _networker = new Networker(this._core);
    _networker.createAndStartServer();

  }

  public static void main(String[] args) {
    Main main = new Main();
    try {
      main.start();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
