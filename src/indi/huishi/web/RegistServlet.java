package indi.huishi.web;

import indi.huishi.pojo.User;
import indi.huishi.service.UserService;
import indi.huishi.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//注册
public class RegistServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        System.out.println(username+password+email+code);
        //判断验证码 忽略大小写
        if(code.equalsIgnoreCase("bnbnp")) {
            //如果验证码正确 检查用户名是否可用
            if (userService.existsUsername(username)) {
                //如果用户名已经存在，返回注册页面
                System.out.println("用户名已经存在");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/user/regist.html");
                requestDispatcher.forward(req, resp);
            } else {
                //用户名不存在，将用户名 密码 邮箱 保存到数据库
                User user = new User(null, username, password, email);
                userService.registerUser(user);
                //跳转到 注册成功界面
                req.setAttribute("user",user);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/user/regist_success.jsp");
                requestDispatcher.forward(req, resp);
            }
        }else{
            //验证码错误
            System.out.println("验证码错误"+code);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/user/regist.html");
            requestDispatcher.forward(req, resp);
        }
    }

//    @Test
//    public void test(){
//        String a = "anc";
//        String d = "ANc";
//        System.out.println(a.equalsIgnoreCase(d));
//    }
}
