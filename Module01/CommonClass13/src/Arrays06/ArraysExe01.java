package Arrays06;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ author Egcoo
 * @ date 2022/7/1 - 14:22
 */
public class ArraysExe01 {
    public static void main(String[] args) {

        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘 20 年", 5);
        books[3] = new Book("java 从入门到放弃~", 300);


        //(1)price 从小到大

        Arrays.sort(books, new Comparator() {
            //这里是对数组进行排序，因此就是 o1 和o2
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double priceVal = book2.getPrice() - book1.getPrice();
                //接下来要做一个转换

                if (priceVal > 0) {
                    return 1;
                } else if (priceVal < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(Arrays.toString(books));


        System.out.println("============不同排序分界线========");

        Arrays.sort(books, new Comparator() {
            //这里是对 Book 数组排序，因此 o1 和 o2 就是 Book 对象
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                //要求按照书名的长度来进行排序
                return book2.getName().length() - book1.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));
    }
}


class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}' + '\n';
    }
}
