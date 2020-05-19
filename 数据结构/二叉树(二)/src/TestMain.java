/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-19
 */
public class TestMain {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        System.out.println("======二叉树的分层遍历======");
        binaryTree.levelOrderTraversal(root);
        System.out.println("======判断是否是完全二叉树======");
        System.out.println(binaryTree.isCompleteTree(root));
        System.out.println();
        System.out.println("======二叉树前序递归遍历========");
        binaryTree.preOrderTraversal(root);
        System.out.println();
        System.out.println("======二叉树前序非递归遍历========");
        binaryTree.preOrderTraversalNul(root);
        System.out.println();
        System.out.println("========二叉树中序递归遍历========");
        binaryTree.inOrderTraversal(root);
        System.out.println();
        System.out.println("=======二叉树中序非递归遍历========");
        binaryTree.inOrderTraversalNul(root);
        System.out.println();
        System.out.println("=========二叉树后序递归遍历========");
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println("=========二叉树后序非递归遍历=========");
        binaryTree.postOrderTraversalNul(root);
    }
}
