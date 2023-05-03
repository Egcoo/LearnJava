package Enumeration01;

/**
 * @ author Egcoo
 * @ date 2022/5/4 - 21:59
 */
public class enum02 {
    public static void main(String[] args) {

    }
}

enum Season2 {
    //使用 enum 来实现枚举类
    //使用enum 来代替class
    //2.SPRING("春天","温暖")，形式就是 常量名（参数列表）
    //3.如果有多个常量名，使用逗号间隔就行
    //4.如果使用 enum 来实现枚举类，要将常量写在前面
    //5.无参构造器可以省略 常量后面的 ()
    //6.创建常量的语句，必须写在行首

    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");

    private String name;
    private String feeling;

//    public static final Season SPRING = new Season("春天","温暖");
//    public static final Season SUMMER = new Season("夏天","炎热");
//    public static final Season AUTUMN = new Season("秋天","凉爽");
//    public static final Season WINTER = new Season("冬天","寒冷");

    private Season2(String name, String feeling) {
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