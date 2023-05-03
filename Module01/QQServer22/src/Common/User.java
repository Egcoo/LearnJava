package Common;

import java.io.Serializable;

/**
 * @ author Egcoo
 * @ date 2022/10/8 - 12:21
 * 表示一个用户信息
 */

// 通过对象流进行读取的话，这个对象需要序列化
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;//用户Id，名字
    private String passwd;// 用户密码

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
