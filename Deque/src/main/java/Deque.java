public class Deque<T> extends ParentQueue<T> {

  public static final int TAIL_NIL = 0; // tail() не вызывался
  public static final int TAIL_OK = 1; // успешный вызов
  public static final int TAIL_ERR = 2; // очередь пуста
  public static final int REMOVE_TAIL_NIL = 0; // remove_tail() не вызывался
  public static final int REMOVE_TAIL_OK = 1; // успешный вызов
  public static final int REMOVE_TAIL_ERR = 2; // очередь пуста

  private int tail_status;
  private int remove_tail_status;

  // команды

  /**
   * Постусловие: добавляет элемент в начало очереди
   */
  public void add_head(T value) {
    if (head == null) {
      head = new Node<T>(value);
      tail = head;
    } else {
      head.prev = new Node<T>(value);
      head.prev.next = head;
      head = head.prev;
    }
    size++;
  }

  /**
   * Предусловие: очередь не пуста
   * Постусловие: удаляет последний элемент из очереди
   */
  public void remove_tail() {
    if (head == null) {
      remove_tail_status = REMOVE_TAIL_ERR;
    } else {
      tail = tail.prev;
      if (tail != null) {
        tail.next = null;
      } else {
        head = null;
      }
      size--;
      remove_tail_status = REMOVE_TAIL_OK;
    }
  }

  // запросы

  /**
   * Предусловие: очередь не пуста
   */
  public T tail() {
    T value = null;
    if (head == null) {
      tail_status = TAIL_ERR;
    } else {
      value = tail.value;
      tail_status = TAIL_OK;
    }
    return value;
  }

  public int size() {
    return size;
  }

  // статусы

  public int get_remove_tail_status() {
    return remove_tail_status;
  }

  public int get_tail_status() {
    return tail_status;
  }
}
