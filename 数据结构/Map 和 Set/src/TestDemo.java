import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:Map 和 Set
 * 模型: 一般把搜索的数据称为关键字(Key), 和关键字对应的称为值(Value), 分为两种模型:
 * 1. 纯 Key 模型: 只需要判断关键字在不在集合中即可, 即使用 Set
 * 2. Key-Value模型: 需要根据 Key, 找到对应的 Value, 即使用 Map
 * User: HHH.Y
 * Date: 2020-05-27
 */


public class TestDemo {
    // 2. 关于 Set 的使用
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        // 可以进行元素的添加, 但是不能添加重复的元素, 若添加了重复元素, 打印时只会打印一个
        set.add(10);
        set.add(20);
        set.add(10);
        set.add(15);
        System.out.println(set); // 20 10 15
        System.out.println("===============");
        System.out.println(set.contains(10));
        System.out.println("===============");
        // 迭代器 (用于遍历 Set 集合 , 相当于直接打印 Set)
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("===============");
        System.out.println(set.remove(10));
        System.out.println(set);

    }



    // 1. 关于 Map 的使用
    public static void main1(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("曲妖精", "曲筱绡");
        map.put("关关", "关雎尔");
        map.put("小蚯蚓", "邱莹莹");
        System.out.println(map);
        String val  = map.get("曲妖精");
        System.out.println(val);
        System.out.println("==============");
        System.out.println(map.getOrDefault("樊姐", "樊胜美"));
        System.out.println("==============");
        map.remove("小蚯蚓");
        System.out.println(map);
        System.out.println("==============");
        for (Map.Entry<String, String> entry :map.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        System.out.println("==============");
        System.out.println(map.containsKey("曲妖精"));
        System.out.println(map.containsValue("关雎尔"));
    }
}
