package CodeBlock03.Exercise09;

/**
 * @ author Egcoo
 * @ date 2022/5/11 - 9:34
 */
public class Exe07 {
    public static void main(String[] args) {
        Car car = new Car(50);
        car.getAir().flow();
    }
}

class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature >= 40) {
                System.out.println("应该开冷气");
            } else if (temperature < 0) {
                System.out.println("应该开暖气");
            } else {
                System.out.println("正常情况");
            }
        }
    }

    public Air getAir(){
        return new Air();
    }


}
