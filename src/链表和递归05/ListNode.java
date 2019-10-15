package 链表和递归05;

/**
 * des: 链表节点类
 * created by miapoeng on 2019/8/16 15:40
 */
public class ListNode {
    Integer e;
    ListNode next;

    public ListNode() {
        this.e = null;
        next = null;
    }

    public ListNode(int e) {
        this.e = e;
    }

    public ListNode(int e, ListNode next) {
        this.e = e;
        this.next = next;
    }

    public ListNode(int[] arrays) {
        ListNode node = this;
        node.e = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            int value = arrays[i];
            node.next = new ListNode(value);
            node = node.next;
        }
    }

    public ListNode(int[] arrays, int bs) {
        digui(0, arrays, this);
    }

    /**
     * 知识点1：理解递归-从后往前推，从后往前推2层，就能看出端倪
     * 知识点2：写的时候，要抽象出递归逻辑，然后从宏观上去理解里面的调用。把里面的调用看成是1个结果，而不进去思考细节
     * 知识点：所谓宏观上，就理解一层，从前往后理解一层，只理解一层就完事了。 关键是抽象递归逻辑，往往递归逻辑是很简单的，别想太多。
     * 比如这里抽象出的递归逻辑就是 给e赋值，给next赋值。 然后递归的给下一个的e赋值，给下一个的next赋值
     * 知识点：一般是用知识点2看代码，看他的抽象语义是什么；用知识点1运算代码，看他是怎么运转的
     * @param index
     * @param arrays
     * @param curr
     * @return
     */
    private static ListNode digui (int index, int[] arrays, ListNode curr) {
        if (index == arrays.length) {
            return null;
        }
        if (curr == null) {
            curr = new ListNode(arrays[index]);
        } else {
            curr.e = arrays[index];
        }
        curr.next = digui(index + 1, arrays, curr.next);//知识点：这里的调用，直接从宏观上理解方法的语义（结果），就是给next复制
        return curr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.e).append(",");
            curr = curr.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] test = {1,2,5,3,2};
        ListNode listNode = new ListNode(test, 1);
        System.out.println(listNode);
    }
}
