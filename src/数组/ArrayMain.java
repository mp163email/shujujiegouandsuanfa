package 数组;

/**
 * 动态数组
 * des: 有几个知识点，都标注了
 * created by miapoeng on 2019/8/9 10:29
 */
public class ArrayMain {
    public static void main(String[] args) {

//        Stu stu1 = new Stu("aa1", 1);
//        Stu stu2 = new Stu("aa1", 1);
//        if (stu1.equals(stu2)) {//知识点4: stu1和stu2用equals比较，不相等
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }


        MyArray<Integer> myArray = new MyArray<>();
        for (int i = 1; i <= 10; i++) {
            myArray.addLast(i);
        }
        System.out.println(myArray);
        myArray.add(1, 10);
        System.out.println(myArray);
    }
}
