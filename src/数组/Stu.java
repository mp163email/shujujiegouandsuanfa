package 数组;

/**
 * des:
 * created by miapoeng on 2019/8/9 17:37
 */
public class Stu {

    private String name;
    private int age;

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
