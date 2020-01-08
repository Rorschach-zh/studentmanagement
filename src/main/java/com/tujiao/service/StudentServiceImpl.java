package com.tujiao.service;

import com.tujiao.mapper.StudentMapper;
import com.tujiao.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int querySize() {
        return querySize();
    }

    @Override
    public Student queryStuById(String studyid) {
        return studentMapper.queryStuById(studyid);
    }

    @Override
    public List<Student> queryStuByLimit(int startpage, int pageSize) {
        return studentMapper.queryStuByLimit(startpage, pageSize);
    }

    @Override
    public List<Student> queryStuList() {
        return studentMapper.queryStuList();
    }

    @Override
    public boolean addStu(Student student) {
        if (studentMapper.queryStuById(student.getStudyid()) == null) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy");
            int age = Integer.parseInt(sf.format(new Date())) -
                    Integer.parseInt(sf.format(student.getBirth()));
            student.setAge(age);
//            System.out.println(age);
            studentMapper.addStu(student);
            return true;
        } else
            return false;
    }

    @Override
    public int updateStu(Student stu) {
        return studentMapper.updateStu(stu);
    }

    @Override
    public int deleteStu(String studyid) {
        return studentMapper.deleteStu(studyid);
    }
}
