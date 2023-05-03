package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/1 - 16:16
 */
public class VaildParentheses {

    /*
    本题的实际情况：栈里只有左括号没有右括号，右括号仅在数组中出现，只起到一个匹配作用，如果匹配到了左括号
    就直接让最底下的左括号出栈
     */
    //如果是右括号，寻找栈顶元素 看看是否可以匹配，匹配不上，无效
    //如果是左括号 直接压入栈中
    //  当便利完成的时候 如果不是空栈，说明有左括号未被匹配到 无效
    // 是空栈 有效
    public boolean isValid(String s) {
        //使用映射关系  记录 () [] {}

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (map.containsKey(c)) {
                //左括号
                stack.push(c);
            } else {
                //右括号
                if (stack.empty()) {
                    //右括号出现，但左括号未出现
                    return false;
                }
                //获取栈顶元素
                char top = stack.peek();
                if (!map.get(top).equals(c)) {
                    //右括号出现，但不是与之对应的左括号
                    return false;
                }
                //弹出，左括号，已被抵消
                stack.pop();
            }
        }
        if (!stack.empty()) {
            //左括号出现，右括号未出现
            return false;
        }
        return true;
    }

    //解法2
    //1.当出现左括号时，直接存入右括号
    //2.当出现右括号时，直接取出栈元素匹配
    public boolean isValid1(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }

}
