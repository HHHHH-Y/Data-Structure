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

    // 获取二叉树的高度
    int getHeight(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int max = leftHeight > rightHeight ? leftHeight : rightHeight;
        return max + 1;
    }

    Node find(Node root, int val){
        if(root == null) {
            return null;
        }
        //1、判断根节点是否是查找的数字val
        if(root.val == val) {
            return root;
        }
        //2、左边
        Node ret = find(root.left, val);
        //  递归--》左边全部递归完成后-》返回值是否是空
        if(ret != null) {
            return ret;
        } else {
            //3、右边
            Node ret1 = find(root.right, val);
            if(ret1 != null) {
                return ret1;
            }
        }
        return null;
    }

    // 判断两棵树是否相同
    public boolean isSameTree(Node p, Node q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public boolean isSubtree(Node s, Node t) {
        if (s == null || t == null) {
            return false;
        }
        // 1. 判断两棵树是否相同
        if (isSameTree(s, t)) {
            return true;
        }
        // 2. 判断t树是不是s的左子树
        if (isSubtree(s.left, t)) {
           return true;
        }
        if (isSubtree(s.right, t)) {
            return true;
        }
        return false;
    }

    class Solution {
        public boolean isBalance(Node root) {
            if(root == null) {
                return false;
            }
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            if(Math.abs(left - right) <= 1){
                return isBalance(root.left) && isBalance(root.right);
            }
            return false;
        }

    }

    public boolean isSymmetricChild(Node leftTree, Node rightTree) {
        if(leftTree != null && rightTree == null || leftTree == null && rightTree != null) {
            return false;
        }
        if(leftTree == null && rightTree == null) {
            return true;
        }
        if(leftTree.val == rightTree.val) {
            return isSymmetricChild(leftTree.left, rightTree.right) && isSymmetricChild(leftTree.right, rightTree.left);
        }
        return false;
    }

}
