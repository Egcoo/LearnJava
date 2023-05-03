/**
 * @ author Egcoo
 * @ date 2022/5/13 - 22:17
 */

/*
            常见的运行时异常包括
        1) NullPointerException 空指针异常
        2) ArithmeticException 数学运算异常
        3) ArrayIndexOutOfBoundsException 数组下标越界异常
        4) ClassCastException 类型转换异常
        5) NumberFormatException 数字格式不正确异常[
 */
public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
//        int res = num1 / num2;

        //1.int res = num1 / num2;
        //2.当执行到这里，程序就会出现（抛出）异常，ArithmeticException
        //3.当抛出异常以后，程序就会退出，下面代码也就不会执行
        //4.所以就会因为一个并不致命的问题，导致整个系统的崩溃
        //5.所以就出现了一个叫做异常处理机制来解决这个问题
        //6.可以使用 try-catch 异常处理机制来解决
        //7.异常处理就是即使出现了异常，程序也会继续执行
        //

        //异常分两种，一种是运行时异常【程序在运行时发现的异常】一种是编译时异常【编译时，编译器检查出来的异常】

        try {
            int res = num1 / num2;
        } catch (Exception e) {
           //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println("程序继续运行....");
    }
}
