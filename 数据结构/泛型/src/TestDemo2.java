/**
 * Created with IntelliJ IDEA.
 * Description: 泛型是有边界的
 * 一般的泛型只有上界, 没有下界
 *
 * 泛型上界表示: class 泛型类名称 <类型形参 extends 类型边界>
 *              T extends Comparable<T> 上界
 *              T 一定是实现了 Comparable 接口的
 * User: HHH.Y
 * Date: 2020-05-27
 */

// 泛型是一个自定义类型, 因此, 不能直接进行比较, 需要使用 Comparable 或 Comparator才可以进行比较
class Generic<T extends Comparable<T>> {
    // 写一个方法, 利用泛型寻找数组的最大值
    public T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}

// 泛型类型推导 --> 根据实参的类型推导出形参的类型
    // 对于静态方法而言, 需要在静态之后加上泛型的边界才可以
class Genetic  {
    public static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        Generic<Integer> generic = new Generic<>();
        Integer[] array = {12, 25, 3,79, 21};
        System.out.println(generic.findMax(array));
    }

}
