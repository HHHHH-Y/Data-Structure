/**
 * Created with IntelliJ IDEA.
 * Description: 关于 Lambda 表达式
 *
 * Lambda 表达式的组成: (parameters) -> {方法体}
 * parameters: 形参列表
 *
 * 要想了解 lambda 表达式, 就必须知道函数式接口
 * 什么是函数式接口: 一个接口有且只有一个抽象方法
 * 函数式接口通常会用  @FunctionalInterface 进行注解
 *
 * 关于 Lambda 表达式的语法精简;
 * 1. 参数类型可以省略, 如果需要省略, 每个参数类型都要省略
 * 2. 如果只有一个参数, 可以省略()
 * 3. 如果方法体中只有一句代码, {}可以省略
 * 4. 如果方法体中只有一条语句, 并且是 return 语句, {}可以省略, return关键字可以省略
 *
 * User: HHH.Y
 * Date: 2020-05-31
 */

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

class Test {
    public void func() {
        System.out.println("func()");
    }
}
public class TestDemo2 {
    // Lambda 表达式的变量捕获
    public static void main(String[] args) {
//        int a = 100; // 若 a 是一个变量, 那么需要保证 a 是没有改变过的量, 这样才可以进行捕获
        final int a = 100; // a 被 final 修饰过后变成了常量, 因此可以被捕获到
        new Test() {
            @Override
            public void func() {
//                a = 99;
                System.out.println("我是内部类，且重写了func这个方法！");
                System.out.println("我是捕获到变量 a == "+ a  +" 我是一个常量，或者是一个没有改变过值的变量！");
            }
        };

    }


    public static void main1(String[] args) {
        // 在这里重写了 noParameterNoReturn 的 test 方法
        NoParameterNoReturn noParameterNoReturn = () -> System.out.println("无返回值无参数");
//        noParameterNoReturn.test();

        OneParameterNoReturn oneParameterNoReturn = a -> System.out.println("无返回值有一个参数: " + a);
//        oneParameterNoReturn.test(10);

        MoreParameterNoReturn moreParameterNoReturn = (a, b) -> System.out.println("无返回值有多个参数: " + a + " " + b);
//        moreParameterNoReturn.test(100, 200);

        NoParameterReturn noParameterReturn = () -> 40;
//        System.out.println(noParameterReturn.test());

        OneParameterReturn oneParameterReturn = a -> a;
//        System.out.println(oneParameterReturn.test(10));

        MoreParameterReturn moreParameterReturn = (a, b) -> a + b;
        System.out.println(moreParameterReturn.test(100, 200));
    }
}
