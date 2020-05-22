import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 模拟实现一个堆, 并实现堆的各个操作
 * 只有完全二叉树, 才适合使用顺序存储的方式.
 *
 * 优先级队列的底层是一个小根堆
 * User: HHH.Y
 * Date: 2020-05-22
 */

// 堆的存储是采用的顺序存储的方式, 其底层是以数组的方式进行存储的.
public class TestHeap {
    public int[] elem;
    public int usedSize;
    public TestHeap() {
        this.elem = new int[10]; // 初始化容量为10
    }

    /**
     * 堆进行调整(向上调整/向下调整), 时间复杂度为 O(logn)
     * root 代表的是需要进行调整的根节点
     * len 代表的是调整的范围
     * @param root
     * @param len
     */
    // 向下调整
    public void adjustDown(int root, int len) {
        int parent = root;
        int child = 2 * parent + 1; // 默认孩子孩子节点为左孩子
        while (child  < len) {
            // 1. 判断是否有右孩子, 然后让child指向左右孩子中值最大的孩子节点
            if(child + 1 < len && this.elem[child] < this.elem[child + 1]) {
                child = child + 1;
            }
            // 2. 代码走到这一行, 说明 child 已经指向了最大的孩子节点
            // 3. 将父节点和孩子节点进行比较, 若父节点小于孩子节点, 就需要进行交换
            if(this.elem[parent] < this.elem[child]) {
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                // 4. 如果父节点大于孩子节点, 直接返回
                break;
            }
        }
    }
    
    // 创建一个大根堆 (创建堆的时间复杂度为: O(n) )
    public void createHeap(int[] array) {
        // 将 array 中的元素全部放入 elem 中
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        
        // 需要对元素进行向下调整
        // 这里表示向下调整的次数
        for (int i = (this.usedSize - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(i, this.usedSize);
        }
    }

    // 打印堆
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 向上调整
    public void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if(this.elem[parent] < this.elem[child]) {
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    /**
     * 插入数据
     * @param val
     */
    public void add(int val) {
        // 1. 如果数组已经满了, 就需要进行扩容
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        // 2. 将新插入的元素放在数组最后(记得更新usedSize)
        this.elem[this.usedSize] = val;
        this.usedSize++;
        // 3. 然后进行向上调整
        adjustUp(this.usedSize - 1);
    }

    // 判断数组是否已满
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    /**
     * 删除堆顶元素
     */
    // 堆的删除(堆要进行删除, 一定删除的是堆顶元素)
    public void pop() {
        // 1. 判断堆是否为空, 若为空, 直接返回.
        if(isEmpty()) {
            return;
        }
        // 2. 若不为空, 将堆顶元素和最后一个元素进行交换
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize - 1];
        this.elem[this.usedSize - 1] = tmp;
        this.usedSize--; // 11 -> 10
        // 3. 然后调整0号下标这个堆
        adjustDown(0, this.usedSize);
    }

    // 判断堆是否为空
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    /**
     * 如果进行堆排序, 时间复杂度为: O(n*logn)
     * 空间复杂度为: O(1)
     */
    // 如果想要将元素从小到大排序, 需要建立一个大根堆(反之, 如果想要将元素从大到小排序, 需要建立一个小根堆)
    public void sort() {
        int end = this.usedSize - 1; // 9
        while(end > 0) {
            // 1. 将堆顶元素和最后一个元素进行交换
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            // 2. 将 0 号下标的堆进行向下调整(调整不包括最后一个元素)
            adjustDown(0, end);
            end--;
        }
    }
}
