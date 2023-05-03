package Interface_07.IntoDoor;

/**
 * @ author Egcoo
 * @ date 2022/4/26 - 21:19
 */
public class Camera implements UsbInterface {

    @Override
    public void start() {
        System.out.println("相机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("相机停止工作");
    }
}
