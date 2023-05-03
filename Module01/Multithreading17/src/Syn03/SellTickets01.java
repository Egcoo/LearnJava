package Syn03;

/**
 * @ author Egcoo
 * @ date 2022/7/18 - 10:53
 */
public class SellTickets01 {
    public static void main(String[] args) {
        /*
        ticket01 ticket01 = new ticket01();
        ticket01 ticket02 = new ticket01();
        ticket01 ticket03 = new ticket01();
        ticket02 ticket04 = new ticket02();
        ticket02 ticket05 = new ticket02();
        ticket02 ticket06 = new ticket02();

        ticket01.start();
        ticket02.start();
        ticket03.start();

         */

        ticket03 ticket03 = new ticket03();
        new Thread(ticket03).start();
        new Thread(ticket03).start();
        new Thread(ticket03).start();

    }
}
//1.实现的落地步骤
// 需要先分析上锁的代码
// 选择 同步代码块 或同步方法
// 要求多线程的锁对象为同一个！！！！！


class ticket03 implements Runnable {
    private int ticket = 100; //多个线程共享ticket
    private static boolean loop = true;
    /*
    1.private synchronized void sell() {} 就是一个同步方法
    2.这时锁在 this对象
    3.也可以是在代码块上写 synchronize ，同步代码块上，互斥锁依旧在this 对象上
    synchronized( this ){
    if (ticket <= 0) {
            System.out.println("售票结束......");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "剩余票数：" + (--ticket));
    }
     */

    private synchronized void sell() {
        if (ticket <= 0) {
            System.out.println("售票结束......");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "剩余票数：" + (--ticket));
    }

    @Override
    public void run() {

        while (loop) {

            sell();
        }
    }
}


class ticket01 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (ticket >= 1) {
            System.out.println(Thread.currentThread().getName() + "剩余票数：" + (--ticket));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ticket02 implements Runnable {
    int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket < 1) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "剩余票数：" + (--ticket));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}