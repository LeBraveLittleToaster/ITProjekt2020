import core.Core;
import db.MySQLConnection;
import network.Networker;
import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.UUID;

public class Main {

  private Networker _networker;
  private MySQLConnection _dbcon;
  private Core _core;

  public Main() {
  }

  public void start() throws SQLException, ClassNotFoundException {
    _dbcon = new MySQLConnection("jdbc:mysql://localhost:3306/patients", "root", "root");
    _dbcon.connect();
    this._core = new Core(this._dbcon);
    _networker = new Networker(this._core);
    _networker.createAndStartServer();

  }

  public static void main(String[] args) {
    Main main = new Main();
    try {
      main.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String line;
      while((line = reader.readLine()) != null){
        switch (line){
          case "exit":
            main.close();
            System.out.println("Shutting down...");
            System.exit(0);
          default:
            System.out.println("Wrong command");
        }
      }
    } catch (SQLException | ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

  private void close() {
    try {
      this._dbcon.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
