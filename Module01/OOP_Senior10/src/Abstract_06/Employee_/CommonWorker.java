package Abstract_06.Employee_;

/**
 * @ author Egcoo
 * @ date 2022/4/24 - 14:46
 */
public class CommonWorker extends employee {

    public CommonWorker(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("普通工人 " + getName() + " 正在工作");
    }
}
