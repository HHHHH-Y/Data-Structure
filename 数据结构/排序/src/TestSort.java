import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 排序
 * 如果一个排序是稳定的排序, 那么它可以变为不稳定的排序
 * 但如果一个排序本身就是一个不稳定的排序, 那么是不可能将它转变成一个稳定的排序的
 * User: HHH.Y
 * Date: 2020-05-23
 */
public class TestSort {

    /**
     * 1. 直接插入排序 (越有序越快)
     *    (相当于插扑克牌)
     * 时间复杂度: 最坏情况下: O(n^2)    i 需要将数组遍历一次, 而每次都要和前面所有的 j 进行比较
     *            最好情况下: O(n)      在数组已经有序的情况下, 只需要让 i 遍历数组即可.
     * 空间复杂度: O(1)
     *
     * 稳定性: 稳定排序(没有进行跳跃式的比较)
     * @param array
     */
    public static void insertSort(int[] array) {
        // i 表示当前需要进行排序的元素
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            // j 表示 i 之前的元素
            int j = i - 1;
            for (; j >= 0; j--) {
                if(array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    /*array[j + 1] = tmp;*/
                    break;
                }
            }
            // 如果 j < 0
            array[j + 1] = tmp;
        }
    }

    /**
     * 2. 希尔排序
     *    采用分组的思想, 在组内进行直接插入排序
     *    分组: 分组没有什么规则, 但是需要注意的是: 只要分组是以素数的形式进行分组, 且最后一个一定是 1 组即可
     * 时间复杂度: O(n ^ 1.3) ~ O(n ^ 1.5)
     * 空间复杂度: O(1)
     *
     * 稳定性: 不稳定排序
     * @param array
     */
    public static void shellSort(int[] array, int gap) {
        // 希尔排序在组内其实就是一个直接插入排序
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if(array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    /**
     * 3. 选择排序 (每次选择其中最小的元素插入)
     * 时间复杂度: O(n ^ 2)
     * 空间复杂度: O(1)
     *
     * 稳定性: 不稳定排序
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * 堆排序: 1. 创建堆    2. 进行堆调整
     * 时间复杂度: O(n * logn)
     * 空间复杂度: O(1)
     *
     * 稳定性: 不稳定排序
     * @param array
     * @param root
     * @param len
     */
    // 向下调整
    public static void adjustDown(int[] array, int root, int len) {
        int parent = root;
        int child = parent * 2 + 1;
        // 说明最起码有左孩子
        while (child < len) {
            // 取左右孩子中值最大的孩子节点
            if(child + 1 < len && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if(array[parent] < array[child]) {
                // 如果父节点的值小于孩子节点的值, 交换
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
                // 需要进行进一步的比较
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }
    // 创建堆
    public static void createHeap(int[] array) {
        // 从最后一个不为叶子节点的节点开始进行向下调整
        for (int i = (array.length - 1 - 1) / 2 ; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度为: O(n ^ 2)
     * 空间复杂度为: O(1)
     *
     * 稳定性: 稳定排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        // 用 i 来控制冒泡排序的趟数
        for (int i = 0; i < array.length; i++) {
            // 用 j 来控制每趟冒泡比较的次数
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    // 对于冒泡排序的优化
    public static void betterbubbleSort(int[] array) {
        boolean flag = false;
        // 用 i 来控制冒泡排序的趟数
        for (int i = 0; i < array.length; i++) {
            flag = false;
            // 用 j 来控制每趟冒泡比较的次数
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    // 若发生了交换, 就将flag置为true
                    flag = true;
                }
            }
            // 如果进行了一趟冒泡之后, flag仍然没有发生改变, 说明数组已然有序
            if(flag == false) {
                return;
            }
        }
    }

    /**
     * 快速排序(重要): 排序最快的排序方法
     * 时间复杂度:  一般而言为 O(n * logn)      最坏情况下(数组已经有序): 1 2 3 4 5 6 / 6 5 4 3 2 1  时间复杂度为: O(n ^ 2)
     * 空间复杂度:  一般而言为 O(logn)          最坏情况下: O(n)
     *
     * 稳定性: 不稳定排序
     * @param array
     */
    // 找到基准位置par
    public static int partition(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        // low == high
        array[high] = tmp;
        return high;
    }
    // 通过递归进行快速排序
    public static void quick(int[] array, int left, int right) {
        // 递归的结束条件
        if(left >= right) {
            return;
        }
        int par = partition(array, left, right);
        // 递归par左边的数组
        quick(array, left, par - 1);
        // 递归par右边的数组
        quick(array, par + 1, right);
    }
    // 快速排序
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }


    // 快速排序的非递归形式:  借助栈
    // 第一次找到基准之后, 将其左右数组的left, right 全部入栈, 当栈不为空时, 取出其栈顶两个元素分别作为 right 和 left
    // 继续进行找基准和入栈操作, 直到栈为空, 说明所有元素已经排好序
    public static void quickSortNul(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length - 1;

        int par = partition(array, left, right);
        if(par > left + 1) {
            stack.push(left);
            stack.push(par - 1);
        }
        if(par < right - 1) {
            stack.push(par + 1);
            stack.push(right);
        }
        // 当栈不为空时, 将栈顶的两个元素出栈
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            // 寻找新的基准
            par = partition(array, left, right);
            // 再将新基准的左右数组下标进栈
            if(par > left + 1) {
                stack.push(left);
                stack.push(par - 1);
            }
            if(par < right - 1) {
                stack.push(par + 1);
                stack.push(right);
            }
        }
    }

    /**
     * 归并排序
     * 时间复杂度: O(n * logn)
     * 空间复杂度: O(n)
     *
     * 稳定性: 稳定排序
     *
     * 使用最多的场景: 外排序: 磁盘
     * @param array
     */
    // 合并
    public static void merge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int len = right - left + 1;
        // 创建一个临时空间, 用于存放合并之后的元素分类
        int[] ret = new int[len];
        int i = 0; // i 表示 ret 数组的下标
        // 当两个分类都有元素时
        while (s1 <= mid && s2 <= right) {
            if(array[s1] <= array[s2]) {
                ret[i++] = array[s1++];
            } else {
                ret[i++] = array[s2++];
            }
        }
        while (s1 <= mid) {
            ret[i++] = array[s1++];
        }
        while (s2 <= right) {
            ret[i++] = array[s2++];
        }

        // 合并好的元素全部存放在 ret 数组中, 但是最后打印的却是 array 数组
        // 因此, 需要将 ret 数组中的元素拷贝到 array 数组中, 但是需要注意 ret 数组和 array 数组的下标
        for (int j = 0; j < ret.length; j++) {
            array[j + left] = ret[j];
        }
    }

    public static void merageSortInternal(int[] array, int left, int right) {
        // 递归的结束条件
        if(left >= right) {
            return;
        }
        // 1. 分解
        int mid = (left + right) >>> 1;
        // 左递归
        merageSortInternal(array, left, mid);
        // 右递归
        merageSortInternal(array, mid + 1, right);

        // 2. 合并
        merge(array, left, mid, right);
    }

    public static void mergeSort(int[] array) {
        merageSortInternal(array, 0, array.length -1);
    }

    // 归并排序(非递归形式)
    public static void mergeSortNul(int[] array, int gap) {
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        // 需要视情况而定, 若e2没有越界, 就为s2 + gap - 1, 若 e2 越界, 就为最后一个元素
        int e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
        int[] ret = new int[array.length];
        int k = 0; // 表示ret数组的下标

        // 说明最起码有两个数据段
        while (s2 < array.length) {
            // 说明两个数据段都有元素
            while (s1 <= e1 && s2 <= e2) {
                if(array[s1] <= array[s2]) {
                    ret[k++] = array[s1++];
                } else {
                    ret[k++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                ret[k++] = array[s1++];
            }
            while (s2 <= e2) {
                ret[k++] = array[s2++];
            }
            // 确定新的s1, e1, s2, e2的位置
            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
        }

        // 没有s2 的情况下, 判断是否有s1, 若有, 就将s1的内容直接归并
        while (s1 <= array.length - 1) {
            ret[k++] = array[s1++];
        }
        // 将ret 的内容全部放至 array 中
        for (int i = 0; i < ret.length; i++) {
            array[i] = ret[i];
        }

    }
    public static void main1(String[] args) {
        int[] array = {12, 5, 9, 34, 6, 8, 33, 56, 89, 0, 7,  4, 22, 55, 77};
        System.out.println(Arrays.toString(array));
        int[] drr = {5, 3, 1};
        for (int i = 0; i < drr.length; i++) {
            shellSort(array, drr[i]);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        /*int[] array = {12, 4, 5, 10, 3};*/
        //int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        int[] array = {10, 6, 7, 1, 3, 9, 4, 2};
        System.out.println(Arrays.toString(array));
       /* insertSort(array);*/
        /*selectSort(array);*/
       /* createHeap(array);*/
        /*bubbleSort(array);*/
        /*quickSortNul(array);*/
       /* mergeSort(array);*/
        mergeSortNul(array, 1);
        System.out.println(Arrays.toString(array));
    }
}
