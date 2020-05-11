package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * Description: Collection 接口的使用
 * User: HHH.Y
 * Date: 2020-05-11
 */
public class TestDemo {
    // 顺序表ArrayList实现了Collection接口, 因此可以使用Collection来实现顺序表的功能
    public static void main(String[] args) {
        // 接口不可以被实例化的, 因此应该实例化一个对象
        // <> 指代的是泛型, 这里说明collection里存放的是String类型的元素
        Collection<String> collection = new ArrayList<>();
        collection.add("我");
        collection.add("爱");
        collection.add("学习");
        System.out.println(collection);
        System.out.println("===============");
        // 也可以通过foreach进行打印
        for (String s:collection) {
            System.out.println(s);
        }
        System.out.println(collection.isEmpty()); // false
        System.out.println(collection.size()); // 3
        collection.remove("我");
        System.out.println(collection);
        // 返回一个装有所有集合中元素的数组
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
        collection.clear();
        System.out.println(collection);
    }
}
