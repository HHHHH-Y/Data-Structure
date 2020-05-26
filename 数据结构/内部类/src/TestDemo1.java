/**
 * Created with IntelliJ IDEA.
 * Description: 匿名内部类
 * 在匿名类的 () 后面加上一个 {} 即可, {} 内部还可以重写类中的方法.
 * User: HHH.Y
 * Date: 2020-05-26
 */
class Animal {
    public void func() {
        System.out.println("Animal :: func");
    }
}
public class TestDemo1 {
    public static void main(String[] args) {
//        Animal animal = new Animal();
//        animal.func(); // Animal :: func

        // 匿名内部类
        new Animal() {
            // 在匿名内部类中也可以重写类中的方法

            @Override
            public void func() {
                System.out.println("我重写了这个func方法");
            }
        }.func(); // 我重写了这个func方法
    }
}
