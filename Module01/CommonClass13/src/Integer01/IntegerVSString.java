package Integer01;

/**
 * @ author Egcoo
 * @ date 2022/6/23 - 11:13
 */
public class IntegerVSString {
    public static void main(String[] args) {
        Integer n1 = 100;
        //方式1
        String str1 = n1 + "";
        //方式2
        String str = n1.toString();
        //方式3
        String s = String.valueOf(n1);


        //String -> 包装类(Integer)
        String str4 = "12345";
        Integer i2 = Integer.parseInt(str4);//使用到自动装箱
        Integer i3 = new Integer(str4);//构造器
    }
}
