package 栈;

public interface StackInter<T> {

    void push (T t);

    T pop();

    T peek();

    int size();

    boolean isEmpty();
}
