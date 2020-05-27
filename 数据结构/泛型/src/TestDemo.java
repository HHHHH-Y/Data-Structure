/**
 * Created with IntelliJ IDEA.
 * Description: 泛型
 * 1. <T>: T是占位符, 表示当前类是泛型类
 * 2. 放数据时, 可以自动进行类型检索
 * 3. 取数据时, 可以自动进行类型转换
 * 4. 泛型到底是如何进行编译的? (重要)
 *    泛型是在编译时期的一种机制 --> 擦除机制
 *    在编译的时候, 是按照 Object 进行编译的, 而不是替换成 Object
 * 5. 泛型是有边界的
 *
 * 泛型的坑:
 * 1. 不能 new 一个泛型类型的数组
 * 2. 简单类型不能作为泛型类型的参数
 *    MyStack<int> myStack1 = new MyStack<>(); 错误的
 * 3. 泛型类型的参数, 不参与泛型类型的组成
 * 4. 泛型中的父子类型:
 *    Object类是 Number类的类型, 但是 MyStack<Object> 不是 MyStack<Number> 的父类
 *    需要使用通配符类确定父子类
 *
 * User: HHH.Y
 * Date: 2020-05-27
 */
class Person {

}
class MyStack<T> {
    public T[] elem;
    public int top; // 表示可以存放元素的下标
    public MyStack() {
        this.elem = (T[]) new Object[10]; //
    }

    // 往栈中增加元素
    public void push(T val) {
        this.elem[this.top] = val;
        this.top++;
    }

    // 拿到栈顶元素
    public T peek() {
        return this.elem[this.top - 1];
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person); // Person@4554617c
        MyStack<Integer> myStack = new MyStack<>();
        System.out.println(myStack); // MyStack@74a14482
    }

    public static void main2(String[] args) {
        MyStack<Integer> myStack1 = new MyStack<>();
        myStack1.push(10);
        myStack1.push(20);
        int ret = myStack1.peek(); // 自动进行数据类型转换
        System.out.println(ret);

        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("hello");
        myStack2.push("world");
    }

    public static void main1(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push("hello");
        String ret = (String)myStack.peek();

    }
}
