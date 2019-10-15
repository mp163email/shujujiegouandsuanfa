package 链表;

import 队列.Queue;

/**
 * des: 知识点：使用带有尾节点的链表实现队列
 * 知识点：有了尾节点， 在向尾节点插入元素的时候，就不需要遍历整个链表了
 * 知识点：但是删除尾节点，还是要遍历整个链表，因为需要知道尾节点的前一个元素
 * created by miapoeng on 2019/8/15 17:33
 */
public class QueueByLinkedList<E> implements Queue<E> {

    private class Node<E> {
        E e;
        Node next;

        public Node() {
            e = null;
            next = null;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public QueueByLinkedList () {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 入队
     * 向链表尾部插入元素
     * @param e
     */
    @Override
    public void inQueue(E e) {
        //插入第一个元素的时候
        if (tail == null) {
            tail = new Node<E>(e);
            head = tail;
        } else {
            Node<E> node = new Node<E>(e);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E outQueue() {
        if (head == null) {
            return null;
        } else {
            E retE = head.e;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return retE;
        }
    }

    @Override
    public E getFront() {
        if (head == null) {
            return null;
        } else {
            E retE = head.e;
            return retE;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size()).append("\t");
        Node node = head;
        while (node != null) {
            sb.append(node.e);
            if (node.next != null) {
                sb.append(",");
            }
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueByLinkedList<Integer> arrayQueue = new QueueByLinkedList<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.inQueue(i);
        }
        System.out.println(arrayQueue);
        for (int i = 0; i < 5; i++) {
            arrayQueue.outQueue();
        }
        System.out.println(arrayQueue);
    }
}
