package com.DAO.test;

import com.DAO.dao.ActorDAO;
import com.DAO.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/11/10 - 22:01
 */
public class testDAO {

    // 测试ActorDAO 对actor表crud 操作
    @Test
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();

        // 1.查询
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("=== 查询结果====");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        //2. 查询单行记录
        Actor actor = (Actor) actorDAO.querySingle("select * from actor where id = ?", Actor.class, 6);
        System.out.println("====查询单行结果====");
        System.out.println(actor);
    }
}
