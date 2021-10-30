public class Main {

  public static void main(String[] args) {
    // создаем дом и селим в него обычную собаку
    House house = new House(new Dog());
    // при открытии двери, вызовется метод лаять из класса собака
    house.openDoor();

    // создаем умный дом и селим туда робопса
    House smartHouse = new House(new RoboDog());
    // при открытии двери, вызовется метод лаять из класса робопес
    smartHouse.openDoor();
  }
}

// Класс дом, в доме есть собака
class House {

  private final Dog dog;

  // селим собаку в дом
  public House(Dog dog) {
    this.dog = dog;
  }

  // Открываем дверь - собака начинает лаять
  public void openDoor() {
    dog.bark();
  }
}

// Класс собака - умеет лаять
class Dog {

  public void bark() {
    System.out.println("Waw!!!");
  }
}

// Класс робопес - умеет лаять, как обычная собака, но делает это иначе
class RoboDog extends Dog {

  // метод лаять - переопределен
  @Override
  public void bark() {
    System.out.println("RoboWaw!!!");
  }
}
