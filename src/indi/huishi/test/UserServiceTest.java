package indi.huishi.test;

import indi.huishi.pojo.User;
import indi.huishi.service.UserService;
import indi.huishi.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser(){
//        userService.registerUser(new User(null,"lwt","123456","lwt123456@qq.com"));
        userService.registerUser(new User(null, "indi/huishi","123456","lwt123456@qq.com"));
    }

    @Test
    public void login(){
        User user1 = userService.login(new User(null,"lwt","123456","lwt123456@qq.com"));
        System.out.println(user1.toString());
    }

}
