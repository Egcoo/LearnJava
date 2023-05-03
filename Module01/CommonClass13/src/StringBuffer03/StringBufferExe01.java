package StringBuffer03;

/**
 * @ author Egcoo
 * @ date 2022/6/26 - 17:39
 */
public class StringBufferExe01 {
    public static void main(String[] args) {
        String str = null;// ok
        StringBuffer sb = new StringBuffer(); //ok
        sb.append(str);//需要看源码 , 底层调用的是 AbstractStringBuilder 的 appendNull
        System.out.println(sb.length());//4
    }
}
