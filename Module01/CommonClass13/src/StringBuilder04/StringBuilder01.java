package StringBuilder04;

/**
 * @ author Egcoo
 * @ date 2022/6/30 - 11:17
 */
public class StringBuilder01 {
    public static void main(String[] args) {

        /*
        1.StringBuilder 继承 AbstractStringBuilder 类
        2.实现了 Serializable ,说明StringBuilder 对象是可以串行化（对象可以网络传输，可以保存到文件）
        3.StringBuilder 是final 类，不能被继承
        4，StringBuilder 对象字符序列仍然是存放在其父类，AbstractStringBuilder 的char[] value；
            因此，字符序列是在堆中
        5.StringBuilder 的方法，没有做互斥的处理，即没有synchronized 关键字，因此单线程使用有风险
         */
        StringBuilder stringBuilder = new StringBuilder();
    }
}
