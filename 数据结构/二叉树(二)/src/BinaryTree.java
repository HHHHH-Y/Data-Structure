import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-19
 */
class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class BinaryTree {

    // 创建一棵二叉树
    public Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;

        return A;
    }

    // 二叉树的层序遍历    需要借助一个队完成
    // 出队元素若不为空, 判断它是否有左右孩子, 若存在, 就将孩子节点进队, 若不存在, 就不进队
    public void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) {
            return;
        }
        // root 不为空
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 用 cur 接收出队元素
            Node cur = queue.poll();
            if(cur != null) {
                System.out.print(cur.val + " ");
                // 如果 cur 有左孩子就让左孩子进队
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                // 如果 cur 有右孩子就让右孩子进队
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        System.out.println();
    }

    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) {
            // 空树也是一棵完全二叉树
            return true;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur != null) {
                // 只要cur != null, 就将其左孩子, 右孩子都进队
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                // 如果cur == null, 就立即停止入队
                break;
            }
        }
        // 如果是因为cur == null
        while (!queue.isEmpty()) {
            Node cur1 = queue.peek();
            if(cur1 != null) {
                // 队中存在不为 null 的元素
                return false;
            }
            queue.poll();
        }
        return true;
    }

    // 前序遍历 (递归)  根 -> 左 -> 右
    public void preOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        // 打印根
        System.out.print(root.val + " ");
        // 遍历左子树
        preOrderTraversal(root.left);
        // 遍历右子树
        preOrderTraversal(root.right);
    }

    // 前序遍历(非递归)  借助栈来进行求解
    public void preOrderTraversalNul (Node root) {
        Stack<Node> stack = new Stack<>();
        if(root == null) {
            return;
        }
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }
            // cur == null
            Node top = stack.pop();
            cur = top.right;
        }
    }

    // 中序遍历(递归)  左 -> 又 -> 根
    public void  inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        // 遍历左子树
        inOrderTraversal(root.left);
        // 打印根
        System.out.print(root.val + " ");
        // 遍历右子树
        inOrderTraversal(root.right);
    }

    // 中序非递归遍历  左 -> 根 -> 右
    public void  inOrderTraversalNul(Node root) {
        Stack<Node> stack = new Stack<>();
        if(root == null) {
            return;
        }
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // cur == null
            Node top = stack.pop();
            // 出栈元素就可以进行打印
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

    // 后续遍历(递归) 左 -> 右 -> 根
    public void postOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        // 遍历左子树
        postOrderTraversal(root.left);
        // 遍历右子树
        postOrderTraversal(root.right);
        // 打印根
        System.out.print(root.val + " ");
    }

    /**
     * 后序非递归的注意事项:
     * 1. 根是最后打印的, 因此在打印根之前, 必须将左右子树都访问完, 才可以打印根节点
     * 2. 在左子树为空的前提下, 打印根节点有两种情况:
     *    (1). 右子树也为空, 这是就可以打印根节点了
     *    (2). 右子树已经访问过了, 这时就可以打印根节点了.(所以若有右子树, 访问完之后需要做一个标记, 表示已访问过)
     * @param root
     */
    // 后序非递归遍历  左 -> 右 -> 根
    public void postOrderTraversalNul(Node root) {
        Stack<Node> stack = new Stack<>();
        if(root == null) {
            return;
        }
        Node cur = root;
        Node prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // cur == null
            cur = stack.peek(); // 左子树已经为空, 需要判断右子树
            if(cur.right == null || cur.right == prev) {
                // 右子树为空或者右子树已经遍历过(需要对右树进行标记), 就可以打印cur了
                System.out.print(cur.val + " ");
                stack.pop();
                prev = cur;
                // 避免重复进栈, 需要将cur置为null
                cur = null;
            } else {
                // 右子树不为空, 就需要遍历右子树
                cur = cur.right;
            }
        }
    }
}
