package 线段树也叫区间数;

/**
 * des:
 * created by miapoeng on 2019/9/20 11:16
 */
public class SegmentMain {
    public static void main(String[] args) {
        Integer[] test = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(test, (a, b) -> a + b);
        System.out.println(segmentTree);
        System.out.println(segmentTree.query(2, 3));
    }
}
