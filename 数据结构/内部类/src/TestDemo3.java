/**
 * Created with IntelliJ IDEA.
 * Description: 静态内部类
 * 1. 静态内部类中只能访问静态数据成员, 不能访问外部类中的非静态数据成员
 * 2. 如果偏要访问外部类中的非静态数据成员呢?
 *    需要在静态内部类中初始化一个外部类变量, 并提供构造方法
 *
 * User: HHH.Y
 * Date: 2020-05-27
 */
class OutClass {
    public int data1 = 1;
    public static int data2 = 2;
    private int data4 = 4;

    // 静态内部类
    static class InnerClass {
        public int data3 = 3;

        public OutClass out;
        public InnerClass(OutClass out) {
            this.out = out;
        }

        public void func() {
            System.out.println(this.out.data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(this.out.data4);
        }
    }

}
public class TestDemo3 {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        // 1. 关于静态内部类的实例化
        OutClass.InnerClass innerClass = new OutClass.InnerClass(outClass);
        innerClass.func();
    }
}
