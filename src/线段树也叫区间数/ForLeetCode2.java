package 线段树也叫区间数;

/**
 * des: 不使用线段树，另起一个便于计算的中间数组
 * created by miapoeng on 2019/9/23 17:02
 */
public class ForLeetCode2 {

    private int [] sum;

    public ForLeetCode2 (int[] nums) {
        if (nums.length > 0) {
            sum = new int[nums.length + 1];
            sum[0] = 0;//知识点：最开始构造一个针对于nums[0]到前面的和
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];//知识点：当前值的总和等于前面的总和+当前值
            }
            System.out.println();
        }
    }

    public int sumRange (int i, int j) {
        int sumj = sum[j + 1];//知识点：实际意义上的索引，在sum里要大1个。
        int sumi = sum[i];
        return sumj - sumi;//知识点：求的是后面那个数的前边所有的和减去第一个数前面那个数的所有的和（要把前面那个数包含进来）
    }

    public static void main(String[] args) {
        int[] test = {-2, 0, 3, -5, 2, -1};
        ForLeetCode2 forLeetCode2 = new ForLeetCode2(test);
        System.out.println(forLeetCode2.sumRange(2, 4));
        System.out.println();
    }

}
