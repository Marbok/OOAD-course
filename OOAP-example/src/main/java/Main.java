import java.util.ArrayList;
import java.util.List;

public class Main {

  /**
   * Постусловие: создает завод и работников, выполняет опер. день и печатает статус
   */
  public static void main(String[] args) {
    Factory factory = new Factory(createEmployees());
    factory.startOperationDay();
    if (
      factory.getStartOperationDayStatus() == Factory.START_OPERATION_DAY_OK
    ) {
      System.out.println("Operation day is successful");
    } else {
      System.out.println("Operation day is unsuccessful");
    }
  }

  private static List<Employee> createEmployees() {
    List<Employee> employees = new ArrayList<Employee>();
    employees.add(new Director(0, "Edvard Director"));
    employees.add(new Worker(1, "Bill Worker"));
    employees.add(new Worker(2, "Sam Worker"));
    return employees;
  }
}
