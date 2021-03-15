package indi.huishi.service;


import indi.huishi.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public int add(Student student);

    public int update(Student student);

    public int delete(String no);

    public Student queryNo(String no);

    public Student queryName(String name);

    public List<Student> sort();

    public List<Map<String,Object>> statistics();
}
