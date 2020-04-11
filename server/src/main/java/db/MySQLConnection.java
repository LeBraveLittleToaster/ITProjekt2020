package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

}