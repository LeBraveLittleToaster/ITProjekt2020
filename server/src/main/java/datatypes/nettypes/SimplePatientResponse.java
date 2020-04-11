package datatypes.nettypes;

import datatypes.dbtypes.Patient;

public class SimplePatientResponse extends  AbstractResponse {

  final Patient data;

  public SimplePatientResponse(boolean isSuccess, Patient data) {
    super(isSuccess);
    this.data = data;
  }
}
