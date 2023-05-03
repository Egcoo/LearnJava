package Utils;

/**
 * @ author Egcoo
 * @ date 2022/4/10 - 11:04
 */
public class TestUtils {
    public static void main(String[] args) {

        //这是一个测试Utility 工具类的 程序，用完可以直接删除
        //要求输入一个字符串，长度最大为3
        String s = Utility.readString(3);
        System.out.println("s = " + 3);


        //请输入一个字符串，长度最大为10，如果用户直接回车，就返回一个默认值
        // 先不用管这个 Utility具体的内容，就把这个方法当成一个API 用就行
        System.out.println("快输入字符！ ");
        String s2 = Utility.readString(10,"fsj666");
        System.out.println("s2 = " + s2);
    }
}
