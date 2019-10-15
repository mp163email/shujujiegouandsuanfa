package 集合和映射07.集合;

/**
 * 集合的接口
 * @param <E>
 */
public interface Set<E> {
    void add(E e);
    void remove (E e);
    boolean contains(E e);
    int size();
    boolean isEmpty();
}
