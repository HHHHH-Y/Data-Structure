package demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 有一个List当中存放的是整型的数据. 要求使用Collections.sort对List进行排序
 * User: HHH.Y
 * Date: 2020-05-12
 */
public class TestDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // 在 List 当中存放整型数据
        list.add(12);
        list.add(16);
        list.add(9);
        list.add(36);
        list.add(1);
        list.add(6);
        System.out.println(list); // [12, 16, 9, 36, 1, 6]
        Collections.sort(list);
        System.out.println(list); // [1, 6, 9, 12, 16, 36]
    }
}
