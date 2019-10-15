package 线段树也叫区间数;

/**
 * des:求一个数组中，某个区间内的和
 * created by miapoeng on 2019/9/23 16:55
 */
public class ForLeetCode1 {

    private SegmentTree<Integer> segmentTree;

    public ForLeetCode1 (int [] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<Integer>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }

    public static void main(String[] args) {
        int[] test = {-2, 0, 3, -5, 2, -1};
        ForLeetCode1 forLeetCode1 = new ForLeetCode1(test);
        System.out.println(forLeetCode1.sumRange(0, 3));
    }

}
