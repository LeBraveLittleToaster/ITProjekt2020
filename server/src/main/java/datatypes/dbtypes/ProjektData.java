package datatypes.dbtypes;

public class ProjektData {
  private int id;
  private String projekteID;
  private float sysrr;
  private float sysdia;
  private float pulse;
  private float weightkg;
  private float bmi;
  private String commentar;

  public ProjektData(int id, String projekteID, float sysrr, float sysdia, float pulse, float weightkg, float bmi, String commentar) {
    this.id = id;
    this.projekteID = projekteID;
    this.sysrr = sysrr;
    this.sysdia = sysdia;
    this.pulse = pulse;
    this.weightkg = weightkg;
    this.bmi = bmi;
    this.commentar = commentar;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProjekteID() {
    return projekteID;
  }

  public void setProjekteID(String projekteID) {
    this.projekteID = projekteID;
  }

  public float getSysrr() {
    return sysrr;
  }

  public void setSysrr(float sysrr) {
    this.sysrr = sysrr;
  }

  public float getSysdia() {
    return sysdia;
  }

  public void setSysdia(float sysdia) {
    this.sysdia = sysdia;
  }

  public float getPulse() {
    return pulse;
  }

  public void setPulse(float pulse) {
    this.pulse = pulse;
  }

  public float getWeightkg() {
    return weightkg;
  }

  public void setWeightkg(float weightkg) {
    this.weightkg = weightkg;
  }

  public float getBmi() {
    return bmi;
  }

  public void setBmi(float bmi) {
    this.bmi = bmi;
  }

  public String getCommentar() {
    return commentar;
  }

  public void setCommentar(String commentar) {
    this.commentar = commentar;
  }
}
