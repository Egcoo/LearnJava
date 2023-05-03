package Homework04;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/7/20 - 9:31
 * <p>
 * 1.在 main 方法中启动两个线程
 * 2.第一个线程循环随机打印 100 以内的整数
 * 3. 直到第二个线程从键盘读取了 “Q” 命令
 */
public class Homework01 {
    public static void main(String[] args) {

        T print = new T();
        print.start();
        B b = new B(print);
        b.start();

        /*
        Scanner myScanner = new Scanner(System.in);
        String str = myScanner.next();

        if (Objects.equals(str, "Q")){
            print.setLoop(false);
        }
        while (!Objects.equals(str, "Q")){
            System.out.print("重新输入：");
            str = myScanner.next();
        }

         */
    }
}

class T extends Thread {
    private boolean loop = true;
    //int i = (int) (Math.random() * 100);

    @Override
    public void run() {
        while (loop) {

            System.out.println("hi " + (int)(Math.random() * 100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread{
    private T t;
    private Scanner myScanner = new Scanner(System.in);

    public B(T t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (true){
            //接受用户输入
            System.out.println("请输入你指令 (Q) 表示退出：");
            char key = myScanner.next().toUpperCase().charAt(0);
            if (key == 'Q'){
                t.setLoop(false);
                System.out.println("b线程退出");
                break;
            }
        }
    }
}