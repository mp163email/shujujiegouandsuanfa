package HashMap;

/**
 * des: 自定义HashMap测试
 * 知识点：HashMap是数组加链表   数组指把Key的hashcode % 16取余，组装成Entity放到这个数组的索引下； 当这个索引如果有entity了，就放到这个entity的next里
 * created by miapoeng on 2019/1/15 10:02
 */
public class HashMapTest {

    public static void printHashCode () {
        java.util.HashMap<String, String> hashMap = new java.util.HashMap<>();
        hashMap.put("张三", "张三v");
        hashMap.put("李四", "李四v");
        hashMap.put("玉皇大帝", "玉皇大帝v");
        hashMap.put("金吒", "金吒v");
        hashMap.keySet().forEach(x -> System.out.println(x + "---" + x.hashCode() + "---" + x.hashCode() % 15));
    }


    public static void main(String[] args) {
        printHashCode();
        System.out.println("===========================");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("张三", "张三v");
        hashMap.put("李四", "李四v");
        hashMap.put("玉皇大帝", "玉皇大帝v");
        hashMap.put("金吒", "金吒v");

        String value = hashMap.get("李四");
        System.out.println(value);

        String value2 = hashMap.get("张三");
        System.out.println(value2);

        String value3 = hashMap.get("玉皇大帝");
        System.out.println(value3);

        String value4 = hashMap.get("金吒");
        System.out.println(value4);

        String value5 = hashMap.get("aaaaa");
        System.out.println(value5);

    }
}
