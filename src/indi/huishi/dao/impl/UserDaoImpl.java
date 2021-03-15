package indi.huishi.dao.impl;

import indi.huishi.dao.UserDao;
import indi.huishi.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username=?";
        return (User)queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username=? and password=?";
        return (User)queryForOne(User.class,sql,username,password);
    }

    /**
     * 保存用户信息到数据库
     * @param user
     * @return
     */
    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
