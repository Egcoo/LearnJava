package Interface_07.IntoDoor;

/**
 * @ author Egcoo
 * @ date 2022/4/26 - 21:16
 */
public class Interface01 {
    public static void main(String[] args) {
        Camera camera = new Camera();

        Computer computer = new Computer();

        computer.work(camera);
    }
}
