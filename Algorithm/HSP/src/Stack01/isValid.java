package Stack01;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/3 - 23:02
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *  左括号必须用相同类型的右括号闭合。
 *  左括号必须以正确的顺序闭合。
 */
public class isValid {
    /** 解法1；使用栈与 HashMap
     *  用 HashMap 存储括号，用栈进行循环比对
     *  1.有左括号无对应右括号
     *  2.有右括号无对应左括号
     *
     */
    public boolean isValid1(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();

        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
             if (map.containsKey(c[i])){
                 //也就是左括号
                 stack.push(c[i]);
             } else {
                 //栈为空时来了一个右括号 或者是 右括号的左边不匹配
                 if (stack.isEmpty() || map.get(stack.peek()) != c[i] ){
                     return false;
                 } else {
                     stack.pop();
                 }
             }
        }
        if (!stack.isEmpty()){
            //有左括号无对应右括号
            return false;
        }
        return true;

    }
}
