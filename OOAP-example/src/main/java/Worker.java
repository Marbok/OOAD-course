/**
 * Рабочий - сотрудник, который умеет копать
 */
public class Worker extends Employee {

    public Worker(long id, String name) {
        super(id, name);
    }

    /**
     * Постусловие: копает яму
     */
    @Override
    public void work() {
        System.out.println(String.format("I'm %s. Dig a hole!", getName()));
        workStatus = WORK_OK;
    }
    
}
