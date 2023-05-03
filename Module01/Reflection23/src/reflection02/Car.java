package reflection02;

/**
 * @ author Egcoo
 * @ date 2022/10/22 - 15:15
 */
public class Car {
    public String brand = "宝马";//品牌
    public int price = 500000;
    public String color = "白色";

    @Override
    public String toString() {
        return "reflection02.Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}

