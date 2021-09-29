import org.junit.Assert;
import org.junit.Test;

public class TwoWayListTest {

  @Test
  public void left_error_test() {
    TwoWayList<Integer> list = new TwoWayList<>();
    list.add_tail(15);
    list.add_tail(20);
    list.add_tail(30);

    list.tail();
    list.left();
    Assert.assertEquals(list.get_left_status(), TwoWayList.LEFT_OK);
    list.left();
    Assert.assertEquals(list.get_left_status(), TwoWayList.LEFT_OK);
    list.left();
    Assert.assertEquals(list.get_left_status(), TwoWayList.LEFT_ERR);
  }
}
