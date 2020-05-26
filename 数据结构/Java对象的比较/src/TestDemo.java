import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description: java对象的比较
 * equals: 若重写了equals方法后, 其用于比较两个对象是否是相同的对象(主要是用来比较内容)
 *
 * 一般重写 equals 方法的基本步骤:
 * 1. 如果指向同一个对象, 返回true
 * 2. 如果传入的为 null, 返回false
 * 3. 如果传入的对象类型不是所要比较的对象类型, 返回 false
 * 4. 按照类的实现目标完成比较. 例如这里只需要比较牌面值和花色, 若他们都一样, 就可认为是相同的牌
 * User: HHH.Y
 * Date: 2020-05-26
 */
class Card {
    public int rank;//数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }


    @Override
    public boolean equals(Object obj) {
        // 如果两个是同一个对象的引用, 就返回 true
        if (this == obj) {
            return true;
        }
        // 如果待比较对象为空且待比较对象不是Card的子类, 就返回 false
        if (obj == null || !(obj instanceof Card)) {
            return false;
        }
        // 如果牌的牌面值和花色都相同, 就说明两张牌相同
        Card tmp = (Card) obj;
        if(this.rank == tmp.rank && this.suit.equals(((Card) obj).suit)) {
            return true;
        }
        return false;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Card card1 = new Card(5, "♥");
        Card card2 = new Card(5, "♥");
        System.out.println(card1 == card2); // false  比较的是两个引用的地址
       /* System.out.println(card1.equals(card2)); */// false 并没有重写 equals 方法, 因此, 调用的是object的equals方法.
        // 要想card的equals方法也是比较内容的, 就必须重写 equals 方法
        System.out.println(card1.equals(card2)); // true
    }
}
