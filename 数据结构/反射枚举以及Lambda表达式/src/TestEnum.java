import java.lang.reflect.Constructor;

/**
 * 枚举类型
 *
 * 优点: 将常量组织起来进行统一管理
 * 使用场景: 颜色划分, 消息分类等
 *
 * 关于枚举的注意事项:
 * 1. 枚举的构造方法默认是私有的
 * 2. 枚举类型默认继承于 java.lang.Enum
 *
 *
 * 问题: 为什么枚举实现单利模式是最安全的?
 *       因为通过反射, 不能在枚举类外, 拿到枚举的实例
 *
 *
 * 总结:
 * 1. 枚举本身就是一个类, 其构造方法是私有的, 且都默认继承于 java.lang.Enum
 * 2. 枚举可以避免反射和序列化问题
 */
public enum TestEnum {
    Red("red", 1), Black("black", 2), Green("green", 3);
    private String name;
    private int key;

    /**
     * 当枚举对象有参后, 需要提供相应的构造方法
     * 枚举的构造方法默认是私有的
     */
    private TestEnum(String name, int key) {
        this.name = name;
        this.key = key;
    }
    public static TestEnum getEnumKey(int key) {
        for (TestEnum testEnum:TestEnum.values()) {
            if(testEnum.key == key) {
                return testEnum;
            }
        }
        return null;
    }

    // 不能通过反射, 在枚举类外, 拿到枚举的实例
    public static void reflectPrivateConstructor() {
        try {
            Class classEnum = Class.forName("TestEnum");
            Constructor<?> declaredConstructEnum = classEnum.getDeclaredConstructor(String.class, int.class);
            declaredConstructEnum.setAccessible(true);
            Object object = declaredConstructEnum.newInstance("绿色", 666, "父类参数", 888);
            TestEnum testEnum = (TestEnum)object;
            System.out.println("获取枚举的私有构造方法: " + testEnum);

           /* Constructor<?>[] declaredConstructEnum = classEnum.getDeclaredConstructors();
            for (Constructor c:declaredConstructEnum) {
                System.out.println(c);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectPrivateConstructor();
    }
    public static void main4(String[] args) {
        System.out.println(getEnumKey(2));
    }

    public static void main3(String[] args) {
        // 拿到枚举实例 Black
        TestEnum testEnum = TestEnum.Black;
        // 拿到枚举实例 Red
        TestEnum testEnum1 = TestEnum.Red;
        // 比较两个枚举成员在定义时的顺序
        System.out.println(testEnum.compareTo(testEnum1));
        System.out.println(Black.compareTo(Red));
        System.out.println(testEnum.compareTo(Red));
    }

    public static void main2(String[] args) {
        TestEnum[] enums = TestEnum.values();
        /*for (TestEnum i:enums) {
            System.out.println(i);
        }*/
        for (int i = 0; i < enums.length; i++) {
            System.out.println(enums[i] + " " + enums[i].ordinal());
        }
        System.out.println(TestEnum.valueOf("Green")); // 将普通字符串转换成枚举实例
    }

    // 枚举类型的使用方式
    public static void main1(String[] args) {
        // 1. 直接调用
        TestEnum testEnum = TestEnum.Black;
        // 2. 枚举可以使用 switch 语句
        switch (testEnum) {
            case Red:
                System.out.println("red");
                break;
            case Black:
                System.out.println("black");
                break;
            case Green:
                System.out.println("green");
                break;
            default:
                break;
        }
    }

}
