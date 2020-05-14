package demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-14
 */
public class TestDemo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        myQueue.offer(5);
        System.out.println(myQueue.peek()); // 1
        System.out.println(myQueue.isEmpty()); // false
        System.out.println(myQueue.usedSize); // 5
        System.out.println(myQueue.poll()); // 1
        System.out.println(myQueue.peek()); // 2
    }

    public static void main3(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue);
        System.out.println(queue.peek()); // 1
        System.out.println(queue.poll()); // 1
        System.out.println(queue.peek()); // 2
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.size()); // 4

    }

    public static void main2(String[] args) {
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
