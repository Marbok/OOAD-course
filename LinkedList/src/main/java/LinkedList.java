public abstract class LinkedList<T> {

  public static final int RIGHT_NIL = 0; //right() не вызывался
  public static final int RIGHT_OK = 0; //right() успешный вызов
  public static final int RIGHT_ERR = 0; //курсор в конце списка

  public static final int GET_NIL = 0; //get() не вызывался
  public static final int GET_OK = 0; //get() успешный вызов
  public static final int GET_ERR = 0; //список пустой

  public static final int REMOVE_NIL = 0; //remove() не вызывался
  public static final int REMOVE_OK = 0; //remove() успешный вызов
  public static final int REMOVE_ERR = 0; //список пустой

  public static final int REPLACE_NIL = 0; //replace() не вызывался
  public static final int REPLACE_OK = 0; //replace() успешный вызов
  public static final int REPLACE_ERR = 0; //список пустой

  public static final int FIND_NIL = 0; //find() не вызывался
  public static final int FIND_OK = 0; //find() успешный вызов
  public static final int FIND_ERR = 0; //элемент не найден

  private int right_status;
  private int get_status;
  private int remove_status;
  private int replace_status;
  private int find_status;

  //команды
  /**
   * Постусловие: курсор установлен на первом узле списка
   */
  public abstract void head();

  /**
   * Постусловие: курсор установлен на последнем узле списка
   */
  public abstract void tail();

  /**
   * Предусловие: курсор находится не на последнем элементе
   * Постусловие: курсор сдвинут на один элемент вправо
   */
  public abstract void right();

  /**
   * Постусловие: вставлен элемент в список после текущего узла
   */
  public abstract void put_right(T value);

  /**
   * Постусловие: вставлен элемент в список перед текущим узлом
   */
  public abstract void put_left(T value);

  /**
   * Предусловие: список не пустой
   * Постусловие: удален текущий елемент, курсор смещен к следующему
   */
  public abstract void remove();

  /**
   * Постусловие: очищен список
   */
  public abstract void clear();

  /**
   * Постусловие: добавлен елемент в конец списка
   */
  public abstract void add_tail(T value);

  /**
   * Предусловие: список не пустой
   * Постусловие: заменено текущее значение на переданное
   */
  public abstract void replace(T value);

  /**
   * Предусловие: елемента нет в списке
   * Постусловие: курсор установлен за переданным элементом
   */
  public abstract void find(T value);

  /**
   * Постусловие: удалены все елементы с переданым значением
   */
  public abstract void remove_all(T value);

  //запросы
  /**
   * Предусловие: список не пустой
   */
  public abstract T get();

  public abstract int size();

  public abstract boolean is_head();

  public abstract boolean is_tail();

  public abstract boolean is_value();

  //статусы
  public int get_right_status() {
    return right_status;
  }

  public int get_get_status() {
    return get_status;
  }

  public int get_remove_status() {
    return remove_status;
  }

  public int get_replace_status() {
    return replace_status;
  }

  public int get_find_status() {
    return find_status;
  }
}
