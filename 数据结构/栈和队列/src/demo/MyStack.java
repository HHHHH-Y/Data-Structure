package demo;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-14
 */
public class MyStack {
    public int[] elem; // 数组
    public int top; // 表示当前可以存放数据的下标

    public MyStack() {
        this.elem = new int[10];
    }

    // 入栈
    public void push(int data) {
        // 1. 判断栈是否已满, 若已满, 需要进行扩容
        if(full()) {
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        // 2. 将元素放入栈中
        this.elem[top++] = data;
    }

    // 判断栈是否为空
    public boolean empty() {
        if(this.top == 0) {
            return true;
        }
        return false;
    }

    // 判断栈是否已满
    public boolean full() {
        if(this.elem.length == this.top) {
            return true;
        }
        return false;
    }

    // 出栈
    public int pop() {
        // 1. 如果栈为空, 就不能进行出栈
        if(!empty()) {
        // 2. 栈不为空, 就出栈
            // 1. 先拿到栈顶元素
            int data = this.elem[this.top - 1];
            // 2. 让 top 指向栈顶元素的位置
            this.top--;
            return data;
        }
        return -1;
    }

    // 拿到栈顶元素
    public int peek() {
        // 1. 栈是否为空, 若为空, 就返回-1
        if(!empty()) {
            // 2. 若不为空, 就返回栈顶元素
            return this.elem[this.top - 1];
        }
        return -1;
    }

    public int size() {
        return this.top;
    }

}
