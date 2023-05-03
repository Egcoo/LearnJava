package Thread01;

/**
 * @ author Egcoo
 * @ date 2022/7/18 - 10:02
 */
public class Thread02 {
    public static void main(String[] args) throws InterruptedException {

        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();

        //如果希望main 线程去控制 子线程的终止，必须可以修改loop
        //让 子线程退出 run方法，从而终止子线程

//        Thread.sleep(10*1000);



    }
}

class Dog implements Runnable {

    int count = 0;
    private boolean loop = true;

    //线程使用案例，实现Runnable 接口
    @Override
    public void run() {
        while (loop) {
            System.out.println("小狗汪汪叫 +" + (++count));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
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