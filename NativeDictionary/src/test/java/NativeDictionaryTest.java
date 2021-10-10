import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NativeDictionaryTest {

  @Test
  public void dictionary_test() {
    NativeDictinary<Integer> dict = new NativeDictinary<>();

    for (int i = 0; i < 20; i++) {
      dict.put(String.valueOf(i), i);
      assertEquals(NativeDictinary.PUT_OK, dict.get_put_status());
    }

    for (int i = 0; i < 20; i++) {
      assertEquals(Integer.valueOf(i), dict.get(String.valueOf(i)));
      assertEquals(NativeDictinary.GET_OK, dict.get_get_status());
    }

    for (int i = 10; i < 15; i++) {
      dict.remove(String.valueOf(i));
      assertEquals(NativeDictinary.REMOVE_OK, dict.get_remove_status());
    }

    for (int i = 20; i < 25; i++) {
      dict.put(String.valueOf(i), i);
      assertEquals(NativeDictinary.PUT_OK, dict.get_put_status());
    }

    for (int i = 0; i < 25; i++) {
      if (i >= 10 && i < 15) {
        assertFalse(dict.isKey(String.valueOf(i)));
      } else {
        assertTrue(dict.isKey(String.valueOf(i)));
      }
    }
  }
}
