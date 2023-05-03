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
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        // select * from t_fruit limit (pageNo -1)*5 , 5;
        // 39.4 通配符 这里是任意夹杂keyword就可以查询到
        return super.executeQuery("select * from t_fruit where fname like ? or remark like ? limit ?,5", "%" + keyword + "%", "%" + keyword + "%", (pageNo - 1) * 5);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return super.load("select * from t_fruit where fid = ?", fid);
    }

    @Override
    public void updateFruit(Fruit fruit) {
        String sql = "update t_fruit set fname = ? , price = ? , fcount = ? , remark = ? where fid = ? ";
        super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
    }

    @Override
    public void delFruit(Integer fid) {
        super.executeUpdate("delete from t_fruit where fid = ? ", fid);
    }

    @Override
    public void addFruit(Fruit fruit) {
        String sql = "insert into t_fruit values(0,?,?,?,?)";
        super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
    }

    @Override
    public int getFruitCount(String keyword) {
        // 这里得到的是一个long类型，不可以强转为其他
        return ((Long) super.executeComplexQuery("select count(*) from t_fruit where fname like ? or remark like ?", "%" + keyword + "%", "%" + keyword + "%")[0]).intValue();
    }
}
