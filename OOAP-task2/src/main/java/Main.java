// Класс телевизор - умеет показывать ТВ-вещание
class TV {
    public void show() {
        // вещает
    }
}

// Класс умного-телевизора - расширяет телевизор, получая возможноть выходить в интернет
class SmartTV extends TV {
    public void browser() {
        // выходит в интернет
    }
}


// Умеет сохранять значение
class Store<K,V> {
    public void save(K key, V value) {
        Object compObject = compress(value);
        // сохраняет значение
    }

    public V get(K key) {
        V value =null; // получает значение по ключу
        return uncompress(value);
    }

    protected Object compress(V value) {
        // сжатия нет, просто возвращает объект
        return value;
    }

    protected V uncompress(Object value) {
        // разжатия нет, просто возвращает объект
        return (V) value;
    }
}


// Специализирует родителя, путем компрессии файлов перед сохранением
class ZipStore<K,V> extends Store<K,V> {
    protected Object compress(Object value) {
        // сжимает объект
        return value;
    }

    protected V uncompress(Object value) {
        // разжимает объект
        return (V) value;
    }
}
