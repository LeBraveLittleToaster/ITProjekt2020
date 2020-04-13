package datatypes.nettypes;

import datatypes.dbtypes.ProjektData;

import java.util.List;

public class SimpleProjektDataResponse extends AbstractResponse{

  public final List<ProjektData> projektData;

  public SimpleProjektDataResponse(boolean isSuccess, List<ProjektData> projektData) {
    super(isSuccess);
    this.projektData = projektData;
  }

  public SimpleProjektDataResponse(boolean isSuccess) {
    super(isSuccess);
    this.projektData = null;
  }
}
