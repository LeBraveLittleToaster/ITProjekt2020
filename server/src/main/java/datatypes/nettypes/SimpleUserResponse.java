package datatypes.nettypes;

import datatypes.dbtypes.Patient;
import datatypes.dbtypes.User;

public class SimpleUserResponse extends  AbstractResponse {

  final User user;
  final Patient data;
  final String token;

  public SimpleUserResponse(boolean isSuccess, User user, Patient data, String token) {
    super(isSuccess);
    this.user = user;
    this.data = data;
    this.token = token;
  }

  public SimpleUserResponse(boolean isSuccess) {
    super(isSuccess);
    this.user = null;
    this.data = null;
    this.token = null;
  }
}
