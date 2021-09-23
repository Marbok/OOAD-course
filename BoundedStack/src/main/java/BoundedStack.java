import java.util.*;

public class BoundedStack<T> {

  // скрытые поля
  private List<T> stack;   // основное хранилище стека
  private int peek_status; // статус запроса peek()
  private int pop_status;  // статус команды pop()
  private int push_status; // статус команды push()
  private int capacity;    // максимальный размер стека

  private static final int DEFAULT_CAPACITY = 32; // дефолтный размер стека

  // интерфейс класса, реализующий АТД Stack
  public static final int POP_NIL = 0;
  public static final int POP_OK = 1;
  public static final int POP_ERR = 2;

  public static final int PEEK_NIL = 0;
  public static final int PEEK_OK = 1;
  public static final int PEEK_ERR = 2;

  public static final int PUSH_NIL = 0;
  public static final int PUSH_OK = 1;
  public static final int PUSH_ERR = 2;

  public BoundedStack() { // дефолтный конструкор
    this(DEFAULT_CAPACITY);
  }

  public BoundedStack(int capacity) { // конструктор с параметром
    stack = new ArrayList<>(capacity);
  }
  
  /**
   * Предусловие: размер стека меньше заданного
   * Постусловие: в стек добавлен переданный элемент
   */
  public void push(T value) {
    if (size() < capacity) {
      stack.add(value);
      push_status = PUSH_OK;
    } else {
      push_status = PUSH_ERR;
    }
  }

  /**
   * Предусловие: стек не пустой
   * Постусловие: из стека удален верхний элемент
   */
  public void pop() {
    if (size() > 0) {
      stack.remove(size() - 1);
      pop_status = POP_OK;
    } else {
      pop_status = POP_ERR;
    }
  }

  /**
   * Постусловие: стек очищен и статусы установлены в начальные
   */
  public void clear() {
    stack.clear(); // пустой список/стек

    // начальные статусы для предусловий peek(), pop(), push()
    peek_status = PEEK_NIL;
    pop_status = POP_NIL;
    push_status = PUSH_NIL;
  }

  /**
   * Предусловие: стек не пустой
   */
  public T peek() {
    T result = null;
    if (size() > 0){
      result = stack.get(size() - 1);
      peek_status = PEEK_OK;
    }else{
      peek_status = PEEK_ERR;
    }
    return result;
  }

  public int size() {
    return stack.size();
  }

  // запросы статусов
  public int get_pop_status() {
    return pop_status;
  }

  public int get_peek_status() {
    return peek_status;
  }

  public int get_push_status() {
    return push_status;
  }

}
