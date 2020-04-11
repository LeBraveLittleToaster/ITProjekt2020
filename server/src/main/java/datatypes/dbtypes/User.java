package datatypes.dbtypes;

public class User {
  private int id;
  private String userID;
  /**
   * IOS 8601
   */
  private String crDate;
  private int roleID;
  private String loginname;
  private String pwhash;


  public User(int id, String userID, String crDate, int roleID, String loginname, String pwhash) {
    this.id = id;
    this.userID = userID;
    this.crDate = crDate;
    this.roleID = roleID;
    this.loginname = loginname;
    this.pwhash = pwhash;
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

  public String getCrDate() {
    return crDate;
  }

  public void setCrDate(String crDate) {
    this.crDate = crDate;
  }

  public String getLoginname() {
    return loginname;
  }

  public void setLoginname(String loginname) {
    this.loginname = loginname;
  }

  public String getPwhash() {
    return pwhash;
  }

  public void setPwhash(String pwhash) {
    this.pwhash = pwhash;
  }

  public int getRoleID() {
    return roleID;
  }

  public void setRoleID(int roleID) {
    this.roleID = roleID;
  }
}
