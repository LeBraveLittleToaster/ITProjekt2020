package datatypes.nettypes;

import datatypes.dbtypes.Patient;
import datatypes.dbtypes.User;

public class SimpleUserResponse extends  AbstractResponse {

  final User user;
  final Patient patient;
  final String token;

  public SimpleUserResponse(boolean isSuccess, User user, Patient patient, String token) {
    super(isSuccess);
    this.user = user;
    this.patient = patient;
    this.token = token;
  }

  public SimpleUserResponse(boolean isSuccess) {
    super(isSuccess);
    this.user = null;
    this.patient = null;
    this.token = null;
  }
}
