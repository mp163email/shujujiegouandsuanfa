package 链表;

/**
 * des: 自定义链表
 * created by miapoeng on 2019/8/15 10:19
 */
public class MyLinkedList<E> {

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

    private Node<E> head;//知识点-一定要有一个head或者root, 不然怎么知道从哪个地方开始访问里面的数据
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 增-将元素插入到链表头部
     */
    public void insertFirst(E e) {
//        这3句话相当于最下面的1句话  知识点：对指针的理解。 a = b; a的指针指向b背后的内存块
//        Node node = new Node(e);//new创建了一个内存块， node的指针指向着这个内存块
//        node.next = head;  //将node.next的指针指向head对应的内存块
//        head = node;//将head的指针node对应的内存块。 这里head的改变不会影响上面的变化， 仅仅是指针的变化

        if (size == 0) {
            head = new Node(e);
        } else {
            head = new Node(e, head);
        }
        size++;
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
        if (index == 0) {
            insertFirst(e);
        } else {
            Node<E> pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            Node<E> node = new Node(e);
            node.next = pre.next;
            pre.next = node;
            size++;
        }
    }

    /**
     * 删除第一个元素
     */
    public E removeFirst() {
        if (size == 0) {
            throw new IllegalArgumentException("size == 0");
        }
        E retE = head.e;
        Node<E> next = head.next;
        if (next != null) {
            head = next;
        } else {
            head = null;
        }
        size--;
        return retE;
    }

    /**
     * 删除某个元素
     * @param e
     */
    public void removeElement (E e) {
        if (head.e.equals(e)) {
            Node<E> del = head;
            head = del.next;
            del.next = null;
            size--;
        } else {
            Node<E> pre = head;
            while (pre.next != null) {
                if (pre.next.e.equals(e)) {
                    break;
                }
                pre = pre.next;
            }
            Node<E> del = pre.next;
            pre.next = del.next;
            del.next = null;
            size--;
        }
    }

    /**
     * 删除某个下标的元素
     * 删除不是头的时候，会遍历，时间复杂度为O(n)
     * @return
     */
    public E remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        if (index >= size) {
            throw new IllegalArgumentException("outofbounds index > size");
        }
        if (index == 0) {
            return removeFirst();
        } else {
            Node<E> preNode = head;
            for (int i = 0; i < index - 1; i++) {
                preNode = preNode.next;
            }
            Node<E> delNode = preNode.next;
            E retE = delNode.e;
            preNode.next = delNode.next;
            delNode = null;
            size--;
            return retE;
        }
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
        Node<E> updateNode = head;
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
        Node<E> selectNode = head;
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
        Node<E> node = head;
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
        Node<E> node = head;
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
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
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
        System.out.println("==========");
        myLinkedList.removeElement(1);
        myLinkedList.removeElement(4);
        System.out.println(myLinkedList);
    }

}
