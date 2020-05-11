package demo;

/**
 * Created with IntelliJ IDEA.
 * Description: 泛型
 * <T>: 只是一个占位符, 表示当前类为泛型类
 *
 * 泛型的坑:
 * 1. 不能 new 一个泛型类的数组: T[] t = new T[10]是不行的
 * 2. 简单类型不能作为泛型类型的参数:  MyArrayList<float> myArrayList = new MyArrayList() 是不行的
 * 3. 泛型类型的参数, 不参与类型的组成
 *     MyArrayList<Integer> myArrayList = new MyArrayList<>();
 *     System.out.println(myArrayList); // demo.MyArrayList@4554617c
 *
 * 泛型的意义:
 * 1. 可以自动进行类型的检查
 * 2. 可以自动进行类型的转换
 *
 *
 * 面试问题(重要): 泛型到底是怎样进行编译的?  擦除机制
 *  泛型只是编译时期的一种机制 --> 擦除机制(!!!)  在运行的时候, 不存在泛型这种说法
 *  所有的处理在编译阶段就已经处理
 *
 * 什么是擦除机制: 在编译的时候, 泛型类型会被擦除为Object类型. 但是不是替换
 * User: HHH.Y
 * Date: 2020-05-11
 */
// MyArrayList 里面存放的都是 T 类型
public class MyArrayList<T> {
    public T[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem = (T[]) new Object[10]; // 初始容量为10
    }

    // 默认放在数组的最后
    public void add(T data) {
        this.elem[usedSize] = data;
        this.usedSize++;
    }

    public T getData(int pos) {
        return this.elem[pos];
    }
}
