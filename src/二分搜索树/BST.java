package 二分搜索树;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 存储的内容支持泛型, E
 * 类定义的时候，可以用<>定义泛型
 * 一个有深度的类，能纵深包含无限数据
 * 一个类除了能横向描述一个事物，还能纵向包含无限数据（比如链表和这里的二分搜索树）
 *
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    /**
     * 私有内部类
     * 类里面包含自己，说明是有深度的
     * 比如这里Node类的定义里面还有Node类型的属性
     * 这种定义的方式，是递归的
     */
    private class Node {
        private E e;
        private Node left;
        private Node right;
        public Node (E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * 根节点
     * 树尖
     */
    private Node root;

    /**
     * 数量
     */
    private int size;

    public BST () {
        this.root = null;
        this.size = 0;
    }

    public int size () {
        return size();
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入元素
     * ************************
     * 递归，如果递归的方法有返回值，那么这个方法肯定会有2个return, 1个是终止条件的return，另一个是方法结尾的return
     * 有返回值的递归，肯定会有元素接着这个方法，一个是外层调用这个递归的地方，另一个是这个递归方法内部有元素接着（有了赋值的功能）
     * 在回路上进行的赋值（保留了当前层次传入参数的信息）
     * 有规则的插入，插入的时候就是按照一定的规则插进去的，大的在右边，小的在左边
     * 凡是递归就是纵深性的，一个猛子，纵深探到底，还要再原路拖着底返回去.
     * 递归是有层次的，而且每个层次传入的参数，都是针对单层的
     */
    public void add (E e) {
        addWhileTure(e);
        //root = add(root, e);
        size ++;
    }

    /**
     * 没有返回值的递归实现add
     */
    private void addVoidDiGui(E e) {
        if (root == null) {
            root = new Node(e);
        } else {
            addVoidDiGuiReal(root, e);
        }
    }
    private void addVoidDiGuiReal(Node node, E e) {
        if (e.compareTo(node.e) > 0) {
            if (node.right == null) {
                node.right = new Node(e);
                return;
            } else {
                addVoidDiGuiReal(node.right, e);
            }
        } else {
            if (node.left == null) {
                node.left = new Node(e);
                return;
            } else {
                addVoidDiGuiReal(node.left, e);
            }
        }
    }

    /**
     * 使用非递归实现树的节点插入-while(true)的方式
     */
    private void addWhileTure (E e) {
        if (root == null) {
            root = new Node(e);
        } else {
            Node node = root;
            while (true) {
                if (e.compareTo(node.e) > 0) {
                    if (node.right == null) {
                        node.right = new Node(e);
                        break;
                    } else {
                        node = node.right;
                    }
                } else {
                    if (node.left == null) {
                        node.left = new Node(e);
                        break;
                    } else {
                        node = node.left;
                    }
                }
            }
        }
    }


    //通过递归，把元素放到指定层次的指定位置
    private Node add (Node node, E e) {
        //先判断终止条件
        if (node == null) {
            return new Node(e);
        }
        //递归找自己
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);//之所以这里重新赋值，是因为不是直接改变的内存。 所以要层层赋值（=）， 再返回回去。
        } else {
            node.left = add(node.left, e);
        }
        return node;
    }

    /**
     * 找到最小元素并返回
     * @return
     */
    public E minnum (){
        Node min = minnum(this.root);
        return min.e;
    }

    /**
     * 递归找到最小的元素
     * @param node
     * @return
     */
    private Node minnum(Node node){
        if (node.left == null) {
            return node;
        }
        return minnum(node.left);
    }

    /**
     * 递归找到最大的元素
     * @return
     */
    public E maxnum (){
        Node min = maxnum(this.root);
        return min.e;
    }

    /**
     * 递归找到最大的元素
     * @param node
     * @return
     */
    private Node maxnum(Node node){
        if (node.right == null) {
            return node;
        }
        return maxnum(node.right);
    }


    /**
     * 删除最小元素
     * @return
     */
    public E removeMinNum () {
        E min = minnum (); //找到最小值并返回（一般删除一个元素，都将删除的这个元素返回）
        this.root = realRemoveMin(this.root);//把整个改变以后的树，返回。 有了root,整个树就有了
        return min;
    }

    /**
     * 删除最小元素-REAL
     * 先灭了你的根（left=null, right=null）, 再覆盖掉你的值（把2变成3）
     */
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

        node.left = realRemoveMin(node.left);
        return node;
    }

    /**
     * 删除最大元素
     * @return
     */
    public E removeMaxNum () {
        E max = maxnum ();
        this.root = realRemoveMax(this.root);
        return max;
    }

    /**
     * 删除最大元素-REAL
     */
    private Node realRemoveMax(Node node){
        //先处理底部情况
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        ///很重要
        ///***一般上边代码块跟下边代码块组合就是整合函数的语义了***///

        node.right = realRemoveMax(node.right);
        return node;
    }

    /**
     * 是否包含
     * @return
     */
    public boolean contains (E e) {
        return contains(root, e);
    }
    private boolean contains (Node node, E e) {
        //先判断终止条件
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) == 0) {
            return true;
        }else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.left, e);
        }
    }

    /**
     * 前序遍历
     * 前序，是指的把打印当前节点的操作放到最前面
     * 先遍历完所有的左子树，再从底部遍历所有的右子树
     */
    public void preOrder () {
        preOrder(root);
    }

    /**
     * 探底后就会返回上一层
     * 啥叫走完了，代码块的代码都执行完了，就叫走完了， 就会返回上一层
     * @param node
     */
    private void preOrder (Node node) {
        //先判断终止条件
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);//先左到底    ****这一行代码返回return
        preOrder(node.right);//到底后，在向右找   ****并且这一行代码也返回return， 这个方法才算走完了， 才会返回上一层
    }

    /**
     * 中序遍历
     * ***中序遍历得出的结果是从小到大排序的
     * ***把输出节点放到遍历完左子树和右子树之间
     * ***先把所有的左子树走完，
     */
    public void inOrder () {
        inOrder(root);
    }
    private void inOrder (Node node) {
        //先判断终止条件
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     * 后续遍历处理一些，先把左右处理完成后再处理自己本身的场景，再处理节点本身的场景。比如释放内存：先将左右节点的内存释放掉在释放本身
     */
    public void lastOrder () {
        lastOrder(root);
    }
    private void lastOrder (Node node) {
        //先判断终止条件
        if (node == null) {
            return;
        }
        lastOrder(node.left);//调用， 这个方法就是调用的方法，上面的终止条件表示这个方法停止。
        lastOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 巧妙的使用栈，来实现二分搜索树的前序遍历
     * 栈在java中的API对象是Stack,支持泛型
     * 栈的特点是先进后出
     * 压栈，可以把一个元素不断往下压，甚至能让他永无出头之日，哈哈（意思是如果有满足条件在就把你往下压，先轮不到你）
     */
    public void preOrderNoDiGui() {
        Stack<Node> stack = new Stack<>();
        stack.push(this.root);//先压入一个元素
        //不为空就一直循环 ***根据栈不为空作为遍历是否完成的条件
        while (!stack.empty()) {
            //先从栈中取出一个
            Node node = stack.pop();
            System.out.println(node.e);
            //然后将取出来的那个Node的右节点放进去， 因为栈是后进先出
            if (node.right != null) {
                stack.push(node.right);
            }
            //再把取出来的那个Node的左节点放进去， 因为栈是后进先出
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void deleteAnyElement (E e) {
        //先判断是否存在，存在才删除
        if (contains(e)) {
            root = deleteAnyElement(root, e);
        }
    }
    private Node deleteAnyElement (Node node, E e) {
        if (e.compareTo(node.e) == 0) {
            if (node.left == null) {
                Node rightTemp = node.right;
                node.right = null;
                return rightTemp;
            }
            if (node.right == null) {
                Node leftTemp = node.left;
                node.left = null;
                return leftTemp;
            }
            //找到比他大的最接近他的元素
            Node houji = minnum(node.right);
            //把删除上面元素之后的树作为他的右子树
            houji.right = realRemoveMin(node.right);
            houji.left = node.left;
            node.right = node.left = null;
            return houji;
        }else if (e.compareTo(node.e) > 0) {
            node.right = deleteAnyElement(node.right, e);
            return node;
        } else {
            node.left = deleteAnyElement(node.left, e);
            return node;
        }
    }

    /**
     * 巧妙的利用队列实现二分搜索树的广度遍历（层序遍历）， 区别于一根筋扎到最深，然后往上返
     */
    public void guangDuBianLiByQueue() {
        Queue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add(this.root); //先填进去一个元素
        while (!queue.isEmpty()) {
            Node node = queue.remove();//remove方法，从队首拿元素
            System.out.println(node.e);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generBstString(root, 0, res);
        return res.toString();
    }

    private void generBstString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generDepthString(depth)).append( "null\n");
            return;
        }
        res.append(generDepthString(depth)).append(node.e).append("\n");
        generBstString(node.left, depth + 1, res);
        generBstString(node.right, depth + 1, res);
    }

    private String generDepthString (int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
