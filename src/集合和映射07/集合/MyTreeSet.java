package 集合和映射07.集合;

import 二分搜索树06.BST;

/**
 * des: 使用二分搜索树实现集合
 * 上面的二分搜索树的实现，就是没有理会重复数据的，所以能拿来直接用
 * created by miapoeng on 2019/8/19 20:50
 */
public class MyTreeSet<E extends Comparable<E>> implements Set<E>{

    private BST<E> bst;

    public MyTreeSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.deleteAnyElement(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int size() {
        return bst.size();
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
        MyTreeSet<Character> myTreeSet = new MyTreeSet<>();
        String str = "我们是中国人，我很自豪";
        for (int i = 0; i < str.length(); i++) {
            char danCi = str.charAt(i);
            myTreeSet.add(danCi);
        }
        System.out.println("总单词个数=" + str.length() + ", 不重复的单词个数=" + myTreeSet.size());
    }
}
