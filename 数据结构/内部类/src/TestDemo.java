import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 内部类:
 * 1. 实例内部类
 * 2. 静态内部类
 * 3. 匿名内部类
 *
 * 以下是匿名内部类
 * User: HHH.Y
 * Date: 2020-05-26
 */
class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
public class TestDemo {

//    MyComparator myComparator = new MyComparator();
//    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(myComparator); // 通过比较器可以将底层小根堆转变成一个大根堆的形式

    // 匿名内部类
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
}
