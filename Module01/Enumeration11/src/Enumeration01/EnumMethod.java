package Enumeration01;

/**
 * @ author Egcoo
 * @ date 2022/5/5 - 13:48
 */
public class EnumMethod {
    public static void main(String[] args) {
        //使用Season2 来演示各种方法
        Season2 autumn = Season2.AUTUMN;

        //1) toString:Enum 类已经重写过了，返回的是当前对象名,子类可以重写该方法，用于返回对象的属性信息
        //2) name：返回当前对象名（常量名），子类中不能重写
        //3) ordinal：返回当前对象的位置号，默认从 0 开始
        //4) values：返回当前枚举类中所有的常量
        //5) valueOf：将字符串转换成枚举对象，要求字符串必须
        //为已有的常量名，否则报异常！
        //6) compareTo：比较两个枚举常量，比较的就是编号

        //输出对象的名字,不是属性中的名字，而是这个对象叫什么名
        System.out.println(autumn.name());

        //ordinal:返回当前的对象的位置编号，默认从0开始
        System.out.println(autumn.ordinal());

        //values:从反编译可以看出这个方法是返回一个数组 Season[]
        Season2[] values = Season2.values();
        System.out.println("=======遍历取出枚举对象======");
        for (Season2 season : values) {
            System.out.println(season);
        }

        //valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
        //执行流程
        //1. 根据你输入的 "AUTUMN" 到 Season2 的枚举对象去查找
        //2. 如果找到了，就返回，如果没有找到，就报错
        Season2 autumn1 = Season2.valueOf("AUTUMN");
        System.out.println("autumn1=" + autumn1);
        System.out.println(autumn == autumn1);

        ///compareTo：比较两个枚举常量，比较的就是编号，返回的结果就是两个编号相减。
        /*
        public final int compareTo(E o) {
        return self.ordinal - other.ordinal;
        }
        Season2.AUTUMN 的编号[2] - Season2.SUMMER 的编号[3]
        */
        System.out.println(Season2.AUTUMN.compareTo(Season2.SPRING));
        //
    }
}
