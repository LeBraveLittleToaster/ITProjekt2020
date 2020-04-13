import datatypes.dbtypes.Patient;
import datatypes.dbtypes.Projekt;
import datatypes.dbtypes.ProjektData;
import datatypes.dbtypes.User;
import db.MySQLConnection;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class SetupDB {

  private static MySQLConnection _dbcon;
  private static String userID  = UUID.randomUUID().toString();
  private static String[] projektID = new String[5];

  @BeforeClass
  public static void before(){
    _dbcon = new MySQLConnection("jdbc:mysql://localhost:3306/patients", "root", "root");
    try {
      _dbcon.connect();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    for(int i = 0; i < projektID.length;i++){
      projektID[i] = UUID.randomUUID().toString();
    }
  }

  @Test
  public void testCreateTables() throws SQLException {
     _dbcon.getConn().createStatement().execute(TestQueries.DROP_Users_TABLE_STATEMENT);
    _dbcon.getConn().createStatement().execute(TestQueries.DROP_PATIENTS_TABLE_STATEMENT);
    _dbcon.getConn().createStatement().execute(TestQueries.DROP_PROJEKTS_TABLE_STATEMENT);
    _dbcon.getConn().createStatement().execute(TestQueries.DROP_PROJEKTDATA_TABLE_STATEMENT);
    _dbcon.getConn().createStatement().execute(TestQueries.CREATE_USERS_TABLE_STATEMENT);
    _dbcon.getConn().createStatement().execute(TestQueries.CREATE_PATIENTS_TABLE_STATEMENT);
    _dbcon.getConn().createStatement().execute(TestQueries.CREATE_PROJETCS_TABLE_STATEMENT);
    _dbcon.getConn().createStatement().execute(TestQueries.CREATE_PROJEKTDATA_TABLE_STATEMENT);
  }

  @Test
  public void testInsertAndReadUserData() throws InterruptedException {
    System.out.println("USERID:" + userID);
    Thread.sleep(2000);
    User user = new User(userID, DateTime.now().toString(), User.ROLE_ID_PATIENT, "root", "root");
    _dbcon.insertUser(user);
    Thread.sleep(2000);
    Patient patient = new Patient("Nachname", "Vorname", "EineStraße", "12345", "SomePostcode", "EineStadt");
    _dbcon.insertPatientData(userID, patient);
    assertEquals(userID, _dbcon.getPatientByUserID(userID).getUserID());
  }

  @Test
  public void testInsertProjekt(){
    Random rand = new Random();
    for(int i = 0; i < projektID.length; i++){
      Projekt projekt = new Projekt(projektID[i], "Projektname" + i, DateTime.now().toString());
      _dbcon.insertProject(projektID[i], userID, projekt);
      for(int j = 0; j < 10; j++){
        _dbcon.insertProjectData(projektID[i], new ProjektData(
            getRandomFloat(rand),
            getRandomFloat(rand),
            getRandomFloat(rand),
            getRandomFloat(rand),
            getRandomFloat(rand),
            "Ein Kommentar [" + i + ":" +  j + "]",
            DateTime.now().toString()
        ));
      }
    }
  }

  @AfterClass
  public static void after() throws SQLException {
      _dbcon.close();
  }

  public float getRandomFloat(Random random){
    return random.nextFloat();
  }
}

