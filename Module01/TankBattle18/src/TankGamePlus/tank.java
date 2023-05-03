package TankGamePlus;

/**
 * @ author Egcoo
 * @ date 2022/7/15 - 11:36
 */
public class tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct;//坦克的方向,不规定属性，默认为0
    private int speed; //坦克的移动速度

    public tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
