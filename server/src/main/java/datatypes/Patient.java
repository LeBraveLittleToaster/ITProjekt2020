package datatypes;

public class Patient {
  private int id;
  private String patientID;
  private String lastName;
  private String firstName;
  private String address;
  private String city;

  public Patient(int id, String patientID, String lastName, String firstName, String address, String city) {
    this.id = id;
    this.patientID = patientID;
    this.lastName = lastName;
    this.firstName = firstName;
    this.address = address;
    this.city = city;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPatientID() {
    return patientID;
  }

  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
