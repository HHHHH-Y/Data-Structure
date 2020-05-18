package traverse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-16
 */
public class TestMain {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        // 创建一颗二叉树
        Node root = binaryTree.buildTree();
        // 前序遍历
        binaryTree.preOrderTraversal(root);
        System.out.println();
        // 中序遍历
        binaryTree.inOrderTraversal(root);
        System.out.println();
        // 后序遍历
        binaryTree.postOrderTraversal(root);
        System.out.println();
        binaryTree.getSize1(root);
        System.out.println("节点的个数: " + BinaryTree.size);
        System.out.println();
        System.out.println("节点的个数: " + binaryTree.getSize2(root));
        System.out.println();
        binaryTree.getLeafSize1(root);
        System.out.println("叶子节点的个数: " + BinaryTree.leafSize);
        System.out.println();
        System.out.println("叶子节点的个数: " + binaryTree.getLeafSize2(root));
        System.out.println(binaryTree.getHeight(root));
        Node ret = binaryTree.find(root, 'A');
        System.out.println(ret.val);
    }
}
