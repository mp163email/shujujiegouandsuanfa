package 队列;

/**
 * 知识点-通过接口，实现不同的实现（多态）
 * 知识点-数组跟链表是2个最底层，最基本的数据结构。 数组是静态的， 链表是动态的
 * 上层的数据结构有：栈(Stack)， 队列(Queue)， 列表（List）
 * 用数组跟链表都可以实现栈，队列,栈和列表 （入栈-从尾巴上加入，出栈-从尾巴上再拿出来）， 队列（入队-向尾巴上加，出队-从头上取）。
 * 用数组实现队列的时候，有2中方式，1中是纯数组，性能低，因为出队的时候所有索引要移动一下。第2种是循环数组，定义了一个front和tail
 * @param <E>
 */
public interface Queue<E> {
    void inQueue(E e);
    E outQueue();
    E getFront();
    int size();
    boolean isEmpty();
}
