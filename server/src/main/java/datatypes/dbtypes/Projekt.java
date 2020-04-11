package datatypes.dbtypes;

public class Projekt {
  private int id;
  private String userID;
  private String projektID;
  private String projektname;
  /**
   * ISO 8601
   */
  private String crDate;

  public Projekt(int id, String userID, String projektID, String projektname, String crDate) {
    this.id = id;
    this.userID = userID;
    this.projektID = projektID;
    this.projektname = projektname;
    this.crDate = crDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public String getProjektID() {
    return projektID;
  }

  public void setProjektID(String projektID) {
    this.projektID = projektID;
  }

  public String getProjektName() {
    return projektname;
  }

  public void setProjektName(String projektName) {
    this.projektname = projektName;
  }

  public String getCrDate() {
    return crDate;
  }

  public void setCrDate(String crDate) {
    this.crDate = crDate;
  }
}
