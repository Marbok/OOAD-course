import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueTest {
    
    @Test
    public void queue_test() {
        Queue<String> queue = new Queue<String>();
        queue.push("test1");
        queue.push("test2");
        queue.push("test3");

        assertEquals(3, queue.size());
        assertEquals("test1", queue.head());
        queue.remove();
        assertEquals(Queue.REMOVE_OK, queue.get_remove_status());
        assertEquals("test2", queue.head());
        queue.remove();
        assertEquals(Queue.REMOVE_OK, queue.get_remove_status());
        assertEquals("test3", queue.head());
        queue.remove();
        assertEquals(Queue.REMOVE_OK, queue.get_remove_status());
        assertEquals(0, queue.size());
    }

    @Test
    public void remove_error_test() {
        Queue<String> queue = new Queue<String>();
        queue.remove();

        assertEquals(Queue.REMOVE_ERR, queue.get_remove_status());
    }

    @Test
    public void head_error_test() {
        Queue<String> queue = new Queue<String>();
        queue.head();

        assertEquals(Queue.HEAD_ERR, queue.get_head_status());
    }
}
