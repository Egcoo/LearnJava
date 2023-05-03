package fruit.dao;

import fruit.pojo.Fruit;

import java.util.List;

/**
 * @ author Egcoo
 * @ date 2023/1/24 - 10:31
 */
public interface fruitDAO {
    //获取所有的库存列表信息
    List<Fruit> getFruitList();
}
