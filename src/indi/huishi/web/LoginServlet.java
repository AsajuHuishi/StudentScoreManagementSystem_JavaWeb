package indi.huishi.web;

import indi.huishi.pojo.User;
import indi.huishi.service.UserService;
import indi.huishi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//登录
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //检查 用户名和密码是否存在
        User user = userService.login(new User(null,username,password,null));
        if (user==null){
            //用户不存在
            System.out.println("用户不存在");
            //返回登录界面
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }else{
            //跳转到登录成功页面
            System.out.println("登录成功");
            req.setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
