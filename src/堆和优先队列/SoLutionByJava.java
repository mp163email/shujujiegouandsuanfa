package 堆和优先队列;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 使用Java自带的优先队列来实现
 * 前K个高频元素
 * des: 给定一个非空的数组，返回其中出现频率前k高的元素
 * 比如：[1, 1, 1, 2, 2, 3], k=2 , 返回{1, 2}
 * 知识点：这里巧妙的构思是：每次都将最小的淘汰掉，剩下的就是最大的。优先队列恰好每次都是拿出最优先的（大或者小）
 * 知识点：类似于末尾淘汰机制， 把弱鸡都淘汰掉，剩下的就都是强的
 * created by miapoeng on 2019/8/28 17:52
 */
public class SoLutionByJava {

    private static class Freq implements Comparable<Freq> {
        int yuansu;
        int pinci;
        public Freq(int yuansu, int pinci) {
            this.yuansu = yuansu;
            this.pinci = pinci;
        }

        /**
         * 知识点：总是把最小的删除，剩下的就是最大的。这里构建的是最小堆
         * @param o
         * @return
         */
        @Override
        public int compareTo(Freq o) {
            if (this.pinci > o.pinci) {
                return -1;//知识点：总是把最小的删除，剩下的就是最大的。这里构建的是最小堆
            } else if (this.pinci < o.pinci) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "{元素=" + yuansu + ", 频次=" + pinci + "}";
        }
    }


    public static void main(String[] args) {
        int[] test = {1, 1, 1, 2, 2, 3};
//        int[] test = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
//        int[] test = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        int k = 2;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < test.length; i++) {
            if (treeMap.containsKey(test[i])) {
                treeMap.put(test[i], treeMap.get(test[i]) + 1);
            } else {
                treeMap.put(test[i], 1);
            }
        }
        PriorityQueue<Freq> myPriorityQueue = new PriorityQueue<Freq>();
        for (int key : treeMap.keySet()) {
            if (myPriorityQueue.size() < k) {
                myPriorityQueue.add(new Freq(key, treeMap.get(key)));
            } else {
                if (treeMap.get(key) > myPriorityQueue.peek().pinci) {//知识点：总是把最小的删除，剩下的就是最大的。这里构建的是最小堆
                    myPriorityQueue.poll();//知识点：总是把最小的删除，剩下的就是最大的。这里构建的是最小堆
                    myPriorityQueue.add(new Freq(key, treeMap.get(key)));
                }
            }
        }

        TreeSet<Freq> linkedList = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            linkedList.add(myPriorityQueue.poll());
        }
        System.out.println(linkedList);

    }
}
