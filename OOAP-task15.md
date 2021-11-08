**Задание: Приведите пример небольшой иерархии, где вместо некоторого поля родительского класса с набором предопределённых значений (как в случае с полем female) применяется наследование.**

Ответ: Язык Java. Доступны 2 варианта:

1. "Плохой" класс
```java
class Cat {
    boolean wild;

    public void voice() {
        if (wild) {
            System.out.println("Rrrrrrr!!!");
        } else {
            System.out.println("meow!");
        }
    }
}
```

2. Правильная иерархия:
```java
abstract class Cat {
    public abstract void voice();
}

class WildCat extends Cat {
    public void voice() {
        System.out.println("Rrrrrrr!!!");
    }
}

class HomeCat extends Cat {
    public void voice() {
        System.out.println("meow!");
    }
}
```