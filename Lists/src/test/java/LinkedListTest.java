import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

  @Test
  public void add_tail_test() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);
    list.add_tail(20);
    list.add_tail(30);

    list.head();
    Assert.assertEquals(Integer.valueOf(15), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(20), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(30), list.get());
  }

  @Test
  public void put_right_test() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);

    list.head();
    list.put_right(20);
    Assert.assertEquals(list.get_put_right_status(), LinkedList.PUT_RIGHT_OK);

    list.put_right(30);
    Assert.assertEquals(list.get_put_right_status(), LinkedList.PUT_RIGHT_OK);

    list.head();
    Assert.assertEquals(Integer.valueOf(15), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(30), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(20), list.get());
  }

  @Test
  public void put_left_test() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);

    list.head();
    list.put_left(20);
    Assert.assertEquals(list.get_put_left_status(), LinkedList.PUT_LEFT_OK);

    list.put_left(30);
    Assert.assertEquals(list.get_put_left_status(), LinkedList.PUT_LEFT_OK);

    list.head();
    Assert.assertEquals(Integer.valueOf(20), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(30), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(15), list.get());
  }

  @Test
  public void remove_test_head() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);
    list.add_tail(20);
    list.add_tail(30);

    list.head();
    list.remove();

    list.head();
    Assert.assertEquals(Integer.valueOf(20), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(30), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_ERR);
  }

  @Test
  public void remove_test_middle() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);
    list.add_tail(20);
    list.add_tail(30);

    list.head();
    list.right();
    list.remove();

    list.head();
    Assert.assertEquals(Integer.valueOf(15), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(30), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_ERR);
  }

  @Test
  public void remove_test_tail() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);
    list.add_tail(20);
    list.add_tail(30);

    list.tail();
    list.remove();

    list.head();
    Assert.assertEquals(Integer.valueOf(15), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(20), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_ERR);
  }

  @Test
  public void right_error_test() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);
    list.add_tail(20);
    list.add_tail(30);

    list.head();
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_ERR);
  }

  @Test
  public void remove_all_test() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);
    list.add_tail(20);
    list.add_tail(15);
    list.add_tail(30);
    list.add_tail(15);

    list.remove_all(15);

    list.head();
    Assert.assertEquals(Integer.valueOf(20), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(30), list.get());
  }

  @Test
  public void find_test() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);
    list.add_tail(20);
    list.add_tail(15);
    list.add_tail(30);
    list.add_tail(15);

    list.find(15);
    Assert.assertEquals(Integer.valueOf(20), list.get());
    list.find(15);
    Assert.assertEquals(Integer.valueOf(30), list.get());
    list.find(15);
    Assert.assertEquals(list.get_find_status(), LinkedList.FIND_ERR);
  }

  @Test
  public void replace_test() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);
    list.add_tail(20);
    list.add_tail(30);

    list.head();
    list.right();
    list.replace(50);

    list.head();
    Assert.assertEquals(Integer.valueOf(15), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(50), list.get());
    list.right();
    Assert.assertEquals(list.get_right_status(), LinkedList.RIGHT_OK);
    Assert.assertEquals(Integer.valueOf(30), list.get());
  }

  @Test
  public void size_test() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add_tail(15);
    list.add_tail(20);
    list.add_tail(30);

    Assert.assertEquals(3, list.size());
  }
}
