**Задание: Приведите примеры кода с ковариантностью и контравариантностью, если ваш язык программирования это позволяет.**

Ответ: Язык Java.

Ковариантность
```java
List<Integer> ints = new ArrayList<Integer>();
List<? extends Number> nums = ints;
```

Контравариантность
```java
List<Number> nums = new ArrayList<Number>();
List<? super Integer> ints = nums;
```