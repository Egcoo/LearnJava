package TankGame4;

import java.util.Vector;

/**
 * @ author Egcoo
 * @ date 2022/7/17 - 10:47
 */
public class EnemyTank extends tank {
    //4.1 主要就是让敌人的坦克也可以发射子弹
    // 4.1.1 在敌人坦克类，使用Vector ，保存多个 shot
    Vector<shot> shots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
