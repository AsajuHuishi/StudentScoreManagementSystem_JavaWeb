package indi.huishi.test;

import indi.huishi.dao.StudentDao;
import indi.huishi.dao.impl.StudentDaoImpl;
import indi.huishi.pojo.Student;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class StudentDaoTest {
    StudentDao studentDao = new StudentDaoImpl();

    @Test
    public void test(){
        Student student = new Student("101","zxy",Float.parseFloat("88"),2);
        int res = studentDao.addStu(student);
        out.println(res);
    }

    @Test
    public void testStatistics(){
        List<Map<String,Object>> statistics = studentDao.statistics();
        out.println(statistics);
    }
}
