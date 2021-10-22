/**
 * Описывает сотрудника на заводе
 */
public abstract class Employee {

  public static final int WORK_NIL = 0; // невызывался
  public static final int WORK_OK = 1;  // успешный вызов
  public static final int WORK_ERR = 2; // ошибка

  protected int workStatus;

  private final long id;      // id сотрудника
  private final String name;  // имя сотрудника

  /**
   * Постусловие: инициализирует нового сотрудника
   */
  public Employee(long id, String name) {
    this.id = id;
    this.name = name;
  }

  // команды

  /**
   * Постусловие: сотрудник выполняет свою работу
   */
  public abstract void work();

  // запросы

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  // статусы
  public int getWorkStatus() {
      return workStatus;
  }
}
