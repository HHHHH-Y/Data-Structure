import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description: 泛型中的通配符  ?
 *  通配符也是泛型的一种
 *  使用了通配符, 可以传入任意类型的数据
 *  通配符一般用于读取: add(?)
 *
 *  在使用通配符时, 其类型为 Object 类型
 *
 *  通配符既有上界, 也有下界
 *        extends  <? extends 上界>
 *        super    <? super 下界>
 *
 *  使用通配符可以用来确定父子类
 *  MyArrayList<?> 是 MyArrayList<? extends Number> 的父类
 *  MyArrayList<? extends Number> 是 MyArrayList<Integer> 的父类
 * User: HHH.Y
 * Date: 2020-05-27
 */

// 写一个通用的方法, 打印集合当中的所有元素
class Genertic<T> {
    public static <T> void printAllList1(ArrayList<T> list) {
        for (T val:list) {
            System.out.print(val + " ");
        }
    }
    public static <T> void printList(ArrayList<?> list) {
        for (Object val:list) {
            System.out.print(val + " ");
        }
    }
}

public class TestDemo3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        Genertic.printList(list);
    }
}
