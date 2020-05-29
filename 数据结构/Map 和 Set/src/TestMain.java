/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-29
 */
public class TestMain {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] array = {7, 2, 3, 9, 18, 15, 56};
        for (int i = 0; i < array.length; i++) {
            bsTree.insertNode(array[i]);
        }
        bsTree.insertNode(9);
        bsTree.preOrderSort(bsTree.root);
        System.out.println();
        bsTree.inOrderSort(bsTree.root);
        System.out.println();
        System.out.println(bsTree.search(9).val);
        System.out.println();
        System.out.println(bsTree.remove(2));
        System.out.println(bsTree.remove(18));
        bsTree.preOrderSort(bsTree.root);
        System.out.println();
        bsTree.inOrderSort(bsTree.root);
        System.out.println();
    }
}
