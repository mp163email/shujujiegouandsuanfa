package 二分搜索树;

/**
 *
 *           5
 *      3       6
 *   2    4        8
 *
 *
 */
public class BstMain {
    public static void main(String[] args) {

//        BST<Integer> bst = new BST<>();
//        //int[] a = {3, 5, 6, 7, 8};//树的形状受数据插入顺序的影响
//        int[] a = {4, 2, 5, 1, 3};
//        for (int x : a) {
//            bst.add(x);
//        }

        //前序遍历， 前序遍历能推导出树的形状。小的就放到左边，大的就放到右边。（先一根筋的小到底）
//        bst.preOrder();
//        System.out.println();
//        System.out.println(bst);

/*        //中序遍历，  中序遍历是从小到大排的
        bst.inOrder();
        System.out.println();

        //后序遍历
        bst.lastOrder();
        System.out.println();*/

        //前序遍历-非递归
//        bst.preOrderNoDiGui();

        //广度遍历（层序遍历）， 区别于一根筋扎到低的深度遍历。 用的队列，从下往上把元素放到队里的管道里。
        // 先把根节点放进去，拿出的时候，把拿出元素的左右左右节点再放到队列里。依次类推.当队列里都拿出来，也就是队列是空的时候，不再放
//        bst.guangDuBianLiByQueue();

//        //获取最小值
//        System.out.println(bst.minnum());
//
//        //获取最大值
//        System.out.println(bst.maxnum());
//
//        //删除最小值
////        bst.removeMinNum();
//
//        //删除最大值
//        bst.removeMaxNum();

        //删除其中某个值
       // bst.deleteAnyElement(5);

        System.out.println("==========");

        //前序遍历打印一下
      //  bst.preOrder();
        System.out.println();

    }
}
