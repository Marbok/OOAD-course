public class TwoWayList<T> extends ParentList<T> {

  public static final int LEFT_NIL = 0; //left() не вызывался
  public static final int LEFT_OK = 1; //left() успешный вызов
  public static final int LEFT_ERR = 2; //курсор в начале списка

  private int left_status;

  /**
   * Предусловие: курсор находится не на первом элементе
   * Постусловие: курсор сдвинут на один элемент влево
   */
  public void left() {
    if (root != null && cursor.left != null) {
      left_status = LEFT_OK;
      cursor = cursor.left;
    } else {
      left_status = LEFT_ERR;
    }
  }

  public int get_left_status() {
    return left_status;
  }
}
