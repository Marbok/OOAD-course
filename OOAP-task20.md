**Задание: Приведите примеры кода, реализующие наследование вариаций, наследование с конкретизацией и структурное наследование.**

Ответ:
1. Наследования вариаций:
```java
public class Bag {
    public void put(Item item) {
        // логика сохранения вещи
    }
}

public class MagicBag {
    public void put(Item item) {
        // удваивает положенную вещь и сохраняет обе
    }
}
```

2. Наследование с конкретизацией:
```java
public abstract class Gun {
    public abstract void shoot();
}

public class Pistol {
    public void shoot() {
        // логика стрельбы из пистолета
    }
}
```

3. Структурное наследование:
```java
public interface Flyable {
    void fly();
}

public class Dark implement Flyable {
    public void fly() {
        // логика полета
    }
}
```