package Enumeration01;

/**
 * @ author Egcoo
 * @ date 2022/5/4 - 13:45
 */
public class enum01 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING.getName());

    }
}

class Season {
    //构造器私有化不会导致从外部直接new 对象
    //不提供set 防止从外部直接修改类
    //final 和 static 合用是不会导致类被加载，节省资源
    //这个类也可以被继承，final 也可以防止继承后被修改
    private String name;
    private String feeling;

    public static final Season SPRING = new Season("春天","温暖");
    public static final Season SUMMER = new Season("夏天","炎热");
    public static final Season AUTUMN = new Season("秋天","凉爽");
    public static final Season WINTER = new Season("冬天","寒冷");

    private Season(String name, String feeling) {
        this.name = name;
        this.feeling = feeling;
    }

    public String getName() {
        return name;
    }

    public String getFeeling() {
        return feeling;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", feeling='" + feeling + '\'' +
                '}';
    }
}