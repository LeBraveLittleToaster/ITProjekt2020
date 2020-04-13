package datatypes.nettypes;

import datatypes.dbtypes.Projekt;

import java.util.List;

public class SimpleProjektResponse extends  AbstractResponse{

  public final List<Projekt> projekts;

  public SimpleProjektResponse(boolean isSuccess, List<Projekt> projekts) {
    super(isSuccess);
    this.projekts = projekts;
  }
  public SimpleProjektResponse(boolean isSuccess) {
    super(isSuccess);
    this.projekts = null;
  }
}
