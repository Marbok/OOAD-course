public class HashTable<T> {

  public static final int PUT_NIL = 0; // put() не вызывался
  public static final int PUT_OK = 1; // успешный вызов
  public static final int PUT_ERR = 2; // таблица заполнена

  private Object[] slots;
  private int size;

  private int put_status;

  /**
   * Предусловие: capacity > 0
   * Постусловие: инициализирует таблицу переданного размера
   */
  public HashTable(int capacity) {
    slots = new Object[capacity];
    size = 0;
  }

  // команды

  /**
   * Предусловие: хэштаблица заполнена, переданное значение не null
   * Постусловие: записывает значение в хэштаблицу
   */
  public void put(T value) {
    if (isFull() || value == null) {
      put_status = PUT_ERR;
      return;
    }

    int start = slot(value);
    int curr = start;
    do {
      T el = (T) slots[curr];
      if (el == null) {
        slots[curr] = value;
        break;
      } else if (el.equals(value)) {
        break;
      }
      curr++;
      if (curr == size) {
        curr = 0;
      }
    } while (curr != start);
    size++;
    put_status = PUT_OK;
  }

  /**
   * Постусловие: элемент удален из таблицы
   */
  public void remove(T value) {
    int slot = find(value);
    if (slot != -1) {
      slots[slot] = null;
      size--;
    }
  }

  // запросы

  public boolean hasValue(T value) {
    return find(value) != -1;
  }

  public boolean isFull() {
    return size == slots.length;
  }

  // статусы

  public int get_put_status() {
    return put_status;
  }

  private int find(T value) {
    int slot = slot(value);
    int start = slot;
    do {
      T el = (T) slots[slot];
      if (el != null && el.equals(value)) {
        return slot;
      }
      slot++;
      if (slot == size) {
        slot = 0;
      }
    } while (slot != start);
    return -1;
  }

  private int slot(T value) {
    return value.hashCode() % slots.length;
  }
}
