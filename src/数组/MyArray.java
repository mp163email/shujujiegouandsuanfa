package 数组;

/**
 * des: 自定义动态数组(连续不间断的)，支持泛型， 支持扩容
 * created by miapoeng on 2019/8/9 15:51
 */
public class MyArray<T> { //知识点5-泛型的应用 <T>

    private int size;

    private T[] data;

    public MyArray() {
        data = (T[]) new Object[10];
    }

    public MyArray(int capacity) {
        data = (T[]) new Object[capacity];//知识点1：new一个泛型数组
    }

    public MyArray(T[] arrays) {
        data = (T[]) new Object[arrays.length];
        for (int i = 0; i <arrays.length; i++) {
            data[i] = arrays[i];
        }
        size = arrays.length;
    }

    public void addLast(T t) {
        add(size, t);
    }

    public void add(int index, T t) {
        if (size >= data.length) {
            resize(data.length * 2);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add index 不合法");
        }
        for (int i = size; i > index; i--) {//知识点3：用倒叙的方式(1-使用倒叙 2-大于index)，实现向右错位
            data[i] = data[i - 1];
        }
        data[index] = t;
        size++;
    }

    public void del(int index) {
        if (size == 0) {
            throw new IllegalArgumentException("del index 空数组");
        }
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        for (int i = index; i < size - 1; i++) {//知识点4：1-正序方式 2- < size - 1
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    public void resize(int newCapacity) {//知识点5  扩容， new一个新数组，把就数组拷贝到新数组上， 改一下data的指针
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            T d = data[i];
            newData[i] = d;
        }
        data = newData;
    }

    public T removeFirst() {
        T delData = data[0];
        del(0);
        return delData;
    }

    public T removeLast() {
        if (size == 0) {
            throw new IllegalArgumentException("空");
        }
        T delData = data[size - 1];
        del(size - 1);
        return delData;
    }

    /**
     * 交换两个元素的值
     * @param index1
     * @param index2
     */
    public void swap (int index1, int index2) {
        T t = data[index1];
        data[index1] = data[index2];
        data[index2] = t;

    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get的参数不合法");
        }
        return data[index];
    }

    public T getLast() {
        if (size == 0) {
            throw new IllegalArgumentException("空");
        }
        return data[size - 1];
    }

    public T getFirst() {
        if (size == 0) {
            throw new IllegalArgumentException("空");
        }
        return data[0];
    }

    /**
     * 设置某个元素的值
     */
    public void set (int index, T t) {
        if (index >= size) {
            throw new IllegalArgumentException("index 不合法");
        }
        data[index] = t;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
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
