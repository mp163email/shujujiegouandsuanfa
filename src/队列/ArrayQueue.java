package 队列;

import 数组.MyArray;

/**
 * des:
 * created by miapoeng on 2019/8/12 19:54
 */
public class ArrayQueue<E> implements Queue<E> {

    private MyArray<E> myArray;

    public ArrayQueue(int capacity) {//知识点1-构造方法不使用泛型
        myArray = new MyArray<>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    /**
     * 入队
     */
    @Override
    public void inQueue(E e) {
        myArray.addLast(e);
    }


    /**
     * 出队
     * @return
     */
    @Override
    public E outQueue() {
        return myArray.removeFirst();
    }

    @Override
    public E getFront() {
        return myArray.getFirst();
    }

    @Override
    public int size() {
        return myArray.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("capacity=").append(myArray.capacity()).append("  ");
        sb.append("size = ").append(size()).append("\t");
        for (int i = 0; i < myArray.size(); i++) {
            E t = myArray.get(i);
            sb.append(t);
            if (i < size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
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
