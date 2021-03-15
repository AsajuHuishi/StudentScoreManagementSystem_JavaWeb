package indi.huishi.dao.impl;

import indi.huishi.dao.StudentDao;
import indi.huishi.pojo.Student;

import java.util.List;
import java.util.Map;

public class StudentDaoImpl extends BaseDao implements StudentDao{
    @Override
    public int addStu(Student student) {
        String sql = "insert into stu_score (no, name, score, className) values(?,?,?,?)";
        return update(sql,student.getNo(),student.getName(),student.getScore(),student.getClassName());
    }

    @Override
    public int updateStu(Student student) {
        String sql = "update stu_score set name=?, score=?, className=? where no=?";
        return update(sql,student.getName(),student.getScore(),student.getClassName(),student.getNo());
    }

    @Override
    public int deleteStu(String no) {
        String sql = "delete from stu_score where no=?";
        return update(sql, no);
    }

    @Override
    public Student queryByName(String name) {
        String sql = "select * from stu_score where name=?";
        return (Student)queryForOne(Student.class, sql, name);
    }

    @Override
    public Student queryByNo(String no) {
        String sql = "select * from stu_score where no=?";
        return (Student)queryForOne(Student.class, sql, no);
    }

    @Override
    public List<Student> sort() {
        String sql = "select * from stu_score order by score";
        return (List<Student>) queryForMulti(Student.class, sql);
    }

    @Override
    public List<Map<String, Object>> statistics() {
        String sql = "select className, count(*), max(score), min(score), round(avg(score),4) from stu_score group by className order by score desc";
        return queryForMapList(sql);
    }
}
