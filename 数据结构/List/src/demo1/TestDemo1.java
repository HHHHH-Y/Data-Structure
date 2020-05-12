package demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 某学校有若干名学生(将学生对象放在一个List中), 每个学生有一个姓名(String), 班级(String)和考试成绩属性(double)
 *              某次考试结束后, 每个学生都获得了考试成绩. 遍历list集合, 并把学生对象的属性打印出来
 * User: HHH.Y
 * Date: 2020-05-12
 */
class Student {
    public String name;
    public String classes;
    public double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}
public class TestDemo1 {
    public static void main(String[] args) {
        // 创建学生对象
        Student student = new Student("张三", "六年级2班", 99.5);
        Student student1 = new Student("李四", "六年级2班", 60.0);
        Student student2 = new Student("王五", "六年级2班", 72.5);
        // 将学生对象放在一个list中
        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        // 打印学生对子那个的属性
        System.out.println(list);
    }
}
