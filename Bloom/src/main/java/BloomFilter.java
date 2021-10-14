public class BloomFilter {

  public static final int ADD_NIL = 0; // add() не вызывался
  public static final int ADD_OK = 1; // успешно
  public static final int ADD_ERR = 2; // фильтр заполнен

  private final int filter_len;
  private int size = 0;
  private int filter = 0;
  private int add_status;

  /**
   * Постусловие: инициализирует фильтр
   */
  public BloomFilter(int f_len) {
    filter_len = f_len;
  }

  // Команды

  /**
   * Предусловие: фильтр не заполнен
   * Постусловие: элемент добавлен в фильтр
   */
  public void add(String str) {
    if (size == filter_len) {
      add_status = ADD_ERR;
    } else {
      size++;
      filter |= mask(str);
      add_status = ADD_OK;
    }
  }

  // Запросы

  public boolean isValue(String str) {
    int mask = mask(str);
    return (filter & mask) == mask;
  }

  public int size() {
    return size;
  }

  // Статусы

  public int get_add_status() {
    return add_status;
  }

  private int mask(String str) {
    int index1 = hash1(str);
    int index2 = hash2(str);
    return 1 << index1 | 1 << index2;
  }

  // хэш-функции
  private int hash1(String str1) {
    // 17
    return hash(str1, 17);
  }

  private int hash2(String str1) {
    // 223
    return hash(str1, 223);
  }

  private int hash(String str, int num) {
    int hash = 0;
    for (int i = 0; i < str.length(); i++) {
      int code = (int) str.charAt(i);
      hash = (hash * num + code) % filter_len;
    }
    return hash;
  }
}
