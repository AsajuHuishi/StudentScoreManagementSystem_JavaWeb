package indi.huishi.service;

import indi.huishi.pojo.User;

//业务
public interface UserService {

    /**
     * 注册用户
     *
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 用户名是否已经存在
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
}
