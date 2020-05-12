package demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 关于 list(接口) 的使用
 * User: HHH.Y
 * Date: 2020-05-12
 */
public class TestDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 1. 尾插 e
        list.add("Hello");
        list.add("World");
        list.add("sun");
        System.out.println(list); // [Hello, World, sun]

        // 2. 将 e 插入到index位置
        list.add(0, "aaa"); // [aaa, Hello, World, sun]
        list.add(3, "ccc"); // [aaa, Hello, World, ccc, sun]
        System.out.println(list);

        // 3. 尾插C中的位置  boolean addAll(Collection<? extends E> c)
        /**
         * 添加一个元素 c, 需要注意的是:
         * 1. c 必须实现 Collection 接口
         * 2. c 的类型必须是 E 的子类或者本身
         */
        // ArrayList 实现了 List 接口, 相当于实现了 Collection接口
        // list1 的类型是 String, 而 E 也是 String 类的
        List<String> list1 = new ArrayList<>();
        list1.add("java");
        list1.add("sun");
        list.addAll(list1);
        System.out.println(list);// [aaa, Hello, World, ccc, sun, java, sun]

        // 4. 删除 index 位置的元素(删除了这个元素的同时还可以返回被删除的元素)
        String str = list.remove(0);
        System.out.println(str);
        System.out.println(list); // [Hello, World, ccc, sun, java, sun]
        System.out.println("==============");

        // 5. 删除遇到的第一个指定字符串
        list.remove("ccc");
        System.out.println(list); // [Hello, World, sun, java, sun]

        // 6. 获取下标index的元素
        String ret = list.get(3);
        System.out.println(ret);
        System.out.println("===============");

        // 7. 更换下标为 index 的元素: set
        list.set(0, "I");
        list.set(1, "Love");
        System.out.println(list); // // [I, Love, sun, java, sun]

        // 8. 判断 字符串 是否在线性表中
        System.out.println(list.contains("sun"));
        System.out.println(list.contains("Love"));
        System.out.println("=============");

        // 9. 返回第一次出现指定字符串所在的下标
        System.out.println(list.indexOf("sun"));
        System.out.println(list.indexOf("I"));
        System.out.println("=============");

        // 10. 返回指定的字符串出现的最后一个位置
        System.out.println(list.lastIndexOf("sun")); // 4

        // 11. 截取集合的部分
        List<String> list2 = list.subList(1, 4); // 截取的区间为: 左闭右开
        System.out.println(list2); // [Love, sun, java]

        // 12. 清空集合
        list.clear();
        System.out.println(list);
    }
}
