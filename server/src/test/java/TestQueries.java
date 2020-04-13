public class TestQueries {
  public static final String CREATE_USERS_TABLE_STATEMENT = "CREATE TABLE Users ( id int NOT NULL auto_increment,userID varchar(255) NOT NULL, crDate varchar(255) NOT NULL, roleID int NOT NULL, loginname varchar(255) NOT NULL,pwhash varchar(255) NOT NULL, primary key(id) );";
  public static final String CREATE_PATIENTS_TABLE_STATEMENT = "CREATE TABLE Patients ( id int NOT NULL auto_increment, userID varchar(255) NOT NULL, lastname varchar(255) NOT NULL, firstname varchar(255) NOT NULL, street varchar(255), plz varchar(255), postcode varchar(255), cityname varchar(255),primary key(id));";
  public static final String CREATE_PROJETCS_TABLE_STATEMENT = "CREATE TABLE Projekts ( id int NOT NULL auto_increment, userID varchar(255) NOT NULL, projektID varchar(255) NOT NULL, projektname varchar(255) NOT NULL, crDate varchar(255) NOT NULL, primary key(id));";
  public static final String CREATE_PROJEKTDATA_TABLE_STATEMENT = "CREATE TABLE ProjektData (id int NOT NULL auto_increment, projektID varchar(255) NOT NULL, sysrr DOUBLE, sysdia DOUBLE, pulse DOUBLE, weightkg DOUBLE, bmi DOUBLE, commentar varchar(255), crDate varchar(255), primary key(id));";
  public static final String DROP_Users_TABLE_STATEMENT = String.format("DROP TABLE IF EXISTS %s; ", "Users");
  public static final String DROP_PATIENTS_TABLE_STATEMENT = String.format("DROP TABLE IF EXISTS %s; ", "Patients");;
  public static final String DROP_PROJEKTS_TABLE_STATEMENT = String.format("DROP TABLE IF EXISTS %s; ", "Projekts");;
  public static final String DROP_PROJEKTDATA_TABLE_STATEMENT = String.format("DROP TABLE IF EXISTS %s; ", "ProjektData");
}
