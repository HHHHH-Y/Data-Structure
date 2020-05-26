import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description: 实现一个年龄比较器
 * User: HHH.Y
 * Date: 2020-05-26
 */
public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o2.age - o1.age;
    }
}
