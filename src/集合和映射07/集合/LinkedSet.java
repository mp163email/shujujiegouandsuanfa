package 集合和映射07.集合;

import 链表.MyLinkedList;

/**
 * des: 基于链表实现集合
 * created by miapoeng on 2019/8/22 20:35
 */
public class LinkedSet<E> implements Set<E> {

    private MyLinkedList<E> myLinkedList = null;

    public LinkedSet () {
        myLinkedList = new MyLinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!myLinkedList.contains(e)) {
            myLinkedList.insertFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        myLinkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return myLinkedList.contains(e);
    }

    @Override
    public int size() {
        return myLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 统计某本书，不重复的单词
     * @param args
     */
    public static void main(String[] args) {
        LinkedSet<Character> linkedSet = new LinkedSet<>();
        String str = "我们是中国人，我很自豪";
        for (int i = 0; i < str.length(); i++) {
            char danCi = str.charAt(i);
            linkedSet.add(danCi);
        }
        System.out.println("总单词个数=" + str.length() + ", 不重复的单词个数=" + linkedSet.size());
    }
}
