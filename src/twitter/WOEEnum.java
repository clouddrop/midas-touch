package twitter;

/**
 * Created by samar.kumar on 27/11/15.
 */
public enum WOEEnum {

  Worldwide(1), Toronto(4118), Bangalore(2295420), India(23424848), Indonesia(23424846), Brazil(23424768), UnitedStates(23424977),
  Germany(23424829), Japan(23424856);
  private int value;

  WOEEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
