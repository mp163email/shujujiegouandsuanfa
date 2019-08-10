package HashMap;

/**
 * des: 自定义HashMap
 * created by miapoeng on 2019/1/15 9:35
 */
public class HashMap<K, V> implements Map<K, V> {

    /**
     * 数组默认大小
     */
    private int defalutSize = 16;

    private int size;

    /**
     * 内部存储的Entry数组
     */
    Entry<K, V> [] table;

    @Override
    public V put(K k, V v) {
        int hashcode = k.hashCode();
        int index = indexByHashCode(hashcode);
        Entry<K, V>[] table = getTable();
        Entry<K, V> entry = table[index];
        if (entry == null) {
            table[index] = new Entry<>(hashcode, k, v, null);
            size++;
        } else {
            Entry<K, V> lastEntry = entry.findLastEntry();
            lastEntry.setNext(new Entry<>(hashcode, k, v, null));
        }
        return v;
    }

    @Override
    public V get(K k) {
        int hashcode = k.hashCode();
        int index = indexByHashCode(hashcode);
        Entry<K, V>[] table = getTable();
        Entry<K, V> entry = table[index];
        if (entry == null) {
            return null;
        }
        return entry.findVByEntry(hashcode, k);
    }

    public Entry<K, V>[] getTable() {
        if (table == null) {
            table = new Entry[defalutSize];
        }
        return table;
    }

    public int getSize() {
        return size;
    }

    /**
     * 根据hashCode获取小标
     * @param hashcode
     * @return
     */
    private int indexByHashCode(int hashcode) {
        return Math.abs(hashcode % (defalutSize - 1));
    }
}
