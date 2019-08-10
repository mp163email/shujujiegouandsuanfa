package HashMap;

public interface Map<K, V> {

    /**
     * put方法
     * @param k
     * @param v
     * @return
     */
    V put(K k, V v);
    
    /**
     * @des get方法
     * created by miaopeng on 2019/1/15 9:37
     * @param k 
     * @return V
     */
    V get(K k);

}
