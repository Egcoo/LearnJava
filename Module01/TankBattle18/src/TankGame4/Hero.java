package TankGame4;

/**
 * @ author Egcoo
 * @ date 2022/7/15 - 11:36
 */
public class Hero extends tank {

    //定义一个shot 对象，表示一个射击线程
    TankGame4.shot shot = null;

    public Hero(int x, int y) {
        super(x, y);
    }


    //3.1.2 射击
    public void shotEnemy() {
        //创建shot 对象，根据当前的Hero对象的位置和方向来创建 Shot
        switch (getDirect()) {//得到shot对象的方向
            case 0:
                shot = new shot(getX() + 25, getY(), 0);
                break;
            case 1:
                shot = new shot(getX() + 60, getY() + 25, 1);
                break;
            case 2:
                shot = new shot(getX() + 25, getY() + 60, 2);
                break;
            case 3:
                shot = new shot(getX(), getY() + 25, 3);
                break;
        }

        //3.1.3启动线程

        new Thread(shot).start();
    }
}
