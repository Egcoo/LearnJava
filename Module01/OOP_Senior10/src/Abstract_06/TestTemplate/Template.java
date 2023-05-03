package Abstract_06.TestTemplate;

/**
 * @ author Egcoo
 * @ date 2022/4/25 - 14:20
 * 这是一个模板设计模式
 */
abstract public class Template {
    public abstract void job();

    public void CalculateTime() {//实现方法，调用job
        //得到开始的时间
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("任务执行时间 = " + (end - start));

    }
}
