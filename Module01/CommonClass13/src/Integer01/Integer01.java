package Integer01;

/**
 * @ author Egcoo
 * @ date 2022/6/23 - 9:21
 */
public class Integer01 {
    public static void main(String[] args) {
        //手动装箱
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        //手动拆箱
        int i = integer.intValue();

        //jdk5以后，就可以自动装箱和拆箱
        int n2 = 200;
        Integer integer2 = n2;
    }
}
