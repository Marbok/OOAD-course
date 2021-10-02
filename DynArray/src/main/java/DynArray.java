public class DynArray<T> {

  public static final int MIN_SIZE = 16; // минимальный размер

  private static final int RAISE_COEFF = 2; // коэф. на сколько увеличивать массив
  private static final double VACUUM_COEFF = 1.5; // коэф. уменьшения массива
  private static final double FILLED_COEFF = 0.5; // коэф. заполнения, при котором уменьшаем массив

  private Object[] array; // структура для хранения данных
  private int capacity; // текущая емкость структуры
  private int count; // количество элементов в структуре

  /**
   *  Постусловие: инициализирует массив с минимальным размером
   */
  public DynArray() {
    this(MIN_SIZE);
  }

  /**
   * Постусловие: инициализирует массив с передаваемым размером или минимальным размером, если передаваемый меньше
   */
  public DynArray(int capacity) {
    count = 0;
    this.capacity = capacity;
    makeArray(capacity);
  }

  private void makeArray(int new_capacity) {
    if (capacity == MIN_SIZE && new_capacity < MIN_SIZE) {
      return;
    }

    if (new_capacity < MIN_SIZE) {
      new_capacity = MIN_SIZE;
    }

    Object[] new_array = new Object[new_capacity];
    for (int i = 0; i < count; i++) {
      new_array[i] = array[i];
    }
    array = new_array;
    capacity = new_capacity;
  }

  // запросы

  /**
   * Предусловие: индекс >= 0, но < size()
   */
  public T get(int index) {
    if (index < 0 || index >= count) {
      throw new IndexOutOfBoundsException(
        "Index = " + index + " out of range: 0 from " + count
      );
    }
    return (T) array[index];
  }

  public int size() {
    return count;
  }

  // команды

  /**
   * Постусловие: элемент добавлен в конец, если емкость увеличивается, если необходимо
   */
  public void append(T itm) {
    if (count == capacity) {
      makeArray(count * 2);
    }
    array[count] = itm;
    count++;
  }

  /**
   * Постусловие: элемент добавлен в передаваемую позицию, хвост сдвигается вправо, емкость увеличивается, если необходимо
   */
  public void insert(T itm, int index) {
    if (index < 0 || index > count) {
      throw new IndexOutOfBoundsException(
        "Index = " + index + " out of range: 0 from " + count
      );
    }

    if (count == index) {
      append(itm);
      return;
    }

    if (count == capacity) {
      makeArray(capacity * RAISE_COEFF);
    }

    for (int i = count - 1; i >= index; i--) {
      array[i + 1] = array[i];
    }

    array[index] = itm;
    count++;
  }

  /**
   * Постусловие: удалет элемент из передаваемой позиции, емкость уменьшается, если необходимо
   */
  public void remove(int index) {
    if (index < 0 || index >= count) {
      throw new IndexOutOfBoundsException(
        "Index = " + index + " out of range: 0 from " + count
      );
    }

    for (int i = index; i < count - 1; i++) {
      array[i] = array[i + 1];
    }
    count--;

    if (isVacuum()) {
      makeArray((int) (capacity / VACUUM_COEFF));
    }
  }

  /**
   * Постусловие: заменяет элемент на передаваемой позиции
   */
  public void replace(T itm, int index) {
    if (index < 0 || index >= count) {
      throw new IndexOutOfBoundsException(
        "Index = " + index + " out of range: 0 from " + count
      );
    }
    array[index] = itm;
  }

  private boolean isVacuum() {
    return (double) count / capacity < FILLED_COEFF;
  }
}
