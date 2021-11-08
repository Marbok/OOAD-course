import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VectorTest {
    
    @Test
    public void testSum() {
        Vector<Number> v1 = new Vector<>();
        v1.add(new Number(1));
        v1.add(new Number(2));
        v1.add(new Number(3));

        Vector<Number> v2 = new Vector<>();
        v2.add(new Number(1));
        v2.add(new Number(2));
        v2.add(new Number(3));

        Vector<Number> v3 = v1.sum(v2);
        assertEquals(2, v3.get(0).num);
        assertEquals(4, v3.get(1).num);
        assertEquals(6, v3.get(2).num);
    }

    @Test
    public void testSum2() {
        Vector<Number> v1 = new Vector<>();
        v1.add(new Number(1));
        v1.add(new Number(2));
        v1.add(new Number(3));

        Vector<Vector<Number>> v2 = new Vector<>();
        v2.add(v1);
        v2.add(v1);

        Vector<Vector<Number>> v3 = new Vector<>();
        v3.add(v1);
        v3.add(v1);


        Vector<Vector<Number>> v4 = v3.sum(v2);
        assertEquals(2, v4.get(0).get(0).num);
        assertEquals(4, v4.get(0).get(1).num);
        assertEquals(6, v4.get(0).get(2).num);
        assertEquals(2, v4.get(1).get(0).num);
        assertEquals(4, v4.get(1).get(1).num);
        assertEquals(6, v4.get(1).get(2).num);
    }

    class Number extends Summable<Number> {
        private int num;

        Number(int num) {
            this.num = num;
        }

        @Override
        public Number sum(Number value) {
            return new Number(num + ((Number) value).num);
        }
    }
}
