import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: TopK 问题
 * 1. 如果想要得到前 k 个最小的元素, 就需要创建一个大根堆
 * 2. 如果想要得到前 k 个最大的元素, 就需要创建一个小根堆
 * User: HHH.Y
 * Date: 2020-05-26
 */
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
public class TopK {
    // 得到前 k 个最小的元素   建立一个大根堆
    public static int[] topK(int[] array, int k) {
        MyComparator myComparator = new MyComparator();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(myComparator); // 底层就是一个大根堆

        for (int i = 0; i < array.length; i++) {
            // 1. 将元素放入这个大根堆中
            if(priorityQueue.size() < k) {
                priorityQueue.offer(array[i]);
            } else {
                // 2. 大根堆中元素已经放满, 需要从数组的第 k 个元素和大根堆的堆顶元素进行比较
                int val = priorityQueue.peek();
                if(val > array[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(array[i]);
                }
            }
        }
        // 堆中存放的元素就是整个数组中前 k 个最小的元素
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            int v = priorityQueue.poll();
            ret[i] = v;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {10, 6, 7, 1, 3, 9, 4, 2};
        int[] ret = topK(array, 4);
        System.out.println(Arrays.toString(ret));
    }
}
