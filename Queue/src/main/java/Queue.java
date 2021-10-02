public class Queue<T> {

  public static final int HEAD_NIL = 0; // head() не вызывался
  public static final int HEAD_OK = 1; // успешный вызов
  public static final int HEAD_ERR = 2; // очередь пуста
  public static final int REMOVE_NIL = 0; // remove() не вызывался
  public static final int REMOVE_OK = 1; // успешный вызов
  public static final int REMOVE_ERR = 2; // очередь пуста

  private Node<T> head;
  private Node<T> tail;
  private int size;

  private int head_status;
  private int remove_status;

  // команды

  /**
   * Постусловие: добавляет элемент в конец очереди
   */
  public void push(T value) {
    if (head == null) {
      head = new Node<T>(value);
      tail = head;
    } else {
      tail.next = new Node<T>(value);
      tail = tail.next;
    }
    size++;
  }

  /**
   * Предусловие: очередь не пуста
   * Постусловие: удаляет верхний элемент из очереди
   */
  public void remove() {
    if (head == null) {
      remove_status = REMOVE_ERR;
    } else {
      head = head.next;
      size--;
      remove_status = REMOVE_OK;
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

  public int get_remove_status() {
    return remove_status;
  }

  private class Node<T> {

    private T value;
    private Node<T> next;

    private Node(T value) {
      this.value = value;
    }
  }
}
