package 集合和映射07.映射;

/**
 * des: 使用链表实现映射
 * created by miapoeng on 2019/8/23 11:46
 */
public class MyLinkedMap<K, V> implements Map<K, V>{

    /**
     * 知识点-私有的内部类有更好的封装性
     */
    private class Node<K, V> {
        K key;
        V value;
        Node next;

        public Node() {
            key = null;
            value = null;
            next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value,  Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K, V> dummyHead;//知识点-设置了一个虚拟的头结点;
    private int size;

    public MyLinkedMap() {
        dummyHead = new Node<>();
        size = 0;
    }

    /**
     * 辅助类 - 获得某个key的节点
     * @param key
     * @return
     */
    private Node getNode (K key) {
        Node node = dummyHead.next;
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return node;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node<K, V> node = dummyHead;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                break;
            }
            node = node.next;
        }
        if (node.next != null) {
            Node<K, V> delNode = node.next;
            node.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<K, V> node = dummyHead;
        while(node != null) {
            sb.append("key=").append(node.key).append(", value=").append(node.value).append(",");
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedMap<Integer, Integer> myLinkedMap = new MyLinkedMap<>();
        myLinkedMap.add(1, 10);
        myLinkedMap.add(2, 20);
        myLinkedMap.add(3, 30);
        System.out.println(myLinkedMap.size);
        System.out.println(myLinkedMap.get(2));
        System.out.println(myLinkedMap.remove(3));
        System.out.println(myLinkedMap.size);
        System.out.println(myLinkedMap);
    }
}
