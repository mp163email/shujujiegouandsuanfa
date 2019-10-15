package 堆和优先队列;

import 队列.Queue;

/**
 * des: 使用自己实现的堆来实现优先队列
 * 知识点：优先队列，永远关注的是取出来的那一个。而并不是默认已经按照大小排好序了。取出来的那一个是最优先的
 * 知识点：放的时候就是按照堆的性质，把优先级最高的元素放到第一个位置
 * 知识点：其他都是按照堆的性质，组织好数据
 * created by miapoeng on 2019/8/28 17:18
 */
public class MyPriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap = null;

    public MyPriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void inQueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E outQueue() {
        return maxHeap.expactMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
