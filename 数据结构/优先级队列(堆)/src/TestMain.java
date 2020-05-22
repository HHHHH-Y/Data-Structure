/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-22
 */
public class TestMain {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.createHeap(array);
        testHeap.display();
        testHeap.add(80);
        testHeap.display();
        testHeap.pop();
        testHeap.display();
    }
}
