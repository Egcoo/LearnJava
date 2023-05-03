package LocalDate11;

import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @ author Egcoo
 * @ date 2022/7/2 - 10:03
 */
public class LocalDate01 {
    public static void main(String[] args) {
        //第三代日期
        //老韩解读
        //1. 使用 now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
        System.out.println(ldt);

        //2. 使用 DateTimeFormatter 对象来进行格式化
        // 创建 DateTimeFormatter 对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println("格式化的日期=" + format);
        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());
        LocalDate now = LocalDate.now(); //可以获取年月日

        LocalTime now2 = LocalTime.now();//获取到时分秒
    }
}
