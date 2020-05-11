package demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 装箱 / 装包: 将简单类型包装为 包装类 类型
 * 拆箱 / 拆包: 将包装类 类型拆分成为简单类的类型
 * User: HHH.Y
 * Date: 2020-05-11
 */
public class TestDemo {
    /**
     * 在 valueOf 中, 对于自动装箱的值做了一定的要求
     * 当 -127 <= i <= 128 时, 就会每次从这个下标下去取数字
     * 但是如果超出了这个下标, 就会重新实例化一个对象
     * @param args
     */
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); // true
        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d); // false
    }


    // 自动装箱和自动拆箱
    public static void main2(String[] args) {
        // 1. 自动装箱
        Integer a = 10;
        // 2. 自动拆箱
        int b = a;
    }

    public static void main1(String[] args) {
        int i = 10;
        // 手动装箱操作( 使用 valueOf() 方法 )
        Integer integer = Integer.valueOf(i); // 较常用的方法
//        Integer integer1 = new Integer(i);
        // 手动拆箱操作( 包装类. 简单类Value )
        int a = integer.intValue();
        double b = integer.doubleValue();
    }
}
