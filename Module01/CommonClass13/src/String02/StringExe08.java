package String02;

/**
 * @ author Egcoo
 * @ date 2022/6/25 - 10:03
 */
public class StringExe08 {
    public static void main(String[] args) {
        String a = "hello";//创建 a对象
        String b = "abc";//创建b 对象
        /*
        1.先创建一个 StringBuilder sb = StringBuilder()
        2. 执行 sb.append("hello");
        3.sb.append("abc");
        4.String c = sb.toString()
        //最后其实是C 指向堆中的对象 (String) value[] -> 池中"helloabc"
         */
        String c = a + b;
        String d = "helloabc";
        System.out.println(c == d);
        String e = "hello" + "abc";//直接看池，e是指向常量池
        System.out.println(d == e);
    }
}
