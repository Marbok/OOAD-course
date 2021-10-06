import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HashTableTest {

  @Test
  public void hashtable_test() {
    HashTable<Integer> table = new HashTable<>(10);
    for (int i = 0; i < 10; i++) {
      table.put(i);
      assertEquals(HashTable.PUT_OK, table.get_put_status());
      if (i < 9) {
        assertFalse(table.isFull());
      }
    }

    assertTrue(table.isFull());

    table.put(11);
    assertEquals(HashTable.PUT_ERR, table.get_put_status());

    for (int i = 0; i < 10; i++) {
      assertTrue(table.hasValue(i));
    }

    table.remove(7);
    assertFalse(table.hasValue(7));
    assertFalse(table.isFull());

    table.put(11);
    assertTrue(table.hasValue(11));
    assertTrue(table.isFull());
  }
}
