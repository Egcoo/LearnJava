package servlets;

import fruit.dao.FruitDAO;
import fruit.dao.impl.FruitDAOImpl;
import fruit.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2023/1/15 - 10:54
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get方式目前不需要设置编码（基于tomcat8）
        //post 方式下，设置编码，防止中文乱码
        // 需要注意到是，设置编码这一句必须在所有的获取参数的动作之前

        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        Integer price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        /*
        System.out.println("fname = " + fname);
        System.out.println("price = " + price);
        System.out.println("fcount = " + fcount);
        System.out.println("reamrk = " + remark);
         */

        FruitDAO fruitDAO = new FruitDAOImpl();
        boolean flag = fruitDAO.addFruit(new Fruit(0, fname, price, fcount, remark));

        System.out.println(flag ? "添加成功" : "添加失败");


    }
}
