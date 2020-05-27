import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 关于 Set 和 Map 的练习
 * User: HHH.Y
 * Date: 2020-05-27
 */
public class TestDemo1 {
    /**
     * 10w 个数字, 统计重复数字及其出现的次数
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if(map.get(list.get(i)) == null) {
                // 说明 map 集合中该元素存放的次数为空, 就将该元素放入 map 集合中
                map.put(list.get(i), 1);
            } else {
                // 说明 map 集合中已经放入了该元素
                int num = map.get(list.get(i));
                map.put(list.get(i), num + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey() + "共出现了: " + entry.getValue() + "次");
        }
    }



    /**
     * 大数据去重问题
     * 10W 个数据当中, 有重复元素, 请去掉重复元素
     * @param args
     */
    public static void main2(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        System.out.print(set + " ");
    }




    /**
     * 找出 10W 个数据当中, 第一个重复的元素
     * @param list
     * @return
     */
    public static void findRepeat(ArrayList<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if(set.contains(list.get(i))) {
                System.out.print(list.get(i));
                return;
            } else {
                set.add(list.get(i));
            }
        }
    }
    public static void main1(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000)); // 往 list 集合中存放 10W 个元素
        }
        System.out.println(list);
        findRepeat(list);
    }
}
