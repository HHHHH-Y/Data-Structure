package demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-11
 */
public class TestDemo1 {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        System.out.println(myArrayList);

        MyArrayList<String> myArrayList1 = new MyArrayList<>();
        myArrayList1.add("abc");
    }
}
