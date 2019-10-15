package 链表和递归05;

/**
 * des: 使用递归实现 删除某个链表中的某个值，有多个的时候，删除多个
 * created by miapoeng on 2019/8/16 16:25
 */
public class DelRepeatListElement {
    public static void main(String[] args) {
        int[] params = {1, 2, 6, 3, 6, 7};
        ListNode listNode = new ListNode(params);
        ListNode ret = delListElement(listNode, 6, 1);
        System.out.println(ret);
    }

    /**
     * 这里抽象的递归逻辑是  给这个node, 删除element的元素，就这么简单
     * 知识点：递归方法里的内容都是一样的。但是：但是：但是：传的参数是变化的，不然传一样的，有啥用呢
     * @param node
     * @param element
     * @return
     */
    public static ListNode delListElement (ListNode node, int element, int depth) {
        String str = generDepth(depth);
        System.out.println(str + "==Call==" + node + "==remove==" + element);
        if (node == null) {
            System.out.println(str + "==Null==");
            return null;
        }
        ListNode ret = delListElement(node.next, element, depth + 1);
        if (node.e == element) {
            System.out.println(str + "==Return==" + ret + "==remove==" + element);
            return ret;
        } else {
            node.next = ret;
            System.out.println(str + "==Return==" + node + "==remove==" + element);
            return node;
        }
    }

    /**
     * 知识点：通过深度参数， 打印递归的调用
     * @param depth
     * @return
     */
    public static String generDepth (int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        sb.append(depth);
        return sb.toString();
    }
}
