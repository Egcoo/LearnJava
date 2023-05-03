package TankGamePlus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @ author Egcoo
 * @ date 2022/7/15 - 11:39
 * 这里的动作是把画板弄出来
 */

//3.3 为了让panel 不停的重绘，需要将MyPanel 实现 Runnable，当作一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //    定义自己的坦克
    Hero hero = null;
    //定义敌人的坦克，放到vector 里，因为只有这个是可以接受多线程
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己的坦克
        //初始化敌人坦克
        hero.setSpeed(25);
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //这一步做的事情是填充了那个画板，默认颜色为黑色
        g.fillRect(0, 0, 1500, 1000);

        /*
        drawTank(hero.getX(), hero.getY(), g, 0, 0);
        drawTank(hero.getX() + 120, hero.getY(), g, 2, 1);
        drawTank(hero.getX() + 420, hero.getY(), g, 1, 1);
        drawTank(hero.getX() + 620, hero.getY(), g, 3, 0);
         */
        //3.2画出 hero 射击的子弹、
        if (hero.shot != null && hero.shot.isLive == true) {
            System.out.println("子弹被绘制");
            g.setColor(Color.pink);
            g.draw3DRect(hero.shot.x, hero.shot.y, 8, 8, false);
        }

        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        //画出敌人的坦克,遍历 vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
        }
    }

    /**
     * @param x      坦克左上角的x坐标
     * @param y      坦克左上角的 Y 坐标
     * @param g      画笔
     * @param direct 坦克方向
     * @param type   坦克的敌我类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0://我方坦克
                g.setColor(Color.pink);
                break;
            case 1://敌方坦克
                g.setColor(Color.cyan);
                break;
        }

//        根据坦克的方向来绘制坦克，
//        这一步非常重要，把坦克画出来
        //direct 表示方向(0: 向上 1 向右 2 向下 3 向左 )
        switch (direct) {
            case 0://0表示向上
                g.fill3DRect(x, y, 10, 60, false);//坦克左边的轮子
                g.fill3DRect(x + 40, y, 10, 60, false);//坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 30, 40, false);//中间部分的矩形
                g.fillOval(x + 10, y + 15, 30, 30);//坦克原型盖子
                g.drawLine(x + 25, y + 30, x + 25, y - 10);//坦克的炮筒
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);//坦克左边的轮子
                g.fill3DRect(x, y + 40, 60, 10, false);//坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 30, false);//中间部分的矩形
                g.fillOval(x + 15, y + 10, 30, 30);//坦克原型盖子
                g.drawLine(x + 30, y + 25, x + 70, y + 25);//坦克的炮筒
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);//坦克左边的轮子
                g.fill3DRect(x + 40, y, 10, 60, false);//坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 30, 40, false);//中间部分的矩形
                g.fillOval(x + 10, y + 15, 30, 30);//坦克原型盖子
                g.drawLine(x + 25, y + 30, x + 25, y + 70);//坦克的炮筒
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);//坦克左边的轮子
                g.fill3DRect(x, y + 40, 60, 10, false);//坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 30, false);//中间部分的矩形
                g.fillOval(x + 15, y + 10, 30, 30);//坦克原型盖子
                g.drawLine(x + 30, y + 25, x - 10, y + 25);//坦克的炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    //当字符输出的时候，方法就会被触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //键盘上的键被按下，方法就会被触发。
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //先改变坦克方向，后改坦克移动
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }

        //3.1.4相应动作
        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("用户按下了 J 开始发射");
            hero.shotEnemy();
        }
        this.repaint();
    }

    //键盘上的键被释放，方法就会被触发
    @Override
    public void keyReleased(KeyEvent e) {

    }

    //3.3.1 重写run方法
    @Override
    public void run() {// 每隔50毫秒重新绘制区域，子弹就移动
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.repaint();
        }
    }
}
