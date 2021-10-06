import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueTest {

  @Test
  public void queue_test() {
    Queue<String> queue = new Queue<String>();
    queue.add_tail("test1");
    queue.add_tail("test2");
    queue.add_tail("test3");

    assertEquals(3, queue.size());
    assertEquals("test1", queue.head());
    queue.remove_head();
    assertEquals(Queue.REMOVE_HEAD_OK, queue.get_remove_head_status());
    assertEquals("test2", queue.head());
    queue.remove_head();
    assertEquals(Queue.REMOVE_HEAD_OK, queue.get_remove_head_status());
    assertEquals("test3", queue.head());
    queue.remove_head();
    assertEquals(Queue.REMOVE_HEAD_OK, queue.get_remove_head_status());
    assertEquals(0, queue.size());

    queue.add_tail("test4");
    queue.add_tail("test5");

    assertEquals(2, queue.size());
    assertEquals("test4", queue.head());
    queue.remove_head();
    assertEquals(Queue.REMOVE_HEAD_OK, queue.get_remove_head_status());
    assertEquals("test5", queue.head());
    queue.remove_head();
    assertEquals(Queue.REMOVE_HEAD_OK, queue.get_remove_head_status());
    assertEquals(0, queue.size());
  }

  @Test
  public void remove_head_error_test() {
    Queue<String> queue = new Queue<String>();
    queue.remove_head();

    assertEquals(Queue.REMOVE_HEAD_ERR, queue.get_remove_head_status());
  }

  @Test
  public void head_error_test() {
    Queue<String> queue = new Queue<String>();
    queue.head();

    assertEquals(Queue.HEAD_ERR, queue.get_head_status());
  }
}
