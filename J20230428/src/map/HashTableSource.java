package map;

import java.util.Hashtable;

@SuppressWarnings({"all"})

public class HashTableSource {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("name", 1);
        hashtable.put("jack", 2);
        hashtable.put("name", 3);
        hashtable.put("maria", 4);
        for (int i = 0; i < 10; i++) {
            hashtable.put(i, i);
        }

        /*
        //初始化容量11，临界因子：0.75
        public Hashtable() {
            this(11, 0.75f);
        }

        private void addEntry(int hash, K key, V value, int index) {
            Entry<?,?> tab[] = table;
            //当已经超过临界值
            if (count >= threshold) {
                // Rehash the table if the threshold is exceeded
                rehash();

                tab = table;
                hash = key.hashCode();
                index = (hash & 0x7FFFFFFF) % tab.length;
            }

            // Creates the new entry.
            @SuppressWarnings("unchecked")
            Entry<K,V> e = (Entry<K,V>) tab[index];
            //把值添加到table的index处
            tab[index] = new Entry<>(hash, key, value, e);
            count++;
            modCount++;
        }

        public synchronized V put(K key, V value) {
            // Make sure the value is not null
            if (value == null) {
                throw new NullPointerException();
            }

            // Makes sure the key is not already in the hashtable.
            Entry<?,?> tab[] = table;
            int hash = key.hashCode();
            int index = (hash & 0x7FFFFFFF) % tab.length;
            @SuppressWarnings("unchecked")
            Entry<K,V> entry = (Entry<K,V>)tab[index];
            for(; entry != null ; entry = entry.next) {
                //哈希值相同且key的内容相同
                if ((entry.hash == hash) && entry.key.equals(key)) {
                    V old = entry.value;
                    //替换value值
                    entry.value = value;
                    return old;
                }
            }

            addEntry(hash, key, value, index);
            return null;
        }

        //扩容机制：
        int newCapacity = (oldCapacity << 1) + 1;

         */
    }
}
