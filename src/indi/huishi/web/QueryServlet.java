package indi.huishi.web;

import indi.huishi.pojo.Student;
import indi.huishi.service.StudentService;
import indi.huishi.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 按姓名查询 按学号查询 统计
 */
public class QueryServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 统计
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
//        System.out.println("get请求");
        List<Map<String,Object>> resultMapList = studentService.statistics();
        request.setAttribute("map",resultMapList);
        System.out.println(resultMapList);
        request.getRequestDispatcher("/pages/success/statistic.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
//        System.out.println("post请求");
        // 获取请求参数
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        Student student = null;
        if (no!= null){// 按学号查询
            student = studentService.queryNo(no);

        }
        else if (name != null) {// 按学号查询
            student = studentService.queryName(name);
        }
        request.setAttribute("student",student);
        // 判断是否查到
        if (student == null){
            System.out.println("未查询到");
            request.setAttribute("status","未查询到信息");
        }else{
            request.setAttribute("status","查询到信息");
        }
        request.getRequestDispatcher("/pages/success/query.jsp").forward(request,response);
    }

}
