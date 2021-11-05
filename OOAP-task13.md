**Задание: Разберитесь, какие из четырёх вариантов скрытия методов доступны в используемом вами языке программирования. Приведите примеры кода для каждого из доступных вариантов.**

Ответ: Язык Java. Доступны 2 варианта:

1. Метод публичен в родительском классе А и публичен в его потомке B; Реализовано с помощью модификатора public в родителе и потомке.
```java
public class TestClass {
    public void test() {
        // test
    }
}

public class CarTest {
    public void test() {
        //test
    }
}
```

2. Метод скрыт в родительском классе А и публичен в его потомке B. В родительском классе модификатор protected, в потомке public
```java
public class TestClass {
    protected void test() {
        // test
    }
}

public class CarTest {
    public void test() {
        //test
    }
}
```
2. Метод скрыт в родительском классе А и скрыт в его потомке B. Реализовано с помощью модификатора protected в родителе и потомке.
```java
public class TestClass {
    protected void test() {
        // test
    }
}

public class CarTest {
    protected void test() {
        //test
    }
}
```