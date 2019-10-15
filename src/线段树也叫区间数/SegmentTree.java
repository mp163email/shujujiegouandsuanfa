package 线段树也叫区间数;

/**
 * des: 线段树
 * 使用数组实现
 * created by miapoeng on 2019/9/16 20:35
 */
public class SegmentTree<E> {

    /**
     * 以数组的形式实现线段树
     */
    private E[] tree;

    /**
     * 存储一个传进来的数据副本
     * 要将data组织成一个树的形式，所以要有上面的tree[]
     */
    private E[] data;

    /**
     * 运算融合器
     */
    private Merge<E> merge;

    /**
     * 知识点： 传进来一个接口，接口背后对应的就是 不同的实现
     * @param arr
     * @param merge
     */
    public SegmentTree(E[] arr, Merge<E> merge) {

        this.merge = merge;

        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 创建以treeIndex为根节点，表示以[l, r]为区间的线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftChildIndex, l, mid);//创建左边线段树
        buildSegmentTree(rightChildIndex, mid + 1, r);//创建右边线段树
        tree[treeIndex] = merge.merge(tree[leftChildIndex] , tree[rightChildIndex]);//给线段树根节点赋值
    }

    /**
     * 返回区间[queryL, queryR]之间的值（值可以是最大值，也可以是最小值，也可以是之间的求和）
     * @param queryL
     * @param queryR
     * @return
     */
    public E query (int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("参数不合法");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 知识点：查询的时候，时间复杂度是Ologn级别， 如果是单纯数组是On级别
     * 宏观语义：返回一个查询结果
     * 在以treeIndex为根的线段树中，[l, r]范围内，搜索区间[queryL, queryR]之间的结果
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query (int treeIndex, int l, int r, int queryL, int queryR) {

        //正好找到就把这个结果返回
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        //有包含关系，就去相关包含的那找到结果，并返回（如果舍弃掉中间的这种情况，只用上下的情况，是不是也会得到同样的值呢?我觉得会）
        if (queryL >= mid + 1) {
            return query(rightChildIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftChildIndex, l, mid, queryL, queryR);
        }

        //两边都有涉及，把两边的值加起来（如果是求和的话），返回
        E leftResult = query(leftChildIndex, l, mid, queryL, mid);
        E rightResult = query(rightChildIndex, mid + 1, r, mid + 1, queryR);
        return merge.merge(leftResult, rightResult);
    }

    /**
     * 获取副本data的大小
     * @return
     */
    public int getSize () {
        return data.length;
    }

    /**
     * 获取副本data里的某个元素
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index illegal");
        }
        return data[index];
    }

    /**
     * 私有的辅助函数
     * 已知一个节点，返回他的左孩子节点
     * @param index
     * @return
     */
    private int leftChild (int index) {
        return 2 * index + 1;
    }

    /**
     * 私有辅助函数
     * 已知一个节点，返回他的右孩子节点
     * @param index
     * @return
     */
    private int rightChild (int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                sb.append(tree[i]);
            } else {
                sb.append("null");
            }
            if (i != tree.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
