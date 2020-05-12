package demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 删除第一个字符串当中出现的第二个字符串中的字符
 * 例如: str1 = "welcome to Hanzhong";
 *       str2 = "come";
 * 打印的结果为: wl t Hanzhng
 * User: HHH.Y
 * Date: 2020-05-12
 */
public class TestDemo3 {
    public static void main(String[] args) {
        // 1. 遍历第一个字符串, 每次拿到一个字符
        // 2. 查看这个字符是否在第二个字符串中出现
        // 3. 如果没有出现, 就将它加到一个list集合中
        String str1 = "welcome to Hanzhong";
        String str2 = "come";
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i); // 提取第一个字符串中的每个字符
            if(!str2.contains(ch + "")) {
                list.add(ch);
            }
        }
        for (char c:list) {
            System.out.print(c);
        }
        System.out.println();
//        System.out.println(list);
    }
}
