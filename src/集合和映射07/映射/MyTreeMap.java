package 集合和映射07.映射;

/**
 * des: 依靠Tree结构实现的Map
 * created by miapoeng on 2019/8/23 10:02
 */
public class MyTreeMap<K extends Comparable, V> implements Map<K, V>{

    /**
     * 内部私有类，只不过封装了K和V
     */
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        public Node (K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;

    public MyTreeMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    //通过递归，把元素放到指定层次的指定位置
    private Node add (Node node, K key, V value) {
        //先判断终止条件
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        //递归找自己
        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);//之所以这里重新赋值，是因为不是直接改变的内存。 所以要层层赋值（=）， 再返回回去。
        } else if (key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }
        return node;
    }

    /**
     * 帮助类-获取某个节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null){
            return null;
        }
        if (node.key.equals(key)) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public V remove(K key) {
        if (contains(key)) {
            Node node = getNode(root, key);
            deleteAnyElement(key);
            return node == null ? null : node.value;
        }
        return null;
    }

    private void deleteAnyElement (K key) {
        //先判断是否存在，存在才删除
        if (contains(key)) {
            root = deleteAnyElement(root, key);
        }
    }
    private Node deleteAnyElement (Node node, K key) {
        if (key.compareTo(node.key) == 0) {
            if (node.left == null) {
                Node rightTemp = node.right;
                node.right = null;
                size--;
                return rightTemp;
            }
            if (node.right == null) {
                Node leftTemp = node.left;
                node.left = null;
                size--;
                return leftTemp;
            }
            //找到比他大的最接近他的元素
            Node houji = minnum(node.right);
            //把删除上面元素之后的树作为他的右子树
            houji.right = realRemoveMin(node.right);
            houji.left = node.left;
            node.right = node.left = null;
            return houji;
        }else if (key.compareTo(node.key) > 0) {
            node.right = deleteAnyElement(node.right, key);
            return node;
        } else {
            node.left = deleteAnyElement(node.left, key);
            return node;
        }
    }

    private Node minnum(Node node){
        if (node.left == null) {
            return node;
        }
        return minnum(node.left);
    }

    private Node realRemoveMin(Node node){
        //先处理底部情况
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        ///很重要
        ///***一般上边代码块跟下边代码块组合就是整合函数的语义了***///
        ////后来重新理解了一下递归的宏观语义，这里的宏观语义是给左子树重新赋值（看1层就行）

        node.left = realRemoveMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(root, key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
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
        if (root != null) {
            sb.append("key=").append(root.key).append(", value=").append(root.value).append(",");
        }
        Node node = root.left;
        while(node != null) {
            sb.append("key=").append(node.key).append(", value=").append(node.value).append(",");
            node = node.left;
        }
        node = root.right;
        while(node != null) {
            sb.append("key=").append(node.key).append(", value=").append(node.value).append(",");
            node = node.right;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyTreeMap<Integer, Integer> myLinkedMap = new MyTreeMap<>();
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
