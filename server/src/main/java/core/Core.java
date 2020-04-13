package core;

import datatypes.dbtypes.Patient;
import datatypes.dbtypes.Projekt;
import datatypes.dbtypes.ProjektData;
import datatypes.dbtypes.User;
import datatypes.nettypes.SimpleProjektDataResponse;
import datatypes.nettypes.SimpleProjektResponse;
import datatypes.nettypes.SimpleUserResponse;
import db.MySQLConnection;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

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
  /**
   * userID <-> (access) token
   */
  private BidiMap<String, String> userIDToken = new DualHashBidiMap<>();

  public String createToken(String userID){
    String token = UUID.randomUUID().toString();
    userIDToken.put(userID, token);
    return token;
  }

  public String checkTokenAndGetUserID(String token){
    return userIDToken.getKey(token);
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


  public SimpleProjektResponse handleGetPatientProjekts(String userID) {
    List<Projekt> projekts = _dbcon.getProjektsFromUserID(userID);
    if(projekts != null){
      return new SimpleProjektResponse(true, projekts);
    }else{
      return new SimpleProjektResponse(false);
    }
  }

  public SimpleProjektDataResponse handleGetProjektData(String projektID, String userID) {
    List<ProjektData> data =_dbcon.getProjektDataFromProjektID(projektID, userID);
    if(data != null){
      return new SimpleProjektDataResponse(true, data);
    }
    return new SimpleProjektDataResponse(false);
  }
}
