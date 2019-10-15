package 队列;

import 链表.QueueByLinkedList;

/**
 * des: 通过比较：循环数组比普通数组快了几百倍！
 * 因为循环数组通过front, tail两个变量，将时间复杂度由O(n)转成了O(1) -- 在出队的时候（普通数组出队的时候，所有的索引都要移动一下，而循环数组不需要）
 * created by miapoeng on 2019/8/13 16:18
 */
public class CompareMain {
    public static void main(String[] args) {
//        compareXingNeng(new ArrayQueue());
//        System.out.println("==========");
        compareXingNeng(new LoopQueue());
        System.out.println("==========");
        compareXingNeng(new QueueByLinkedList());
    }

    public static void compareXingNeng (Queue queue) {
        long start = System.currentTimeMillis();
        int times = 10 * 10000;
        //10万次入队
        for (int i = 0; i < times; i++) {
            queue.inQueue(i);
        }
        //10万次出队
        for (int i = 0; i < times - 1; i++) {
            queue.outQueue();
        }
        long end = System.currentTimeMillis();
        System.out.println(queue);
        System.out.println("耗时: " + (end - start) / 1000.0);//知识点-通过给1000.0能自动转成double, 能看到小数点后的数，比如不足1秒，能看到是0.几几秒
    }
}
