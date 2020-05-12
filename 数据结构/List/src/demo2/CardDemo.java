package demo2;

import demo.MyArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:  练习 - 扑克牌
 * 1. 买一副牌 (52张, 每个花色都有13张牌 , 总共有4个花色)
 * 2. 洗牌
 * 3. 3个人轮流揭牌, 每个人揭 5张牌
 * User: HHH.Y
 * Date: 2020-05-12
 */
// 首先要有一个扑克牌的类
class Card {
    public int rank; // 牌面值
    public String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // 打印扑克牌的这些属性的话, 需要重写 toString 方法
    @Override
    public String toString() {
        // String类的format()方法用于 创建格式化的字符串 以及连接多个字符串对象
        return String.format("[%s, %d]", suit, rank);
    }
}
public class CardDemo {
    // 初始化花色, 由于花色是不变的, 因此将花色初始化为一个常量数组
    public static final String[] SUITS = {"♥", "♠", "♦", "♣"};

    // 1. 买牌(52张, 每个花色都有13张牌 , 总共有4个花色)
    public static List<Card> buyDeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) { // 4个花色
            for (int j = 1; j <= 13; j++) { // 牌面值: 1 - 13
                int rank = j;
                String suit = SUITS[i];
                // 牌面值和花色都有的情况下, 就可以构成一张牌了
                Card card = new Card(rank, suit);
                // 将每张牌都加到deck的集合中
                deck.add(card);
            }
        }
        return deck;
    }

    // 交换牌
    private static void swap(List<Card> deck, int index, int i) {
        // 数组中的交换形式为   tmp = [index]
        //                    [index] = [i]
        //                    [i] = tmp
        Card tmp = deck.get(index);
        deck.set(index, deck.get(i));
        deck.set(i, tmp);
    }

    // 2. 洗牌(洗的是 deck 这副牌)
    // 通过前后交换, 打乱顺序
    public static void shuffle(List<Card> deck) {
        // 从后向前交换
        for (int i = deck.size() - 1; i > 0 ; i--) {
            Random random = new Random(); // 由于 random 取得的随机值都是从 0 号下标开始的
            int index = random.nextInt(i); // 获得一个随机的下标, 范围是[0, i)
            swap(deck, index, i);
        }
    }


    public static void main(String[] args) {
        List<Card> deck = buyDeck();
        System.out.println(deck);
        System.out.println("洗牌: ");
        shuffle(deck);
        System.out.println(deck);

        // 3个人 轮流 揭牌, 每个人揭 5张牌

        // 1. 3个人的牌应该对应3个集合
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();
        // 2. 如果需要轮流抽牌的话, 需要有一个集合, 里面是3个人
        List<   List<Card>  > hand = new ArrayList<>();
        // 将3个人加入到这个集合中
        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        for (int i = 0; i < 5; i++) { // 每个人只能抽5张
            for (int j = 0; j < 3; j++) { // 共有 3 个人
                // 轮流抽牌
                Card card = deck.remove(0);
               hand.get(j).add(card);
            }
        }
        System.out.println("第1个人的牌: ");
        System.out.println(hand1);
        System.out.println("第2个人的牌: ");
        System.out.println(hand2);
        System.out.println("第3个人的牌: ");
        System.out.println(hand3);
        System.out.println("剩余的牌: ");
        System.out.println(deck);
    }
}
