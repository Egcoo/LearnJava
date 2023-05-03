package Homework06;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/7/11 - 11:17
 */
@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {
        News news = new News("新冠病例超千万，数百万印度教信徒赴恒河”圣浴“引发民众担忧");
        News news2 = new News("男子想起两个月前钓的鱼还在网兜里，捞起一看赶紧放生");

        List list = new ArrayList();
        list.add(news);
        list.add(news2);

        int size = list.size();
//        保证是倒序输出
        for (int i = size - 1; i >= 0; i--) {
            // System.out.println(list.get(i));

            //因为 list 的默认类型是object，所以要先向下转型为news
            News news1 = (News) list.get(i);
            System.out.println(processTitle(news1.getTitle()));
        }

    }

    public static String processTitle(String title) {
        if (title == null) {
            return "";
        }
        if (title.length() > 15) {
            return title.substring(0, 15) + "...";
        } else {
            return title;
        }
    }
}

class News {
    private String title;
    private String context;

    public News(String title) {
        this.title = title;
    }

    public News(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "\nNews{" +
                "title='" + title + '\'' +
                '}';
    }
}