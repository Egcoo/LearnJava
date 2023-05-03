package Homework04;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/7/14 - 11:24
 */
public class Homework01 {
    public static void main(String[] args) {

    }

    @Test
    public void testList(){
        DAO<User> dao = new DAO<>();
        dao.save("001",new User(1,13,"jack"));
        dao.save("002",new User(2,18,"king"));
        dao.save("003",new User(3,34,"smith"));

        List<User> list = dao.list();

        System.out.println("list = " + list);

        dao.update("003",new User(3,45,"milan"));
        dao.delete("001");

        System.out.println("修改后");
        list = dao.list();
        System.out.println("list = " + list);

        System.out.println("id = 003" + dao.get("003"));
    }
}
