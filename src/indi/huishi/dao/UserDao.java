package indi.huishi.dao;

import indi.huishi.pojo.User;

/**
 * 用户注册+登录
 */
public interface UserDao {
    /**
     * 根据用户名查询该用户是否存在（注册时判断）
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户和密码查询该用户是否存在（登录时判断）
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息（注册）
     * @param user
     * @return
     */
    public int saveUser(User user);

}
