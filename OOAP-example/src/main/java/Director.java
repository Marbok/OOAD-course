/**
 * Директор - сотрудник, который пишет отчеты
 */
public class Director extends Employee {

  public Director(long id, String name) {
    super(id, name);
  }

  /**
   * Постусловие: пишет отчет
   */
  @Override
  public void work() {
    System.out.println(String.format("I'm %s. Write report!", getName()));
    workStatus = WORK_OK;
  }
}
