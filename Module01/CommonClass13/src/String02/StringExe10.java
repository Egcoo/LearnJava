package String02;

/**
 * @ author Egcoo
 * @ date 2022/6/29 - 9:57
 */
public class StringExe10 {
    public static void main(String[] args) {

    }
}

class Test1 {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'h';
    }

    public static void main(String[] args) {
        Test1 ex = new Test1();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + "and");
        System.out.println(ex.ch);
    }
}
