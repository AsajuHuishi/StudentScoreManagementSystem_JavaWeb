package indi.huishi.web;

import indi.huishi.pojo.Student;
import indi.huishi.service.StudentService;
import indi.huishi.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * 添加信息 修改信息 排序
 */
public class StudentScoreAddServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("get请求");
        // 排序
        List<Student> studentList = studentService.sort();
        System.out.println(studentList.toString());
        request.setAttribute("studentList",studentList);
        request.setAttribute("size",studentList.size());
        request.getRequestDispatcher("/pages/success/sort.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("post请求");
        // 获取请求参数
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        float score = Float.parseFloat(request.getParameter("score"));
        Integer className = Integer.parseInt(request.getParameter("className"));
        String isUpdate = request.getParameter("update");
        // 创建对象
        Student student = new Student(no, name, score, className);

        int res = 0;
        // 判断添加还是修改
        if (isUpdate.equals("update")){
            res = studentService.update(student);
        }else {
            res = studentService.add(student);
        }
        // 判断是否成功
        if (res<=0){
            System.out.println("添加/修改失败");
            request.getRequestDispatcher("/pages/menu/add.html").forward(request,response);

        }else{
            request.setAttribute("student",student);
            System.out.println("添加/修改成功");
            request.getRequestDispatcher("/pages/success/add.jsp").forward(request,response);
        }
    }
}
