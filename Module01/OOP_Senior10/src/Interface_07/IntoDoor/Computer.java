package Interface_07.IntoDoor;

/**
 * @ author Egcoo
 * @ date 2022/4/26 - 21:21
 */
public class Computer {
    public void work(UsbInterface usbInterface){
        usbInterface.start();
        usbInterface.stop();
    }

}
