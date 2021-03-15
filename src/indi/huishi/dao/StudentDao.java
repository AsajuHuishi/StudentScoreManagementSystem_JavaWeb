package indi.huishi.dao;

import indi.huishi.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * 学生成绩管理系统 数据访问层
 */
public interface StudentDao {
    /**
     * 增加学生记录
     * @param student
     * @return
     */
    int addStu(Student student);

    /**
     * 修改学生记录
     * @param student
     * @return
     */
    int updateStu(Student student);

    /**
     * 按学号删除学生记录
     * @param no
     * @return
     */
    int deleteStu(String no);

    /**
     * 根据学生姓名查询
     * @param name
     * @return
     */
    Student queryByName(String name);

    /**
     * 根据学生id查询
     * @param no
     * @return
     */
    Student queryByNo(String no);

    /**
     * 按成绩排序
     * @return
     */
    List<Student> sort();

    /**
     * 统计(分班级统计学生数量,最高分,最低分,平均值)...
     * @return
     */
    List<Map<String,Object>> statistics();

}
