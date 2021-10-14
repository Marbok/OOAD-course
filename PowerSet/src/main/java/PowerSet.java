public class PowerSet<T> extends HashTable<T> {

  public PowerSet(int capacity) {
    super(capacity);
  }

  /**
   * Постусловие: возвращает пересечение множества с передаваемым
   */
  public PowerSet<T> intersection(PowerSet<T> other) {
    PowerSet<T> result = new PowerSet<T>(size() + other.size());

    for (T value : other.getValues()) {
      if (hasValue(value)) {
        result.put(value);
      }
    }
    return result;
  }

  /**
   * Постусловие: возвращает объединение множеств
   */
  public PowerSet<T> union(PowerSet<T> other) {
    PowerSet<T> result = new PowerSet<T>(size() + other.size());

    for (T value : other.getValues()) {
      result.put(value);
    }

    for (T value : getValues()) {
      result.put(value);
    }

    return result;
  }

  /**
   * Постусловие: возвращает подмножество текущего множества, которое не входет в передаваемое
   */
  public PowerSet<T> difference(PowerSet<T> other) {
    PowerSet<T> result = new PowerSet<T>(size());

    for (T value : getValues()) {
      if (!other.hasValue(value)) {
        result.put(value);
      }
    }
    return result;
  }

  /**
   * Постусловие: является ли множество-параметр подмножеством текущего множества
   */

  public boolean is_subset(PowerSet<T> other) {
    for (T value : other.getValues()) {
      if (!hasValue(value)) {
        return false;
      }
    }
    return true;
  }
}
