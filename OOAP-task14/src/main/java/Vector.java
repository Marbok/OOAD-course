import java.util.ArrayList;
import java.util.List;

class Vector<T extends Summable<T>> extends Summable<Vector<T>> {
    private final List<T> vector = new ArrayList<T>();

    // Commands
    public void add(T value) {
        vector.add(value);
    }

    // Queries

    // Предусловте: векторы имеют одинаковую длину
    @Override
    public Vector<T> sum(Vector<T> other) {
        if (size() != other.size()) {
            return null;
        }
        
        Vector<T> res = new Vector<T>();
        for (int i = 0; i < vector.size(); i++) {
            T one = vector.get(i);
            T two = other.get(i);
            T sum = one.sum(two);
            res.add(sum);
        }
        return res;
    }

    public T get(int index) {
        return vector.get(index);
    }

    public int size() {
        return vector.size();
    }

}