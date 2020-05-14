package demo;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-14
 */
public class TestDemo {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.empty()); // false
        System.out.println(myStack.peek()); // 5
        System.out.println(myStack.pop()); // 5
        System.out.println(myStack.peek()); // 4
        System.out.println(myStack.size()); // 4
    }

    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.empty()); // false
        System.out.println(stack.search(2));
    }
}
