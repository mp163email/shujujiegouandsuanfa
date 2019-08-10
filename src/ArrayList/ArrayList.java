package ArrayList;

import java.util.Arrays;

/**
 * des:
 * created by miapoeng on 2019/1/15 10:55
 */
public class ArrayList {

    /**
     * ArrayList的初始数组是10
     * 扩容的时候是原始值+ 原始值/2(>>1),也就是向右移一位， 也就是1.5倍扩容
     * 达到数组长度的时候才会扩容
     * 用到了一个比较重要的方法Arrays.copyof
     */

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        System.out.println(ints.length);
        System.out.println(ints[2]);

        //将原数组扩容到新的大小，下标和对应的值不变
        int[] ints1 = Arrays.copyOf(ints, ints.length * 2);
        System.out.println(ints1.length);
        System.out.println(ints1[2]);
        System.out.println(ints1[3]);
    }

}
