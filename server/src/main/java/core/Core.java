package core;

import datatypes.dbtypes.Patient;
import datatypes.dbtypes.User;
import datatypes.nettypes.SimpleUserResponse;
import db.MySQLConnection;

import java.sql.SQLException;
import java.util.*;

public class Core {

  private static Core instance;
  private Core () {
    _dbcon = new MySQLConnection("jdbc:mysql://localhost:3306/patients", "root", "root");
    try {
      _dbcon.connect();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public static Core getInstance () {
    if (Core.instance == null) {
      Core.instance = new Core ();
    }
    return Core.instance;
  }

  private final MySQLConnection _dbcon;
  private Map<String, String> userIDTokens = new HashMap<>();

  public String createToken(String userID){
    String token = UUID.randomUUID().toString();
    userIDTokens.put(userID, token);
    return token;
  }

  public boolean checkToken(String token){
    return userIDTokens.containsValue(token);
  }

  public SimpleUserResponse handleLogin(String uname, String pwhash) {
    User user = this._dbcon.getUserByCredentials(uname, pwhash);
    Patient patient = null;
    if(user != null && user.getRoleID() == User.ROLE_ID_PATIENT){
      patient = this._dbcon.getPatientByUserID(user.getUserID());
    }
    return user != null ?
        new SimpleUserResponse(true, user, patient, createToken(user.getUserID()))
        : new SimpleUserResponse(false);
  }
}
