package fruit.dao.impl;

import fruit.dao.fruitDAO;
import fruit.pojo.Fruit;
import myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @ author Egcoo
 * @ date 2023/1/24 - 10:34
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements fruitDAO {

    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }
}
