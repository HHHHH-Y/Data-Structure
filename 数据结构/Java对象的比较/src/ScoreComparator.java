import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description: 分数比较器
 * User: HHH.Y
 * Date: 2020-05-26
 */
public class ScoreComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.score - o2.score;
    }
}
