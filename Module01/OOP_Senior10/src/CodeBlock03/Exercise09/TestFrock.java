package CodeBlock03.Exercise09;

/**
 * @ author Egcoo
 * @ date 2022/5/8 - 9:24
 */
public class TestFrock {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        Frock frock = new Frock();
        System.out.println(frock);
        Frock frock2 = new Frock();
        System.out.println(frock2);
        Frock frock3 = new Frock();
        System.out.println(frock3);

    }
}

class Frock {
    private int serialNumber;
    private static int currentNum = 10000;

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public Frock() {
        serialNumber = Frock.getNextNum();
    }


    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "Frock{" +
                "serialNumber=" + serialNumber +
                '}';
    }
}