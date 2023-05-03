package Static_01;

/**
 * @ author Egcoo
 * @ date 2022/4/17 - 10:22
 */
public class StaticMethod {
    public static void main(String[] args) {
        Stu jack = new Stu("jack");
        jack.PayFee(200);

        Stu mary = new Stu("mary");
        mary.PayFee(200);

        Stu.ShowFee();

    }
}

class Stu {
    private String name;

    public static double fee;

    public Stu(String name) {
        this.name = name;
    }

    public static void PayFee(double fee){
        Stu.fee += fee;
    }

    public static void ShowFee(){
        System.out.println("共收学费：" + Stu.fee);
    }
}