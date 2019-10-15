package 线段树也叫区间数;

/**
 * 融合器
 * 一个抽象， 传2个参数，返回1个值
 */
public interface Merge<E> {

    /**
     * 传2个参数，返回1个值
     * 可以实现成 两个数之和，也可以是线程求2个数的最大值或者最小值
     * @param e1
     * @param e2
     * @return
     */
    E merge(E e1, E e2);
}
