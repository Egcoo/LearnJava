package myssm.util;

/**
 * @ author Egcoo
 * @ date 2023/1/26 - 11:23
 */
public class StringUtil {

    // 判断字符串是否为null 或 ”“
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
