package indi.huishi.service.impl;

import indi.huishi.dao.StudentDao;
import indi.huishi.dao.impl.StudentDaoImpl;
import indi.huishi.pojo.Student;
import indi.huishi.service.StudentService;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl();
    @Override
    public int add(Student student) {
        return studentDao.addStu(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.updateStu(student);
    }

    @Override
    public int delete(String no) {
        return studentDao.deleteStu(no);
    }

    @Override
    public Student queryNo(String no) {
        return studentDao.queryByNo(no);
    }

    @Override
    public Student queryName(String name) {
        return studentDao.queryByName(name);
    }

    @Override
    public List<Student> sort() {
        return studentDao.sort();
    }

    @Override
    public List<Map<String, Object>> statistics() {
        return studentDao.statistics();
    }
}
