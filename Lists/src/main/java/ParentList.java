public abstract class ParentList<T> {

  public static final int RIGHT_NIL = 0; //right() не вызывался
  public static final int RIGHT_OK = 1; //right() успешный вызов
  public static final int RIGHT_ERR = 2; //курсор в конце списка

  public static final int GET_NIL = 0; //get() не вызывался
  public static final int GET_OK = 1; //get() успешный вызов
  public static final int GET_ERR = 2; //список пустой

  public static final int REMOVE_NIL = 0; //remove() не вызывался
  public static final int REMOVE_OK = 1; //remove() успешный вызов
  public static final int REMOVE_ERR = 2; //список пустой

  public static final int REPLACE_NIL = 0; //replace() не вызывался
  public static final int REPLACE_OK = 1; //replace() успешный вызов
  public static final int REPLACE_ERR = 2; //список пустой

  public static final int FIND_NIL = 0; //find() не вызывался
  public static final int FIND_OK = 1; //find() успешный вызов
  public static final int FIND_ERR = 2; //элемент не найден

  public static final int PUT_LEFT_NIL = 0; //put_left() не вызывался
  public static final int PUT_LEFT_OK = 1; //put_left() успешный вызов
  public static final int PUT_LEFT_ERR = 2; //список пустой

  public static final int PUT_RIGHT_NIL = 0; //put_right() не вызывался
  public static final int PUT_RIGHT_OK = 1; //put_right() успешный вызов
  public static final int PUT_RIGHT_ERR = 2; //список пустой

  private int right_status;
  private int get_status;
  private int remove_status;
  private int replace_status;
  private int find_status;
  private int put_right_status;
  private int put_left_status;

  private int size;

  protected Node<T> cursor;
  protected Node<T> root;
  protected Node<T> tail;

  //команды
  /**
   * Постусловие: курсор установлен на первом узле списка
   */
  public void head() {
    cursor = root;
  }

  /**
   * Постусловие: курсор установлен на последнем узле списка
   */
  public void tail() {
    cursor = tail;
  }

  /**
   * Предусловие: курсор находится не на последнем элементе
   * Постусловие: курсор сдвинут на один элемент вправо
   */
  public void right() {
    if (root != null && cursor.right != null) {
      right_status = RIGHT_OK;
      cursor = cursor.right;
    } else {
      right_status = RIGHT_ERR;
    }
  }

  /**
   * Предусловие: список не пустой
   * Постусловие: вставлен элемент в список после текущего узла
   */
  public void put_right(T value) {
    if (root != null) {
      put_right_status = PUT_RIGHT_OK;
      Node<T> node = new Node<>(value);
      node.left = cursor;
      if (cursor.right == null) {
        cursor.right = node;
        tail = node;
      } else {
        node.right = cursor.right;
        cursor.right.left = node;
        cursor.right = node;
      }
      size++;
    } else {
      put_right_status = PUT_RIGHT_ERR;
    }
  }

  /**
   * Предусловие: список не пустой:
   * Постусловие: вставлен элемент в список перед текущим узлом
   */
  public void put_left(T value) {
    if (root != null) {
      put_left_status = PUT_LEFT_OK;
      Node<T> node = new Node<T>(value);
      node.right = cursor;
      if (cursor.left == null) {
        cursor.left = node;
        root = node;
      } else {
        node.left = cursor.left;
        cursor.left.right = node;
        cursor.left = node;
      }
      size++;
    } else {
      put_left_status = PUT_LEFT_ERR;
    }
  }

  /**
   * Предусловие: список не пустой
   * Постусловие: удален текущий элемент, курсор смещен вправо, если невозможно, то влево
   */
  public void remove() {
    if (root != null) {
      remove_status = REMOVE_OK;
      if (cursor.left == null && cursor.right == null) {
        root = null;
        tail = null;
        cursor = null;
      } else if (cursor.left == null) {
        root = cursor.right;
        cursor = cursor.right;
        cursor.left = null;
      } else if (cursor.right == null) {
        tail = cursor.left;
        cursor = cursor.left;
        cursor.right = null;
      } else {
        cursor.left.right = cursor.right;
        cursor.right.left = cursor.left;
        cursor = cursor.right;
      }
      size--;
    } else {
      remove_status = REMOVE_ERR;
    }
  }

  /**
   * Постусловие: очищен список
   */
  public void clear() {
    root = null;
    tail = null;
    cursor = null;
    size = 0;
  }

  /**
   * Постусловие: добавлен элемент в конец списка
   */
  public void add_tail(T value) {
    Node<T> node = new Node<T>(value);
    if (tail == null) {
      root = node;
      tail = node;
      cursor = node;
    } else {
      tail.right = node;
      node.left = tail;
      tail = node;
    }
    size++;
  }

  /**
   * Предусловие: список не пустой
   * Постусловие: заменено текущее значение на переданное
   */
  public void replace(T value) {
    if (root != null) {
      replace_status = REPLACE_OK;
      cursor.value = value;
    } else {
      replace_status = REPLACE_ERR;
    }
  }

  /**
   * Предусловие: список не пустой
   * Постусловие: курсор установлен на найденном элементе, следующим за текущем
   */
  public void find(T value) {
    if (root != null) {
      while (!is_tail()) {
        if (cursor.value.equals(value)) {
          right();
          if (get_right_status() == RIGHT_OK) {
            find_status = FIND_OK;
          } else {
            find_status = FIND_ERR;
          }
          return;
        }
        right();
      }
    }
    find_status = FIND_ERR;
  }

  /**
   * Постусловие: удалены все элементы с переданым значением
   */
  public void remove_all(T value) {
    if (root == null) { // список пуст
      return;
    }

    head();
    right_status = RIGHT_NIL;
    while (get_right_status() != RIGHT_ERR) {
      if (cursor.value.equals(value)) {
        remove();
        size--;
      } else {
        right();
      }
    }
  }

  //запросы
  /**
   * Предусловие: список не пустой
   */
  public T get() {
    T value = null;
    if (root != null) {
      get_status = GET_OK;
      value = cursor.value;
    } else {
      get_status = GET_ERR;
    }
    return value;
  }

  public int size() {
    return size;
  }

  public boolean is_head() {
    return cursor == root;
  }

  public boolean is_tail() {
    return cursor == tail;
  }

  public boolean is_value() {
    return cursor != null;
  }

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

  public int get_put_left_status() {
    return put_left_status;
  }

  public int get_put_right_status() {
    return put_right_status;
  }

  /**
   * Узел в связном списке
   */
  protected class Node<T> {

    protected T value;
    protected Node<T> left;
    protected Node<T> right;

    public Node(T value) {
      this.value = value;
    }
  }
}
