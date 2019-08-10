package 编码常用;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * des: 数组转List
 * created by miapoeng on 2019/7/11 9:58
 */
public class 数组转List {
    public static void main(String[] args) {
        Integer[] arrays = {1, 2, 3, 4};//需要注意的是，这里的类型是Integer, 大写的
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arrays));//转成可以add的ArrayList
        //迭代器删除元素
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (x == 3) {
                iterator.remove();
            }
        }
        System.out.println(arrayList);

        //判断数组中是否包含某个元素
        System.out.println(Arrays.asList(1, 2, 3, 4).contains(4));

    }
}
