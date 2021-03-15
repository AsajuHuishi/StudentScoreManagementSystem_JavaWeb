package indi.huishi.service.impl;

import indi.huishi.dao.UserDao;
import indi.huishi.dao.impl.UserDaoImpl;
import indi.huishi.pojo.User;
import indi.huishi.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    /**
     * 注册
     * @param user
     */
    @Override
    public void registerUser(User user) {
        //首先判断用户名是否已经存在 然后调用保存用户
//        if(existsUsername(user.getUsername())){
//            System.out.println("用户名已存在");
//        }else{
        userDao.saveUser(user);
//            System.out.println("注册成功");
//        }
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        //判断用户名和密码是否在数据库中
        User user1 = userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
//        if(user1==null){
//            System.out.println("不正确");
//        }else{
//            System.out.println("登陆成功");
//        }
        return user1;
    }

    /**
     * 判断用户名是否已经存在
     * @param username
     * @return返回true表示用户名已经存在
     */
    @Override
    public boolean existsUsername(String username) {
        //根据用户名查询
        return userDao.queryUserByUsername(username)!=null?true:false;

    }
}
