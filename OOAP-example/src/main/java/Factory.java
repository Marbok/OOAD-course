import java.util.List;

public class Factory {

  public static final int START_OPERATION_DAY_NIL = 0;
  public static final int START_OPERATION_DAY_OK = 1;
  public static final int START_OPERATION_DAY_ERR = 2;

  private int startOperationDayStatus;

  private List<Employee> employees;

  /**
   * Постусловие: инициализирует новую фабрику
   */
  public Factory(List<Employee> employees) {
    this.employees = employees;
  }

  // команды

  /**
   * Постусловие: заставляет сотрудников выполнять свою работу
   */
  public void startOperationDay() {
    employees.forEach(Employee::work);
    if (
      employees
        .stream()
        .map(Employee::getWorkStatus)
        .anyMatch(status -> status != Employee.WORK_OK)
    ) {
      startOperationDayStatus = START_OPERATION_DAY_ERR;
    } else {
      startOperationDayStatus = START_OPERATION_DAY_OK;
    }
  }

  // статусы

  public int getStartOperationDayStatus() {
    return startOperationDayStatus;
  }
}
