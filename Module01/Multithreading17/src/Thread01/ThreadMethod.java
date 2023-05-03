package Thread01;

/**
 * @ author Egcoo
 * @ date 2022/7/18 - 12:08
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        fish fish = new fish();
        Thread thread = new Thread(fish);
        thread.setName("666");
        thread.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi" + i);
        }

        thread.interrupt();


    }
}

class fish implements Runnable {

    int count = 0;
    private boolean loop = true;

    //线程使用案例，实现Runnable 接口
    @Override
    public void run() {
        while (loop) {
            for (int i = 0; i < 20; i++) {
                System.out.println("小狗汪汪叫 +" + (++count));
            }
            try {
                System.out.println("休眠中...........");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + "被中断");
            }

//            if (count == 10){
//                break;
//            }
        }

    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}