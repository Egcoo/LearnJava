package Interface_07.InterfacePoly;

/**
 * @ author Egcoo
 * @ date 2022/4/27 - 22:04
 */
public class InterfacePolyArr {
    public static void main(String[] args) {
        Usb_[] usbs = new Usb_[2];
        usbs[0] = new Phone();
        usbs[1] = new Camera();

        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();
            if (usbs[i] instanceof Phone){
                ((Phone) usbs[i]).call();
            }
        }
    }
}

interface Usb_{
    void work();
}

class Phone implements Usb_{

    @Override
    public void work() {
        System.out.println("手机正在工作.....");
    }

    public void call(){
        System.out.println("手机可以打电话.....");
    }
}
class Camera implements Usb_{

    @Override
    public void work() {
        System.out.println("相机工作中........");
    }
}

