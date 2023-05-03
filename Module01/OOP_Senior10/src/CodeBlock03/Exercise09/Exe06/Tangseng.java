package CodeBlock03.Exercise09.Exe06;

/**
 * @ author Egcoo
 * @ date 2022/5/9 - 22:25
 */
public class Tangseng {
    public static void main(String[] args) {

        //本题可参考的价值非常大，

        Person person = new Person("tangseng", new Horse());
        person.common();
        person.passRiver();
        person.passRiver();
        person.passRiver();
        person.passRiver();
        person.common();
        person.common();
    }
}
