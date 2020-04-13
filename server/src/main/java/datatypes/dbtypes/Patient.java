package datatypes.dbtypes;

public class Patient {

  private int id;
  private String userID;
  private String lastname;
  private String firstname;
  private String street;
  private String plz;
  private String postcode;
  private String cityname;

  public Patient(int id, String userID, String lastname, String firstname, String street, String plz, String postcode, String cityname) {
    this.id = id;
    this.userID = userID;
    this.lastname = lastname;
    this.firstname = firstname;
    this.street = street;
    this.plz = plz;
    this.postcode = postcode;
    this.cityname = cityname;
  }

  public Patient(String lastname, String firstname, String street, String plz, String postcode, String cityname) {
    this.lastname = lastname;
    this.firstname = firstname;
    this.street = street;
    this.plz = plz;
    this.postcode = postcode;
    this.cityname = cityname;
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

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getPlz() {
    return plz;
  }

  public void setPlz(String plz) {
    this.plz = plz;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public String getCityname() {
    return cityname;
  }

  public void setCityname(String cityname) {
    this.cityname = cityname;
  }
}
