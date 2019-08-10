package 栈;

/**
 * des: 栈：一种线性结构， 属于数组的子集（限定数组）
 * 适用场景：1-文本的撤销机制  2-程序调用（一个方法内调另一个方法，另一个方法调另一个方法），栈记录了中断的点（代码行数） 3-括号匹配
 * created by miapoeng on 2019/8/10 17:28
 */
public class StackMain {
    public static void main(String[] args) {
        MyStackByArray<Integer> myStackByArray = new MyStackByArray<>();
        for (int i = 1; i <= 5; i++) {
            myStackByArray.push(i);
        }
        System.out.println(myStackByArray);
        System.out.println(myStackByArray.peek());
        System.out.println(myStackByArray.pop());
        System.out.println(myStackByArray);
    }

}
