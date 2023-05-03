package Enumeration01.EnumExe;

/**
 * @ author Egcoo
 * @ date 2022/5/7 - 9:31
 */
public class Exe01 {
    public static void main(String[] args) {
        Week[] values = Week.values();
        for (Week weekday:values ) {
            System.out.println(weekday);
        }
    }
}

enum Week {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private String name;

    private Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "week{" +
                "name='" + name + '\'' +
                '}';
    }
}
