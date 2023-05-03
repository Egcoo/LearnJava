package InnerClass08.InnerClassExe;

/**
 * @ author Egcoo
 * @ date 2022/4/30 - 14:27
 */
public class Exe02 {
    public static void main(String[] args) {

        Cellphone cellphone = new Cellphone();
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了......");
            }
        });

        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了.....");
            }
        });
    }


}
interface Bell{
    void ring();
}

class Cellphone{
    public void alarmClock(Bell bell){
        bell.ring();
    }
}