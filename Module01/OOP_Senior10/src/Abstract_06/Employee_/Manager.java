package Abstract_06.Employee_;

/**
 * @ author Egcoo
 * @ date 2022/4/24 - 14:45
 */
public class Manager extends employee{
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理 " + getName() + " 正在工作");
    }
}
