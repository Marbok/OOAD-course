public class NativeDictinary<T> {

  public static final int PUT_NIL = 0; // put() не вызывался
  public static final int PUT_OK = 1; // успешный вызов
  public static final int PUT_ERR = 2; // таблица заполнена
  public static final int REMOVE_NIL = 0; // remove() не вызывался
  public static final int REMOVE_OK = 1; // успешный вызов
  public static final int REMOVE_ERR = 2; // таблица заполнена
  public static final int GET_NIL = 0; // get() не вызывался
  public static final int GET_OK = 1; // успешный вызов
  public static final int GET_ERR = 2; // таблица заполнена

  private static final float EXPAND_COEF = 0.75f; // коэфициент заполнености при котором расширяем словарь
  private static final int RAISE_COEFF = 2; // коэф. на сколько увеличивать словарь
  private static final int DEFAULT_CAPACITY = 10; // емкость словаря по-умолчанию

  private Object[] buckets; // основное хранилище
  private int bucketsCount; // сколько ячеек занято в данный момент
  private int size; // количество элементов в словаре

  private int put_status;
  private int remove_status;
  private int get_status;

  public NativeDictinary() {
    buckets = new Object[DEFAULT_CAPACITY];
  }

  /**
   * Постусловие: инициализирует словарь переданного размера или 10 если переданный размер меньше
   */
  public NativeDictinary(int capacity) {
    if (capacity < DEFAULT_CAPACITY) {
      capacity = DEFAULT_CAPACITY;
    }

    buckets = new Object[capacity];
  }

  // команды

  /**
   * Предусловие: ключ ещё не присуиствует в словаре и не null
   * Постусловие: записывает значение в словарь, если ключ уже есть, заменяет его
   */
  public void put(String key, T value) {
    if (needExpand()) {
      expand();
    }

    put(new Entry<T>(key, value));
    if (put_status == PUT_OK) {
      size++;
    }
  }

  /**
   * Предусловие: ключ присуисивует в словаре
   * Постусловие: элемент удален из словаря
   */
  public void remove(String key) {
    int bucketNum = bucketNum(key);
    LinkedList<Entry<T>> bucket = (LinkedList<Entry<T>>) buckets[bucketNum];
    if (bucket == null || bucket.size() == 0) {
      remove_status = REMOVE_ERR;
    } else {
      bucket.head();
      while (true) {
        Entry<T> entry = bucket.get();
        if (entry.key.equals(key)) {
          bucket.remove();
          if (bucket.size() == 0) {
            buckets[bucketNum] = null;
          }
          remove_status = bucket.get_remove_status();
          break;
        } else if (bucket.is_tail()) {
          remove_status = REMOVE_ERR;
          break;
        } else {
          bucket.right();
        }
      }
    }
  }

  // запросы

  /**
   * Предусловие: ключ есть в словаре
   */
  public T get(String key) {
    int bucketNum = bucketNum(key);
    LinkedList<Entry<T>> bucket = (LinkedList<Entry<T>>) buckets[bucketNum];
    if (bucket == null || bucket.size() == 0) {
      get_status = GET_ERR;
      return null;
    } else {
      bucket.head();
      while (true) {
        Entry<T> entry = bucket.get();
        if (entry.key.equals(key)) {
          get_status = GET_OK;
          return entry.value;
        } else if (bucket.is_tail()) {
          get_status = GET_ERR;
          return null;
        } else {
          bucket.right();
        }
      }
    }
  }

  public boolean isKey(String key) {
    get(key);
    return get_status == GET_OK;
  }

  public int size() {
    return size();
  }

  // статусы

  public int get_put_status() {
    return put_status;
  }

  public int get_remove_status() {
    return remove_status;
  }

  public int get_get_status() {
    return get_status;
  }

  //---------------------------------

  private int bucketNum(String key) {
    int hash = key.hashCode();
    if (hash < 0) {
      hash = -hash;
    }
    return hash % buckets.length;
  }

  private boolean needExpand() {
    return (float) bucketsCount / buckets.length > EXPAND_COEF;
  }

  private void expand() {
    Object[] oldBuckets = buckets;
    buckets = new Object[oldBuckets.length * RAISE_COEFF];
    bucketsCount = 0;

    for (int i = 0, n = oldBuckets.length; i < n; i++) {
      LinkedList<Entry<T>> bucket = (LinkedList<Entry<T>>) oldBuckets[i];
      if (bucket == null || bucket.size() == 0) {
        continue;
      }
      bucket.head();
      put(bucket.get());

      while (!bucket.is_tail()) {
        bucket.right();
        put(bucket.get());
      }
    }
  }

  private void put(Entry<T> newEntry) {
    int bucketNum = bucketNum(newEntry.key);
    LinkedList<Entry<T>> entries = (LinkedList<Entry<T>>) buckets[bucketNum];
    if (entries == null) {
      entries = new LinkedList<Entry<T>>();
      buckets[bucketNum] = entries;
      bucketsCount++;
    }

    entries.head();

    if (entries.size() == 0) {
      entries.add_tail(newEntry);
      put_status = PUT_OK;
    } else {
      while (true) {
        Entry<T> entry = entries.get();
        if (entry.value.equals(newEntry.value)) {
          put_status = PUT_ERR;
          break;
        } else if (entries.is_tail()) {
          entries.add_tail(newEntry);
          put_status = PUT_OK;
          break;
        } else {
          entries.right();
        }
      }
    }
  }

  private class Entry<T> {

    private String key;
    private T value;

    private Entry(String key, T value) {
      this.key = key;
      this.value = value;
    }
  }
}
