package StringBuffer03;

/**
 * @ author Egcoo
 * @ date 2022/6/25 - 12:00
 */
public class StringBuffer01 {
    public static void main(String[] args) {
        //1. StringBuffer 的直接父类 是 AbstractStringBuilder
        //2. StringBuffer 实现了 Serializable, 即 StringBuffer 的对象可以串行化
        //3. 在父类中 AbstractStringBuilder 有属性 char[] value,不是 final
        // 该 value 数组存放 字符串内容，引出存放在堆中的
        //4. StringBuffer 是一个 final 类，不能被继承
        //5. 因为 StringBuffer 字符内容是存在 char[] value, 所有在变化(增加/删除)
        // 不用每次都更换地址(即不是每次创建新对象)， 所以效率高于 String

        String str = "hello tom";
        //方式 1 使用构造器
        //注意： 返回的才是 StringBuffer 对象，对 str 本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str);
        //方式 2 使用的是 append 方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);
        //看看 StringBuffer ->String
        StringBuffer stringBuffer3 = new StringBuffer("韩顺平教育");
        //方式 1 使用 StringBuffer 提供的 toString 方法
        String s = stringBuffer3.toString();
        //方式 2: 使用构造器来搞定
        String s1 = new String(stringBuffer3);
    }
}
