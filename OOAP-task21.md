**Задание: Приведите пример кода, где выполняется наследование реализации и льготное наследование.**

Ответ:
1. Наследование реализации:
В java у классов наследников нет доступа к закрытым полям и методам, только к публичным или специально открытых для наследования.

2. Льготное наследование:
```java
/*
    Товарное дерево - представляет собой структуру данных дерево, листьями которого являются товары,
    а остальные узлы можно параметризировать в зависимости от потребителя.
*/
public class GoodsTree<T extends Comparable> {
    public void addGood(Good good, T parent) {
        // логика добавления товара
    }

    public void removeGood(Good good) {
        // логика удаления
    }
}

/*
    Категорийное дерево - товары разделены по иерархии категорий
*/
public class CategoryTree extends GoodTree<Category> {

}

/*
    Размерное дерево - товары поделены по иерархии размеров
*/
public class SizeTree extends GoodTree<Size> {

}
```