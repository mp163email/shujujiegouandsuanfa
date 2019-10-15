package 链表;

/**
 * des: 自定义链表-带虚拟头结点的
 * 知识点：因为在处理头结点的增加和删除的时候，和处理其他位置的增加和删除代码跟逻辑不一样，没能统一
 * 知识点：矛盾点在于处理其他位置的时候，要找到这个位置的前一个节点，但是头结点没有前一个节点，他自己就是头
 * 知识点：所以把head这个属性去掉，在head的前面新加了一个虚拟的头结点，叫dummyHead的属性，head就是dummyHead的前一个节点
 * created by miapoeng on 2019/8/15 10:19
 */
public class MyLinkedListByDummyHead<E> {

    /**
     * 知识点-私有的内部类有更好的封装性
     *
     * @param <E>
     */
    private class Node<E> {
        E e;
        Node next;

        public Node() {
            e = null;
            next = null;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node<E> dummyHead;//知识点-设置了一个虚拟的头结点
    private int size;

    public MyLinkedListByDummyHead() {
        dummyHead = new Node<>();//虚拟的头结点必须是一个new好的Node, 不然没办法访问他的next. new的时候构造方法没有参数，所以next=null, 他的next就是head, 所以head=null这时候也是合理的
        size = 0;
    }

    /**
     * 增-将元素插入到链表头部
     */
    public void insertFirst(E e) {
        insert(0, e);
    }

    /**
     * 向尾部插入元素
     * @param e
     */
    public void insertLast (E e) {
        insert(size, e);
    }

    /**
     * 将元素插入到第几个索引的位置
     *
     * @param index
     * @param e
     */
    public void insert(int index, E e) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        if (index > size) {
            throw new IllegalArgumentException("outofbounds index > size");
        }

        Node<E> pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node<E> node = new Node(e);
        node.next = pre.next;//知识点：如果index = 0, pre = dummyHead, 如果dummyHead这个节点没有new的话，这里的pre.next会报错
        pre.next = node;
        size++;
    }

    /**
     * 删除第一个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除某个下标的元素
     *
     * @return
     */
    public E remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        if (index >= size) {
            throw new IllegalArgumentException("outofbounds index > size");
        }

        Node<E> preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node<E> delNode = preNode.next;
        E retE = delNode.e;
        preNode.next = delNode.next;
        delNode = null;
        size--;
        return retE;
    }

    /**
     * 修改某个下标的元素
     *
     * @param index
     * @param e
     */
    public void update(int index, E e) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        if (index >= size) {
            throw new IllegalArgumentException("outofbounds index >= size");
        }
        Node<E> updateNode = dummyHead.next;//知识点：dummyHead.next就是head
        for (int i = 0; i < index; i++) {
            updateNode = updateNode.next;
        }
        updateNode.e = e;
    }

    public E get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        if (index >= size) {
            throw new IllegalArgumentException("outofbounds index >= size");
        }
        Node<E> selectNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            selectNode = selectNode.next;
        }
        if (selectNode == null) {
            return null;
        } else {
            return selectNode.e;
        }
    }

    /**
     * 是否包含某个元素
     * @param e
     * @return
     */
    public boolean contains (E e) {
        Node<E> node = dummyHead.next;
        while (node != null) {
            if (node.e.equals(e)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size).append("\t");
        Node<E> node = dummyHead.next;
        while (node != null) {
            sb.append(node.e);
            if (node.next != null) {
                sb.append(",");
            }
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedListByDummyHead<Integer> myLinkedList = new MyLinkedListByDummyHead<>();
        for (int i = 0; i < 5; i++) {
            myLinkedList.insertLast(i);
        }
        System.out.println(myLinkedList);
        myLinkedList.removeFirst();
        System.out.println(myLinkedList);
        myLinkedList.insert(1, 100);
        System.out.println(myLinkedList);
        myLinkedList.update(1, 1000);
        System.out.println(myLinkedList);
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.contains(1));
        System.out.println(myLinkedList.contains(11));
    }

}
