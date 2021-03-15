package indi.huishi.web;

import indi.huishi.pojo.Student;
import indi.huishi.service.StudentService;
import indi.huishi.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 删除信息
 */
public class StudentScoreDeleteServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("post请求");
        // 获取请求参数
        String no = request.getParameter("no");
        int res = studentService.delete(no);
        // 判断是否成功
        if (res<=0){
            System.out.println("删除失败");
            request.getRequestDispatcher("/pages/menu/delete.jsp").forward(request,response);
        }else{
            request.setAttribute("no",no);
            System.out.println("删除成功");
            request.getRequestDispatcher("/pages/success/delete.jsp").forward(request,response);
        }
    }

}
