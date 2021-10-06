public abstract class ParentQueue<T> {

  public static final int HEAD_NIL = 0; // head() не вызывался
  public static final int HEAD_OK = 1; // успешный вызов
  public static final int HEAD_ERR = 2; // очередь пуста
  public static final int REMOVE_HEAD_NIL = 0; // remove_head() не вызывался
  public static final int REMOVE_HEAD_OK = 1; // успешный вызов
  public static final int REMOVE_HEAD_ERR = 2; // очередь пуста

  protected Node<T> head;
  protected Node<T> tail;
  protected int size;

  private int head_status;
  private int remove_head_status;

  // команды

  /**
   * Постусловие: добавляет элемент в конец очереди
   */
  public void add_tail(T value) {
    if (head == null) {
      head = new Node<T>(value);
      tail = head;
    } else {
      tail.next = new Node<T>(value);
      tail.next.prev = tail;
      tail = tail.next;
    }
    size++;
  }

  /**
   * Предусловие: очередь не пуста
   * Постусловие: удаляет верхний элемент из очереди
   */
  public void remove_head() {
    if (head == null) {
      remove_head_status = REMOVE_HEAD_ERR;
    } else {
      head = head.next;
      if (head != null) {
        head.prev = null;
      } else {
        tail = null;
      }
      size--;
      remove_head_status = REMOVE_HEAD_OK;
    }
  }

  // запросы

  /**
   * Предусловие: очередь не пуста
   */
  public T head() {
    T value = null;
    if (head == null) {
      head_status = HEAD_ERR;
    } else {
      value = head.value;
      head_status = HEAD_OK;
    }
    return value;
  }

  public int size() {
    return size;
  }

  // статусы

  public int get_head_status() {
    return head_status;
  }

  public int get_remove_head_status() {
    return remove_head_status;
  }

  protected class Node<T> {

    protected T value;
    protected Node<T> next;
    protected Node<T> prev;

    protected Node(T value) {
      this.value = value;
    }
  }
}
