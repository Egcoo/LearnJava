package Thread01;

/**
 * @ author Egcoo
 * @ date 2022/7/19 - 10:08
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread daemon = new MyDaemonThread();

        //守护线程，当主线程结束子线程也结束
        daemon.setDaemon(true);
        daemon.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("努力工作.....");
        }

    }
}

class MyDaemonThread extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("快乐在聊天哈哈哈哈");
        }
    }
}