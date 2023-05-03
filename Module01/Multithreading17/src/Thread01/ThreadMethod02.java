package Thread01;

/**
 * @ author Egcoo
 * @ date 2022/7/18 - 14:41
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {

        T2 t2 = new T2();
        t2.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程 吃了 " + i + "包子");
            if (i == 5){
                System.out.println("让子线程先吃");
                t2.join();//这里相当于让t2 线程先执行完以后再执行
            }
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("子线程 吃了 " + i + "包子");
        }
    }
}