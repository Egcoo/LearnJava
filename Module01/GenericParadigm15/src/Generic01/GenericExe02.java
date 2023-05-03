package Generic01;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @ author Egcoo
 * @ date 2022/7/12 - 11:58
 */
@SuppressWarnings({"all"})
public class GenericExe02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack", 2000, new MyDate(2001, 4, 12)));
        employees.add(new Employee("tom", 4000, new MyDate(1990, 5, 12)));
        employees.add(new Employee("smith", 50000, new MyDate(1992, 6, 12)));
        employees.add(new Employee("mary", 5000, new MyDate(1995, 7, 12)));

        System.out.println(employees);

        System.out.println("===========对员工进行排序=======");

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // if (o1 instanceof Employee && o2 instanceof Employee)


                int i = o1.getName().compareTo(o2.getName());
                if (i != 0) {
                    return i;
                }

                //下面是对 birthday 的比较，因此，我们最好把这个比较，放在 MyDate
                //封装到 MyDate会让整个程序健壮性，可复用性都更高
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        System.out.println("===========对员工进行排序=======");
        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

//泛型指定了相应的类型
class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        //如果name 相同，就比较 birthday - year
        int yearMinus = year - o.getYear();
        if (yearMinus != 0) {
            return yearMinus;
        }
        //如果 year相同，就比较month
        int monthMinus = month - o.getMonth();
        if (monthMinus != 0) {
            return monthMinus;
        }
        //如果都相同，比较day
        return day - o.getDay();
    }
}