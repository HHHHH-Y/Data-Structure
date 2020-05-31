import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * Description: Lambda 在集合中的使用
 * User: HHH.Y
 * Date: 2020-05-31
 */
public class TestDemo3 {
    // Map 接口中 HashMap 的 foreach() 方法
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "bit");
        map.put(3, "hello");
        map.put(4, "lambda");
       /* map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer k, String v) {
                System.out.println(k + "=" + v);
            }
        });*/

        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }


    public static void main1(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("bit");
        list.add("hello");
        list.add("lambda");
        // List 接口中的 sort() 方法
        /*list.sort(new Comparator<String>() {
            @Override public int compare(String str1, String str2) {
                //注意这里比较长度
                return str1.length()-str2.length();
            }
        });
        System.out.println(list);*/

        list.sort((str1, str2) -> str1.length() - str2.length());
        System.out.println(list);

    }

        // Collection 接口中的 foreach() 方法
       /* list.forEach(new Consumer<String>() {
            @Override
            public void accept(String str) {
                //简单遍历集合中的元素。
                System.out.print(str+" ");
            }
        });*/
        // 使用 Lambda 表达式
      /*  list.forEach(str -> System.out.println(str + " "));*/
    //}
}
