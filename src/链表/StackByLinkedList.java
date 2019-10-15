package 链表;


import 栈.StackInter;


/**
 * des: 用链表来实现栈
 * created by miapoeng on 2019/8/15 17:22
 */
public class StackByLinkedList<E> implements StackInter<E> {

    private MyLinkedList<E> linkedList;

    public StackByLinkedList () {
        linkedList = new MyLinkedList<>();
    }

    /**
     * 入栈-向链表的头部放入元素
     * 知识点：由于操作队列的最后一个元素要遍历整个链表，时间复杂度是O(n),而操作头部，则是O(1),所以操作头
     * @param e
     */
    @Override
    public void push(E e) {
        linkedList.insertFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.get(0);
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size()).append("\n");
        for (int i = 0; i < size(); i++) {
            E t = linkedList.get(i);
            sb.append(t);
            if (i < size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StackByLinkedList<Integer> myStackByArray = new StackByLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            myStackByArray.push(i);
        }
        System.out.println(myStackByArray);
        System.out.println(myStackByArray.peek());
        System.out.println(myStackByArray.pop());
        System.out.println(myStackByArray);
    }
}
