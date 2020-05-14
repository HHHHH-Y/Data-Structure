package demo;

/**
 * Created with IntelliJ IDEA.
 * Description: 实现一个链式队
 * User: HHH.Y
 * Date: 2020-05-14
 */
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class MyQueue {
    public Node front;
    public Node rear;
    public int usedSize;

    // 插入一个元素
    public boolean offer(int data){
        Node node = new Node(data);
        // 1. 第一次插入
        if(this.front == null) {
            this.front = node;
            this.rear = node;
        } else {
            // 2. 不是第一次插入
            this.rear.next = node;
            this.rear = this.rear.next;
        }
        this.usedSize++;
        return true;
    }

    //出队且删除队头元素
    public int poll() {
        // 1. 判断队是否为空, 若为空, 就返回-1
        if(!isEmpty()) {
            // 2. 若不为空, 就进行出队
            int data = this.front.data;
            this.front = this.front.next;
            return data;
        }
        return -1;
    }

    // 获取队头的元素
    public int peek() {
        return this.front.data;
    }

    // 判断队是否为空
    public boolean isEmpty() {
        if(this.usedSize == 0) {
            return true;
        }
        return false;
    }

    // 求出 队的长度
    public int size() {
       return this.usedSize;
    }
}
