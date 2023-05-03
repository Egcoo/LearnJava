package Thread01;

/**
 * @ author Egcoo
 * @ date 2022/7/17 - 12:01
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();


        Thread.sleep(10*1000);
        cat.setLoop(false);

        System.out.println("主线程继续执行" + Thread.currentThread().getName());//名字 main
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }



    }
}

class Cat extends Thread {

    int times = 0;
    private boolean loop = true;

    @Override
    public void run() {//一般情况下都要重写run 方法，写上自己的业务逻辑
        while (loop) {
            System.out.println("喵喵，我是小猫咪" + (++times) +
                    " 线程名=" + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            if (times == 80) {
//                break;
//            }
        }
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
