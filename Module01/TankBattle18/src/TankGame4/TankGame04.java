package TankGame4;

import javax.swing.*;

/**
 * @ author Egcoo
 * @ date 2022/7/15 - 11:36
 */
public class TankGame04 extends JFrame {

    //    定义一个MyPanel来完成初始化
    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame04 tankGame01 = new TankGame04();
    }

    public TankGame04() {
        mp = new MyPanel();
        //3.4 将mp 放置到Thread
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);//把面板添加到游戏区域
        this.setSize(1500,1000);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
