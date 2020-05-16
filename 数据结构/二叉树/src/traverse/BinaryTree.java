package traverse;

/**
 * Created with IntelliJ IDEA.
 * Description: 二叉树的 4 种遍历方式 ( 在遍历的时候, 打印的之一都是根节点 ) :
 * 1. 前序遍历 / 先根遍历: 根 -> 左 -> 右
 * 2. 中序遍历: 左 -> 根 -> 右
 * 3. 后序遍历 左 -> 右 -> 根
 * User: HHH.Y
 * Date: 2020-05-16
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

    // 1. 创建一颗二叉树,返回的是这棵树的根节点
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
        E.right = H;
        C.left = F;
        C.right = G;

        return A;
    }

    // 2. 前序遍历: 根 -> 左 -> 右
    public void preOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历: 左 -> 根 -> 右
    public void inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    // 后序遍历: 左 -> 右 -> 根
    public void postOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    // 遍历思路 -> 求节点的个数  前序遍历
    public static int size = 0; // 静态的size, 使用它应该使用类直接调用
    public void  getSize1(Node root) {
        // 只要节点不为空, 就让 size + 1
        if(root == null) {
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数
    public int getSize2(Node root) {
        // 节点的个数 = 左子树的节点个数 + 右子树的节点个数 + 节点本身
        if(root == null) {
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    // 遍历思路-求叶子结点个数 前序遍历
    public static int leafSize = 0;
    public void getLeafSize1(Node root) {
        if(root == null) {
            return;
        }
        // 左孩子为空, 右孩子也为空, 就是叶子节点
        if(root.left == null && root.right == null) {
            leafSize++;
        } else {
            getLeafSize1(root.left);
            getLeafSize1(root.right);
        }
    }

    // 子问题思路-求叶子结点个数
    public int getLeafSize2(Node root) {
        if(root == null) {
            return 0;
        }
        // 如果根是叶子节点, 就+1
        if(root.left == null && root.right == null) {
            return 1;
        }
        // 否则: 左子树的叶子节点数 + 右子树的叶子节点数
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
   /* public int getKLevelSize(Node root) {

    }*/
}
