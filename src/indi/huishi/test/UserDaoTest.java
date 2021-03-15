package indi.huishi.test;

import indi.huishi.dao.UserDao;
import indi.huishi.dao.impl.UserDaoImpl;
import indi.huishi.pojo.User;
import org.junit.Test;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername(){
        User user = userDao.queryUserByUsername("admin");
        System.out.println(user.toString());
        if(user==null){
            System.out.println("用户名不存在");
        }else{
            System.out.println("用户名已经存在");
        }
    }
    @Test
    public void queryUserByUsernameAndPassword(){
        User user = userDao.queryUserByUsernameAndPassword("admin","admin");
        System.out.println(user.toString());
        if(user==null){
            System.out.println("用户名密码不正确");
        }else{
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser(){
        //新建一个用户的信息，保存到数据库中
        User user = new User(1,"zengxinyang","970319","939276378@qq.com");
        int result = userDao.saveUser(user);
        System.out.println(result==1?"添加成功":"添加失败");
    }
}
