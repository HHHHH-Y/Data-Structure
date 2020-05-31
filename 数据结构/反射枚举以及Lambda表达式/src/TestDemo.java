/**
 * Created with IntelliJ IDEA.
 * Description: 反射
 * Java 的反射机制是在运行状态中, 对于任何一个类, 都可以通过反射的方式访问到任意属性和方法(包括私有的方法)
 *
 * 反射常常用在 现阶段较为流行的框架中, 例如 Spring 框架
 * User: HHH.Y
 * Date: 2020-05-31
 */

/**
 * 在使用反射的时候, 第一步应该得到一个 Class 对象, Class对象是用来存储类信息的
 * Class 对象的产生有三种方式:
 * 1. 使用 Class 对象的 forName 方法, 前提: 已明确类的全路径名
 * 2. 使用 .class方法, 前提: 仅适合在编译前就已经明确了要操作的 Class
 * 3. 使用类对象的 getClass() 方法
 */
class Student {
    //私有属性name
    private String name = "bit";
    //公有属性age
    public int age = 18;
    //不带参数的构造方法
    public Student() {
        System.out.println("Student()");
    }
    // 私有构造方法
    private Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String,name)");
    }
    // 私有方法
    private void eat(){
        System.out.println("i am eat");
    }
    // 共有方法
    public void sleep(){
        System.out.println("i am pig");
    }
    // 私有方法
    private void function(String str) {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
public class TestDemo {

    // 得到 class 对象
    public static void main(String[] args) {
        // 1. 通过 Class 对象的 forName() 静态方法来获取, 最为常用, 但是可能会产生异常, 需要抓异常
        Class c1 = null;
        try {
            c1 = Class.forName("Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 使用 .class 方法, 但前提是需要在编译前就明确要操作的 Class
        Class c2 = Student.class;

        // 3. 使用类对象的 getClass() 方法
        Student student = new Student();
        Class c3 = student.getClass();

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c2 == c3);
    }
}
