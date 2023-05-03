/**
 * @ author Egcoo
 * @ date 2022/5/11 - 9:44
 */
public class Homework01 {
    public static void main(String[] args) {
        COLOR black = COLOR.BLACK;
        black.show();

        switch (black) {
            case RED:
                System.out.println("不是选择");
                break;
            case BLACK:
                System.out.println("就是选择");
                break;

            default:
                System.out.println("歇一会儿吧~~~");
                break;
        }
    }
}

interface MyInterface {
    public void show();
}

enum COLOR implements MyInterface {
    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    COLOR(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public int getRedValue() {
        return redValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }

    @Override
    public void show() {
        System.out.println("颜色的属性是：" + redValue + "," + greenValue + "," + blueValue);
    }
}