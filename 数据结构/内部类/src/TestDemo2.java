/**
 * Created with IntelliJ IDEA.
 * Description: 实例内部类
 *
 * 问题 1: 怎样拿到实例内部类的对象 ?
 *         由于内部类相当于是外部类的一个普通实例数据成员, 因此, 需要借助外部类对象的引用实例化内部类, 从而拿到内部类对象
 *
 * 问题 2: 实例内部类有额外的开销吗 ?
 *         有!  实例内部类, 包含外部类的 this
 *
 * 问题 3: 实例内部类中, 是否可以定义静态数据成员 ?
 *         因为静态数据成员不依赖于对象, 而实例内部类依赖于外部类对象, 所以不可以!
 *         但是我们可以做到, 只需要将其在编译时期确定下来就可以了.
 *
 * User: HHH.Y
 * Date: 2020-05-26
 */
class OuterClass {
    public int date1 = 1;
    public static int date2 = 2;

    // 实例内部类 --> 相当于是外部类的一个普通实例数据成员
    class InnerClass {
        public int date1 = 11;
        public int date3 = 3;
        public static final int val = 10; // 将 val 变成了常量, 因此其在编译时期就已经确定.
        public void func() {
            System.out.println(this.date1); // 11    this 是一个静态的引用
            System.out.println(OuterClass.this.date1); // 1
            System.out.println(date2);
            System.out.println(date3);
            System.out.println("innerClass func");
        }
    }
}
public class TestDemo2 {
    public static void main(String[] args) {
        // 内部类相当于是外部类的一个普通数据成员, 因此, 需要借助外部类对象的引用去实例化内部类, 从而拿到内部类的对象
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
       innerClass.func();
    }
}
