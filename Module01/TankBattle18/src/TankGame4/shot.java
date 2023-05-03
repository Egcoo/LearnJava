package TankGame4;

/**
 * @ author Egcoo
 * @ date 2022/7/20 - 14:18
 */
public class shot implements Runnable {

    int x;//子弹x坐标
    int y;//子弹y坐标
    int direct = 0;
    int speed = 20;
    boolean isLive = true;

    public shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (isLive) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //根据方向来改变 x，y坐标
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }

            System.out.println("子弹 x= " + x + " y= " + y);

            if (!(x >= 0 && x <= 1500 && y >= 0 && y <= 1000)){
                System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }
}
