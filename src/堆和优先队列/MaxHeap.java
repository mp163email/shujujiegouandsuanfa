package 堆和优先队列;

import 数组.MyArray;

import java.util.Random;

/**
 *
 * des: 用自己自定义的动态数组，实现堆（最大堆）
 * created by miapoeng on 2019/8/26 17:02
 */
public class MaxHeap <E extends Comparable<E>> {

    MyArray<E> data;

    public MaxHeap (int capacity) {
        data = new MyArray<>(capacity);
    }

    public MaxHeap () {
        data = new MyArray<>();
    }

    /**
     * 给定一个数组，构建一个堆
     * 知识点：heapity的操作，将一个数组，通过调换位置，改变成一个堆
     * 知识点：思想是：先找到最后一个子节点的父亲节点(非叶子节点)的索引。然后循环的减减这个数大于等于0的条件下.在每次循环中，siftdown这个元素即可。
     * @param arrays
     */
    public MaxHeap (E[] arrays) {
        data = new MyArray<>(arrays);
        for (int i = parent(arrays.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e) {
        data.addLast(e);//知识点：先向结尾插入一个元素
        siftUp(data.size() - 1);
    }

    /**
     * 取出堆中最大的元素
     * @return
     */
    public E expactMax () {
        E max = findMax();
        data.swap(0, size() - 1);//知识点： 思路是：先将最大值和最后一个值调换位置
        data.removeLast();//知识点：再讲最受的元素删除
        siftDown(0);//知识点：最后将元素从0位置下沉，下沉的过程是跟他的左右两个孩子的最大的那个作比较。如果比最大的小，就换位置
        return max;
    }

    /**
     * 元素下沉操作
     * 知识点：父亲元素和左右孩子元素中最大的那个做比较，如果比最大的那个小于或者等于，就跟最大的那个交换位置。直到比最大的那个大或者到树的末尾了
     */
    private void siftDown (int index) {
        while (leftChild(index) < size()) {
            //找到左右孩子的最大值
            int leftIndex = leftChild(index);
            int maxIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            //知识点：有右孩子节点，并且右孩子比左孩子的值大
            if (rightIndex < size() && data.get(rightIndex).compareTo(data.get(leftIndex)) > 0) {
                maxIndex = rightIndex;
            }
            //如果index小于等于最大值，则交换两者的值
            if (data.get(index).compareTo(data.get(maxIndex)) > 0) {
                break; //知识点：结束循环
            }
            data.swap(index, maxIndex);
            index = maxIndex;
        }
    }

    /**
     * 找到最大值
     * @return
     */
    public E findMax () {
        if (size() <= 0) {
            throw new IllegalArgumentException("index = 0");
        }
        return data.get(0);
    }

    /**
     * 上浮
     * 知识点：先在最后插入节点，然后不断的跟他的父亲索引上的节点比较，如果比父亲索引的值大，就交换位置，一直到头或者比父亲索引的值小
     * @param index
     */
    private void siftUp (int index) {
        //知识点： 如果不是顶点坐标0，并且父亲索引的值比自己小就上浮
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap (parent(index), index);
            index = parent(index);
        }
    }

    /**
     * 辅助函数-计算某个索引的父亲节点的索引
     * 知识点：因为堆是完全的二叉树，所以可以用数组来表示他
     * 知识点：数组从0开始来存储堆的元素，用公式来表示某个索引的父亲节点索引，左孩子节点索引和右孩子节点索引
     * @param index
     * @return
     */
    private int parent (int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("index=0");
        }
        return (index - 1) / 2;
    }

    private int leftChild (int index) {
        return index * 2 + 1;
    }

    private int rightChild (int index) {
        return index * 2 + 2;
    }

    /**
     * 知识点：取出堆中最大元素，并且替换成元素e
     * 知识点：如果先拿出最大值，再add, 这样会有2次logn。直接替换只有1次logn，更高效
     * @param e
     * @return
     */
    public E replace (E e) {
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }


    public static void main(String[] args) {
//        int num = 100 * 10000;
//        Integer[] intss = new Integer[num];
//        Random random = new Random();
//        for (int i = 0; i < num; i++) {
//            int rd = random.nextInt(Integer.MAX_VALUE);
//            intss[i] = rd;
//        }
//
//        MaxHeap<Integer> maxHeap = new MaxHeap<>(intss);//使用heapify，将传入的数组，直接构建成堆
//        System.out.println(maxHeap.findMax());
//
//        Integer[] ints = new Integer[maxHeap.size()];
//        for (int i = 0; i < num; i++) {
//            int maxValue = maxHeap.expactMax();
//            ints[i] = maxValue;
//        }
//        for (int i = 1; i < num; i++) {
//            if (ints[i - 1] < ints[i]) {
//                throw new IllegalArgumentException("这个堆有问题");
//            }
//        }
//        System.out.println("执行完毕, 自己构建的堆，没有问题。");

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.add(4);
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(1);
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.expactMax());
        }
    }

}
