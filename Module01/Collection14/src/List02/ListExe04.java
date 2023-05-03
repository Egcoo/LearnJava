package List02;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/7/4 - 12:07
 */
@SuppressWarnings({"all"})
public class ListExe04 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(new Book("红楼梦", 100, "曹雪芹"));
        list.add(new Book("西游记", 10, "吴承恩"));
        list.add(new Book("水浒传", 19, "施耐庵"));
        list.add(new Book("三国", 80, "罗贯中"));


        for (Object o : list) {
            System.out.println(o);
        }

        //冒泡排序
        sort(list);
        System.out.println("====排序后===");
        for (Object o : list) {
            System.out.println(o);
        }

    }

    public static void sort(List list) {
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - 1 - i; j++) {
                //在这里很重要一个点在于向下转型取出对象
                Book book = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j + 1, book);
                }
            }
        }
    }
}

class Book {
    private String name;
    private int price;
    private String author;

    public Book(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}