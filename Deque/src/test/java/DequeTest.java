import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DequeTest {
    
    @Test
    public void deque_test() {
        Deque<String> deque = new Deque<String>();
        deque.add_head("test1");
        deque.add_head("test2");
        deque.add_head("test3");

        assertEquals(3, deque.size());
        assertEquals("test1", deque.tail());
        deque.remove_tail();
        assertEquals(Deque.REMOVE_TAIL_OK, deque.get_remove_tail_status());
        assertEquals("test2", deque.tail());
        deque.remove_tail();
        assertEquals(Deque.REMOVE_TAIL_OK, deque.get_remove_tail_status());
        assertEquals("test3", deque.tail());
        deque.remove_tail();
        assertEquals(Deque.REMOVE_TAIL_OK, deque.get_remove_tail_status());
        assertEquals(0, deque.size());

        deque.add_head("test4");
        deque.add_head("test5");

        assertEquals(2, deque.size());
        assertEquals("test4", deque.tail());
        deque.remove_tail();
        assertEquals(Deque.REMOVE_TAIL_OK, deque.get_remove_tail_status());
        assertEquals("test5", deque.tail());
        deque.remove_tail();
        assertEquals(Deque.REMOVE_TAIL_OK, deque.get_remove_tail_status());
        assertEquals(0, deque.size());
    }

    @Test
    public void remove_tail_error_test() {
        Deque<String> deque = new Deque<String>();
        deque.remove_tail();

        assertEquals(Deque.REMOVE_TAIL_ERR, deque.get_remove_tail_status());
    }

    @Test
    public void tail_error_test() {
        Deque<String> deque = new Deque<String>();
        deque.tail();

        assertEquals(Deque.HEAD_ERR, deque.get_tail_status());
    }
}
