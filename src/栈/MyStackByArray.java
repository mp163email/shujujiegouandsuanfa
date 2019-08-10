package 栈;

import 数组.MyArray;

/**
 * des:
 * created by miapoeng on 2019/8/10 17:33
 */
public class MyStackByArray<T> implements StackInter<T> {

    MyArray<T> myArray;

    public MyStackByArray(int capacity) {
        myArray = new MyArray<>(capacity);
    }

    public MyStackByArray () {
        myArray = new MyArray<>();
    }

    @Override
    public void push(T t) {
        myArray.addLast(t);
    }

    @Override
    public T pop() {
        return myArray.removeLast();
    }

    @Override
    public T peek() {
        return myArray.getLast();
    }

    @Override
    public int size() {
        return myArray.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size()).append("\n");
        for (int i = 0; i < myArray.size(); i++) {
            T t = myArray.get(i);
            sb.append(t);
            if (i < size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
