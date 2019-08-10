package 数组;

/**
 * des: 自定义数组(连续不间断的)，支持泛型
 * 简单实现一些功能
 * created by miapoeng on 2019/8/9 15:51
 */
public class MyArray<T> { //知识点5-泛型的应用 <T>

    private int size;

    private T [] data;

    public MyArray() {
        data = (T[])new Object[10];
    }

    public MyArray(int capacity) {
        data = (T[])new Object[capacity];//知识点1：new一个泛型数组
    }

    public void addLast (T t) {
        data[size] = t;
        size ++;
    }

    public void add (int index, T t) {
        if (size >= data.length) {
            kuoRong(data.length * 2);
        }
        if (index < 0 || index > size ) {
            throw new IllegalArgumentException("add index 不合法");
        }
        for (int i = size; i > index; i--) {//知识点3：用倒叙的方式(1-使用倒叙 2-大于index)，实现向右错位
            data[i] = data[i - 1];
        }
        data[index] = t;
        size++;
    }

    public void del (int index) {
        if (size == 0) {
            throw new IllegalArgumentException("del index 空数组");
        }
        for (int i = index; i < size - 1; i++) {//知识点4：1-正序方式 2- < size - 1
            data[i] = data[i + 1];
        }
        size--;
    }

    public void kuoRong (int newCapacity) {//知识点5  扩容， new一个新数组，把就数组拷贝到新数组上， 改一下data的指针
        if (size >= data.length) {
            T[] newData = (T[])new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                T d = data[i];
                newData[i] = d;
            }
            data = newData;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", length=").append(data.length).append("\n");
        sb.append("[");
        for (int i = 0; i < size; i++) {
            T t = data[i];
            sb.append(t);
            if (i != size - 1) {
                sb.append(",");//知识点2：最后一个不加符号，其他都加
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
