import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: 比较器
 * User: HHH.Y
 * Date: 2020-05-26
 */
class Person {
    public String name;
    public int age;
    public int score;

    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class TestDemo3 {
    public static void main(String[] args) {
        AgeComparator ageComparator = new AgeComparator();
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(ageComparator);
        priorityQueue.offer(new Person("zhangsan", 18, 89));
        priorityQueue.offer(new Person("lisi", 8, 66));
        System.out.println(priorityQueue);
    }

    public static void main2(String[] args) {
        Person person1 = new Person("zhangsan", 18, 89);
        Person person2 = new Person("lisi", 8, 66);
        Person person3 = new Person("wangwu", 28, 96);
        Person[] people = new Person[3];
        people[0] = person1;
        people[1] = person2;
        people[2] = person3;
        AgeComparator ageComparator = new AgeComparator();
        ScoreComparator scoreComparator = new ScoreComparator();
        Arrays.sort(people, scoreComparator);
        System.out.println(Arrays.toString(people));
    }

    public static void main1(String[] args) {
        Person person1 = new Person("zhangsan", 18, 89);
        Person person2 = new Person("lisi", 8, 66);
        // 调用了年龄比较器
        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(person1, person2)); // 10
        // 调用了分数比较器
        ScoreComparator scoreComparator = new ScoreComparator();
        System.out.println(scoreComparator.compare(person1, person2)); // 23
    }
}
