package Array01.DoublePointer;

/**
 * @ author Egcoo
 * @ date 2022/8/11 - 20:40
 * <p>
 * 以下是具体的讲解
 * 典型双指针
 * https://www.bilibili.com/video/BV1954y1Q7dX
 */
public class backspaceCompare844 {
    //转换成数组以后的覆盖


    public boolean backspaceCompare(String s, String t) {

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int i = chars1.length - 1;
        int j = chars2.length - 1;
        int backspaceS = 0;
        int backspaceT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (chars1[i] == '#') {
                    backspaceS++;
                    i--;
                } else if (backspaceS > 0) {
                    backspaceS--;
                    i--;
                } else break;
            }
            while (j >= 0) {
                if (chars1[j] == '#') {
                    backspaceT++;
                    j--;
                } else if (backspaceT > 0) {
                    backspaceT--;
                    j--;
                } else break;
            }
            if (i < 0 && j < 0) {
                return true;
            } else if (i < 0 || j < 0) {
                return false;
            }
            if (chars1[i] != chars2[j]) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
