/**
 * Created with IntelliJ IDEA.
 * Description: 二叉搜索树练习
 * 二叉搜索树的特点: 对于一个节点而言, 其左子树上的节点值均小于这个节点值, 右子树上的节点值均大于这个节点值
 * 二叉搜索树的左右子树分别也是二叉搜索树
 * User: HHH.Y
 * Date: 2020-05-29
 */

public class BSTree {

    // 二叉搜索树是由一个一个的节点构成的
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    // 定义一个根节点
    public Node root;

    // 在二叉搜索树中插入一个节点, 前提是二叉搜索树中不存在相同值的节点
    public boolean insertNode(int val) {
        Node node = new Node(val);
        // 如果二叉搜索树为空, 就将新插入的节点作为根节点并返回
        if(root == null) {
            root = node;
            return true;
        }
        Node cur = root;
        Node parent = null; // 表示 cur 节点的父节点
        while (cur != null) {
            if(cur.val == val) {
                return false; // 二叉搜索树中不存在值相同的节点
            }
            if(cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if(parent.val > val) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return true;
    }

    // 前序遍历
    public void preOrderSort(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderSort(root.left);
        preOrderSort(root.right);
    }

    // 中序遍历
    public void inOrderSort(Node root) {
        if(root == null) {
            return;
        }
        inOrderSort(root.left);
        System.out.print(root.val + " ");
        inOrderSort(root.right);
    }

    // 查找搜索二叉树中是否存在值 val
    public Node search(int val) {
        Node cur = root;
        while (cur != null) {
            if(cur.val == val) {
                return cur;
            } else if(cur.val > val){
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    public boolean removeNode(Node parent, Node cur) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            } else if(cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            } else if(cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            // cur.left != null && cur.right != null
            Node target = cur.right;
            Node targetP = cur;
            while (target.left != null) {
                targetP = target;
                target = target.left;
            }
            cur.val = target.val; // 此时target一定走到了右树的最左边
            if(target == targetP.left) {
                targetP.left = target.right;
            } else {
                targetP.right = target.right;
            }
        }
        return true;
    }
    // 删除二叉搜索树中的某个节点
    public boolean remove(int val) {
        Node cur = root; // cur 表示要删除的节点
        Node parent = null; // parent 表示要删除节点的父节点

        // 找到要删除的节点位置
        while (cur != null) {
            if(cur.val == val) {
                return removeNode(parent, cur);
            } else if(cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        return false;
    }
}
