import java.util.Arrays;

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
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        System.out.println(Arrays.toString(array));
       /* insertSort(array);*/
        /*selectSort(array);*/
       /* createHeap(array);*/
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
