import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: comparable 接口
 * 缺点: 每次业务不同, 需要去修改类本身.
 *
 * 重点: 自定义类型, 为什么要实现可以比较的呢?
 *       若不实现比较, 那么会有很多操作在实现的时候出问题, 例如: Arrays.sort()方法
 * User: HHH.Y
 * Date: 2020-05-26
 */
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age; // 从小到大比较
//        return o.score - this.score; // 从大到小比较
    }

     @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 18, 89);
        Student student2 = new Student("lisi", 8, 66);
        Student student3 = new Student("wangwu", 28, 96);
        Student[] students = new Student[3];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        // 若没有实现 comparable 接口, 在进行排序的时候, 由于不知道是通过什么进行排序, 所以会发生类型转换异常.
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

    public static void main1(String[] args) {
        Student student1 = new Student("zhangsan", 18, 89);
        Student student2 = new Student("lisi", 8, 66);
      /*  if(student1 >student2) {
            // Student 类是一个自定义类型, 且并没有实现 comparable 接口, 因此并不知道比较的是什么
        }*/
        /*if(student1.compareTo(student2) > 0) {
            System.out.println("student1 大于 student2");
        }*/
    }
}
