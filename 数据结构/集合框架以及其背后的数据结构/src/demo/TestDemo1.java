package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: MAP 接口的使用
 * MAP 属于键值对存储
 * User: HHH.Y
 * Date: 2020-05-11
 */
public class TestDemo1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("美猴王", "孙悟空");
        map.put("天蓬元帅", "猪八戒");
        map.put("及时雨", "宋江");
//        map.put("及时雨", "宋江1"); // 如果键入多个相同的 k - v, 取最新的值
        System.out.println(map);
        String s = map.get("美猴王");
        System.out.println(s);
        String m = map.getOrDefault("花和尚", "鲁智深");
        System.out.println(m);
        System.out.println(map.containsKey("美猴王"));
        System.out.println(map.containsValue("猪八戒"));
        // 将所有的键值对返回   < >存放的是泛型
        Set<    Map.Entry<String, String>    > set = map.entrySet(); // map.entrySet() 返回的是一个个的键值对, 需要存放到一个数组中
        for (Map.Entry<String, String> entry :set) {
            System.out.println(entry.getKey() + "=>" + entry.getValue());
        }
    }
}
