package datatypes.nettypes;

import org.joda.time.DateTime;

public abstract class AbstractResponse {
  final boolean isSuccess;
  final String sendDate;

  public AbstractResponse(boolean isSuccess) {
    this.isSuccess = isSuccess;
    this.sendDate = DateTime.now().toString();
  }


}
