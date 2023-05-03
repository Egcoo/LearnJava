package Homework04;

/**
 * @ author Egcoo
 * @ date 2022/7/20 - 10:51
 */
public class homework02 {
    public static void main(String[] args) {

        T1 t1 = new T1();
        Thread thread = new Thread(t1);
        thread.setName("t1");
        Thread thread1 = new Thread(t1);
        thread1.setName("t2");
        thread.start();
        thread1.start();


    }
}

class T1 implements Runnable {

    private int money = 10000;

    @Override
    public void run() {
        while (true) {

            /*
            1.这里的synchronized 实现了线程同步
            2.当多个线程执行到这里时，就回去争夺 this对象锁
            3.那个线程争夺到 this 对象锁，就执行synchronized 代码块，执行完后，就会释放this
            4.争夺不到 this 对象锁，就会blocked，准备下一次争夺
            5，this 对象锁是非公平锁
             */

            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出来1000，当前余额" + money);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}