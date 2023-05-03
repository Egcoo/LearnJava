package fruit.servlets;

import fruit.dao.fruitDAO;
import fruit.dao.impl.FruitDAOImpl;
import fruit.pojo.Fruit;
import myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2023/1/24 - 10:39
 */

// Servlet从3.0开始支持注解的方式注册
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    /*
    原因找到了，没有数据是因为编辑配置的时候，url多加了.html，去掉就可以显示了
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fruitDAO FruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = FruitDAO.getFruitList();
        // 保存到session作用域
        HttpSession session = request.getSession();
        session.setAttribute("fruitList", fruitList);

        // 处理模板（视图名称，）
        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        super.processTemplate("index", request, response);
    }
}
