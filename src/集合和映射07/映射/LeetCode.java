package 集合和映射07.映射;

import 集合和映射07.集合.MyTreeSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * des:
 * created by miapoeng on 2019/8/23 16:55
 */
public class LeetCode {

    static int[] a1 = {1, 2, 2, 3};
    static int[] a2 = {2, 2, 5};

    /**
     * 结果要求是2， 求交集
     * 使用集合解决， 去下重
     */
    public static void test1() {
        MyTreeSet<Integer> myTreeSet = new MyTreeSet<>();
        for (int i = 0; i < a1.length; i++) {
            int v = a1[i];
            myTreeSet.add(v);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a2.length; i++) {
            int v = a2[i];
            if (myTreeSet.contains(v) && !result.contains(v)) {
                result.add(v);
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }

    /**
     * 结果要求是2, 2
     * 使用映射解决，记录每个数出现的次数
     */
    public static void test2() {
        MyTreeMap<Integer, Integer> myTreeMap = new MyTreeMap<>();
        for (int i = 0; i < a1.length; i++) {
            int v = a1[i];
            if (myTreeMap.contains(v)) {
                myTreeMap.set(v, myTreeMap.get(v) + 1);
            } else {
                myTreeMap.add(v, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a2.length; i++) {
            int v = a2[i];
            if (myTreeMap.contains(v)) {
                result.add(v);
                int times = myTreeMap.get(v);
                if (times - 1 <= 0) {
                    myTreeMap.remove(v);
                } else {
                    myTreeMap.set(v, times - 1);
                }
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
