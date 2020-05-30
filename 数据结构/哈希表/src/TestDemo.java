/**
 * Created with IntelliJ IDEA.
 * Description: 实现哈希表的算法, 并使用哈希桶解决冲突
 * User: HHH.Y
 * Date: 2020-05-30
 */
class HashBuck {

    // 创建一个静态内部类, 这是存入哈希表的节点
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // 哈希表的性质
    public Node[] array = new Node[10]; // 这是一个存放节点地址的数组
    public int usedSize; // 哈希表的有效数据个数, 用于控制装载因子

    // 1. 放入元素
    public void put(int key, int val) {
        // 通过一个哈希函数, 确定元素应该存放在哪个下标
        // 将元素封装成一个节点, 通过头插法放进对应下标中
        // 在存放的时候, 先查看对应下标中是否有 key 值相同的元素, 若有, 直接更改其val值即可, 若没有, 再通过头插法进行插入
        // 每插入一个元素, 都需要判断重载因子, 如果重载因子过大, 就需要进行扩容
        int index = key % array.length;
        Node node = new Node(key, val);
        Node cur = array[index];

        while (cur != null) {
            if(cur.key == node.key) {
                cur.val = node.val;
                return;
            }
            cur = cur.next;
        }

        node.next = array[index];
        array[index] = node;
        this.usedSize++;

        if(loadFactor() > 0.75) {
            resize();
        }

    }

    // 扩容
    public void resize() {
        // 1. 创建一个新数组, 其长度是原数组长度的二倍
        // 2. 由于数组长度发生变化, 所以元素存放的位置下标也发生了变化, 所以需要重新计算下标位置
        // 3. 将原数组中的节点挪到新数组中
        // 4. 但是是对原数组进行扩容, 因此, 最后还需要将新数组变成原数组
        Node[] newArray = new Node[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            Node curNext = null;
            while (cur != null) {
                int index = cur.key % newArray.length;
                curNext = cur.next;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }
    // 重载因子
    public double loadFactor() {
        return this.usedSize * 1.0 / array.length;
    }

    // 2. 得到 key 值所对应的 val 值
    public int get(int key) {
        // 通过哈希函数得到key所对应的下标
        // 然后遍历该下标对应的节点, 找key对应的val值, 若找到, 就返回val值, 找不到, 就返回 -1
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        for (int i = 0; i < 6; i++) {
            hashBuck.put(i, i);
        }
        hashBuck.put(11, 101);
        System.out.println(hashBuck.get(11));
    }
}
