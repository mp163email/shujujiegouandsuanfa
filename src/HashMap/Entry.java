package HashMap;

/**
 * des: HashMap内部的Entry对象
 * created by miapoeng on 2019/1/15 9:32
 */
public class Entry<K, V> {

    private int hashcode;

    private K k;

    private V v;

    private Entry<K, V> next;

    public Entry(int hashcode, K k, V v, Entry<K, V> next) {
        this.hashcode = hashcode;
        this.k = k;
        this.v = v;
        this.next = next;
    }

    /**
     * 找到最后一个next属性是null的Entry
     * @return
     */
    public Entry<K,V> findLastEntry() {
        Entry<K, V> entry = this;
        while (entry.next != null) {
            entry = entry.next;
        }
        return entry;
    }

    /**
     * 找到与hashcode和k相等的entry,并返回他的value值
     * @param hashcode
     * @param k
     * @return
     */
    public V findVByEntry(int hashcode, K k) {
        if (this.hashcode == hashcode && this.k == k) {
            return this.v;
        }
        while (next != null && next.getHashcode() != hashcode) {
            next = next.next;
        }
        if (next.getHashcode() == hashcode && next.getK() == k) {
            return next.getV();
        } else {
            return null;
        }
    }

    public int getHashcode() {
        return hashcode;
    }

    public void setHashcode(int hashcode) {
        this.hashcode = hashcode;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }
}
