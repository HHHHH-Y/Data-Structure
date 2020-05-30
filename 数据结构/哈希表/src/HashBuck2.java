import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description: 由于哈希表中可以存放多种类型的元素, 因此应该使用泛型.
 * 使用泛型实现哈希表的算法(不考虑扩容的情况), 以及使用哈希桶解决冲突
 *
 * 如果将自定义类放进哈希表中, 需要重写 hashCode()方法, 这样就可以将自定义类型以某种方式转换成数组下标
 * 在比较 key 值时, 需要重写 equals方法, 比较值的内容. 若不重写 equals方法, 就会调用 Object方法, 从而比较这个值的地址是否相同.
 * User: HHH.Y
 * Date: 2020-05-30
 */
class Person {
    public String id;

    public Person(String id) {
        this.id = id;
    }

    @Override // 重写 equals 方法, 比较两个值的内容
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override // 重写 hashCode 方法, 将自定义类型以某种方式转化成数组下标
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class HashBuck2<K, V> {

    // 由于在定义 Node 的时候将其类型定义成泛型, 因此在使用Node的时候, 也应该加上泛型
    static class Node<K, V> {
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // 哈希表的性质
    public Node<K, V>[] array = (Node<K, V>[])new Node[10];
    public int usedSize; // 哈希表的有效数据个数, 用于控制装载因子

    // 1. 放入元素
    public void put(K key, V val) {
        int index = key.hashCode() % array.length; // 由于 key.hashCode() 得到的值可能会超出数组容量, 所以将其转换成数组容量以内的.
        Node<K, V> node = new Node<>(key, val);
        Node<K, V> cur = array[index];
        while (cur != null) {
            if(cur.key.equals(key)) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
    }


    // 得到 key 值所对应的 val 值
    public V get(K key) {
        int index = key.hashCode() % array.length;
        Node<K, V> cur = array[index];
        while (cur != null) {
            if(cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Person person1 = new Person("吴亦凡");
        Person person2 = new Person("王俊凯");
        HashBuck2<Person, String>  hashBuck2 = new HashBuck2<>();
        hashBuck2.put(person1, "Kris");
        hashBuck2.put(person2, "Karry");
        System.out.println(hashBuck2.get(person1));
    }
}
