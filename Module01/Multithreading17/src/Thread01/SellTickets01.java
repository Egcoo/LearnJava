package Thread01;

/**
 * @ author Egcoo
 * @ date 2022/7/18 - 10:53
 */
public class SellTickets01 {
    public static void main(String[] args) {
        ticket01 ticket01 = new ticket01();
        ticket01 ticket02 = new ticket01();
        ticket01 ticket03 = new ticket01();
        ticket02 ticket04 = new ticket02();
        ticket02 ticket05 = new ticket02();
        ticket02 ticket06 = new ticket02();


        ticket01.start();
        ticket02.start();
        ticket03.start();

//        Thread thread = new Thread(ticket04);
//        thread.start();

    }
}

class ticket01 extends Thread{
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

class ticket02 implements Runnable{
    int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket < 1){
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