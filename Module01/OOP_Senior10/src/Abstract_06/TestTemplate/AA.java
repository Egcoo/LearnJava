package Abstract_06.TestTemplate;

/**
 * @ author Egcoo
 * @ date 2022/4/25 - 14:19
 */
public class AA extends Template{
    @Override
    public void job() {
        int sum = 0;
        for (int i = 0; i < 80000; i++) {
            sum += i;
        }
    }
}
