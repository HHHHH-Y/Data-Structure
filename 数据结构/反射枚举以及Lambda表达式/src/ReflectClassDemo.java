import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description: 反射的使用
 * 反射上一个类中的 Student 类
 *
 * 总结: 无论是反射一个私有构造方法 还是私有属性或者私有方法
 * 1. 得到一个 Class 对象
 * 2. 如果是构造方法, 需要获得类中的私有构造方法 /   如果是私有属性或者私有方法, 需要的类中的私有属性或私有方法
 * 3. 修改 setAccessible 的值为 true, 才可以对这些私有的构造方法, 属性和方法进行修改
 * 4. 需要使用 newInstance 进行对象的实例, 其返回类型为 Object 类
 * 5. 然后再对想要修改的值进行修改
 *
 * 反射具有重要的几个类: Class类, Field类, Method类, Constructor类
 *
 * 反射的优点和缺点:
 * 优点: 1. 对于任意一个类, 都知道这个类的所有属性和方法; 对于任意一个对象, 都能够调用它的任意一个方法
 *       2. 增加了程序的灵活性和扩展性, 降低耦合性, 提高了自身适应能力
 *       3. 反射应用于很多流行框架中, 如: spring, Struts等
 * 缺点: 1. 使用反射会降低程序效率
 *       2. 反射技术绕过了源代码的技术, 因此会带来维护问题, 并且反射代码会比直接代码更加复杂.
 * User: HHH.Y
 * Date: 2020-05-31
 */
public class ReflectClassDemo {

    // 创建对象
    public static void reflectNewInstance() {
        try {
            Class<?> classStudent = Class.forName("Student");
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;
            System.out.println("获得学生对象："+student);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射私有的构造方法:
     * 1. 得到 Class 对象
     * 2. 获得该类中私有的构造方法
     * 3. 将setAccessible的参数修改成 true
     * 4. 使用 newInstance创建一个类的实例, 从而对类中的属性进行修改
     */
    public static void reflectPrivateConstructor() {
        try {
            // 1. 得到一个 Class 对象
            Class classStudent = Class.forName("Student");
            // 2. 获得该类中私有的构造方法, 注意传入对应的参数
            Constructor<?> declaredConstructorStudent = classStudent.getDeclaredConstructor(String.class, int.class);
            // 3. 设置为 true 后可修改访问权限
            declaredConstructorStudent.setAccessible(true);
            // 4. newInstance是创建类的实例, newInstance 的返回值均为 Object 类型.
            Object objectStudent = declaredConstructorStudent.newInstance("huyue", 21);
            Student student = (Student)objectStudent;
            System.out.println("获得私有构造参数且修改姓名和年龄" + student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射私有属性:
     * 1. 得到一个 Class 对象
     *
     */
    public static void reflectPrivateField() {
        try {
            // 1. 得到一个 Class 对象
            Class classStudent1 = Class.forName("Student");
            // 2. 获得私有属性对象
            Field field = classStudent1.getDeclaredField("name");
            // 3. 想要进行修改, 就得将 setAccessible 修改成 true
            field.setAccessible(true);
            // 4. 使用 newInstance 创建一个实例
            Object object = classStudent1.newInstance();
            Student student = (Student)object;
            // 5. 进行修改
            field.set(student, "xiaohudie"); // 修改要修改的对象, 修改要修改的值
            String name = (String)field.get(student); // 拿到修改对象所对应的值的内容
            System.out.println("反射私有属性修改了name: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射私有方法:
     */
    public static void reflectPrivateMethod() {
        try {
            Class classStudent2 = Class.forName("Student");
            Method method = classStudent2.getDeclaredMethod("function", String.class);
            System.out.println("私有方法的方法名定义为: " + method.getName());
            method.setAccessible(true);
            Object object = classStudent2.newInstance();
            Student student = (Student)object;
            // 修改私有方法应该使用的是 invoke 方法对于私有方法进行修改
            method.invoke(student, "我是给私有的 function 方法传的参数");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        reflectPrivateConstructor();
//        reflectPrivateField();
        reflectPrivateMethod();
    }
}
