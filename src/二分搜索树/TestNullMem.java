package 二分搜索树;

/**
 * des:
 * created by miapoeng on 2019/7/25 21:10
 */
public class TestNullMem {
    public static void main(String[] args) {
        Student student = new Student(1, "hhhh");
        Student stu2 = student;//stu2指向了student这块内存
        student = null; //*******设置成null,只是不再指向那块内存，但是内存还在那
        System.out.println(stu2.getName());
    }
}
