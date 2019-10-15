package 集合和映射07.集合;

import java.util.TreeSet;

/**
 * des: 知识点：所有Tree开头的都是通过树结构来实现的，而且都是排好序的
 * created by miapoeng on 2019/8/19 19:55
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(1);
        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
    }
}
