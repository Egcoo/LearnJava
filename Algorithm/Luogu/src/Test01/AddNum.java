package Test01;

/**
 * @ author Egcoo
 * @ date 2022/11/13 - 13:45
 */
public class AddNum {
    public static void main(String[] args) {
        int i = 1;
        double sum = 0;
        while (i < 91380){
            sum += (1.0)/i;
            i++;
        }

        System.out.println(sum);
    }
}


