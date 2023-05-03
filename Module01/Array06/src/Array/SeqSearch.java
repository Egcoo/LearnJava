package Array;

/**
 * @ author Egcoo
 * @ date 2022/1/22 - 13:50
 */
import java.util.Scanner;
public class SeqSearch {
    public static void main(String[] args) {

        //从键盘里任意输入一个名称，判断数列中是否包含此名称【顺序查找】
        //如果找到了就提示找到了，没有就提示没有
        String[] names = {"666","777","888","999"};
        Scanner myScanner = new Scanner(System.in);

        System.out.println("请输入名字");
        String findName = myScanner.next();

        //遍历数组，看是否有匹配，如果有则退出
        //一个好用的编程思想，添加索引。

        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (findName.equals(names[i])){
                System.out.println("恭喜你找到" + findName);
                System.out.println("下标为" + i);
                index = i;
                break;
            }

        }
        if (index == 1){
            System.out.println("你没找到");
        }
    }
}
