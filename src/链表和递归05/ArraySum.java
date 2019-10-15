package 链表和递归05;

/**
 * des: 使用递归数组求和
 * created by miapoeng on 2019/8/16 10:38
 */
public class ArraySum {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(getArraySum(a));
    }


    public static int getArraySum (int [] arrays) {
        return sum(0, arrays);
    }

    public static int sum (int index, int [] arrays) {
        if (index == arrays.length) {
            return 0;
        }
        return arrays[index] + sum(index + 1, arrays);
    }
}
