package 编码常用;

import java.util.*;

/**
 * des: 数组转List
 * created by miapoeng on 2019/7/11 9:58
 */
public class 数组转List {
    public static void main(String[] args) {
        method2();

    }

    public static void method2 () {
        // 知识点1- ArrayList是有序的， 跟LinkedList一样。 只不过内部结构实现不一样，一个是数组，一个是链表
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(0, 100);
        for (int i : list) {
            System.out.println(i);
        }
        System.out.println(list.get(0));//知识点2-ArrayList可以通过索引来访问
        System.out.println("=======================");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(0, 100);//知识点3-LinkedList可以按索引插入数据
        System.out.println(linkedList.get(0));//知识点4-LinkedList能通过索引来访问
    }


    public static void method1 () {
        Integer[] arrays = {1, 2, 3, 4};//知识点1：需要注意的是，这里的类型是Integer, 大写的
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arrays));//转成可以add的ArrayList
        //知识点2：迭代器删除元素
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (x == 3) {
                iterator.remove();
            }
        }
        System.out.println(arrayList);

        //知识点3：判断数组中是否包含某个元素
        System.out.println(Arrays.asList(1, 2, 3, 4).contains(4));
    }
}
