package 队列;


/**
 * des: 知识点2-循环数组队列
 * 知识点3-多了2个属性： front 和  tail,使时间复杂度从O(n)变成O(1) .而数组队列的实现方式每次出队，都要遍历整个数组，移动他的下标
 * 知识点4-循环队列比数组队列的性能能高出100倍
 * created by miapoeng on 2019/8/12 20:17
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int size;
    private int front;
    private int tail;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];//知识点： 因为front==tail表示队列为空，当front+1 = tail的时候，表示队列已满， 所以多加1个容量（为的能放的下用户定义时的那个数）
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void inQueue(E e) {
        if (isFull()) {
            resize(((data.length - 1) * 2) + 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 重置大小
     * @param newCapacity
     */
    public void resize (int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        int index = 0;
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            newData[index] = data[i];
            index++;
        }
        front = 0;
        tail = index;
        data = newData;
    }

    /**
     * 队列是否已满
     *
     * @return
     */
    private boolean isFull() {
        if ((tail + 1) % data.length == front) {
            return true;
        }
        return false;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E outQueue() {
        if (size == 0) {
            throw new IllegalArgumentException("size = 0");
        }
        if (size == capacity() / 4 && capacity() / 2 != 0) {
            resize(capacity() / 2 + 1);
        }
        E fd = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return fd;
    }

    @Override
    public E getFront() {
        if (size == 0) {
            throw new IllegalArgumentException("size = 0");
        }
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    // 知识点6-因为初始化的时候，构造方法里多初始化了1个，所以这里要减去1个
    public int capacity () {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
//        testLoop();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 5; i++) {
            loopQueue.inQueue(i);
        }
        System.out.println(loopQueue);
        for (int i = 0; i < 10; i++) {
            loopQueue.inQueue(i);
        }
        System.out.println(loopQueue);
        for (int i = 0; i < 13; i++) {
            loopQueue.outQueue();
        }
        System.out.println(loopQueue);
    }

    /**
     * 通过取余的方式，循环几遍
     * 知识点1-使用取余，使数组转起来（循环起来）
     */
    public static void testLoop() {
        int[] ints = {1, 2, 3, 4, 5};
        for (int i = 0; i < ints.length * 2; i++) {
            System.out.println(ints[i % ints.length]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("capacity=").append(capacity()).append("  ");
        sb.append("size=").append(size()).append("\t");
        for (int i = front; i != tail; i = (i + 1) % data.length) { //知识点5-通过不等于来判断终止条件
            sb.append(data[i]);
            if ((i + 1) % data.length != tail ) { //知识点4, 通过 != tail 来判断是不是最后一个元素
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
