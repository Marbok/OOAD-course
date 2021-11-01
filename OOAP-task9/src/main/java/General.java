public class General extends Object {

  public void copy(General other) {

  }

  public void deepCopy(General other) {

  }

  public boolean equals(General other) {
      return equals(other);
  }

  public boolean deepEquals(General other) {
      return equals(other);
  }

  public General clone(General other) {
        return new General();
  }

  public String serialize() {
      return toString();
  }

  public void deserialize(String str) {}

  public void print() {
    System.out.println(toString());
  }

  public boolean isType(Class<?> clazz) {
      return clazz.isInstance(this);
  }

  public Class<?> getClazz() {
      return this.getClass();
  }
}
