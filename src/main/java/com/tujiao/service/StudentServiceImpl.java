package com.tujiao.service;

import com.tujiao.mapper.StudentMapper;
import com.tujiao.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean addStu(Student student) {
        if (studentMapper.queryStuById(student.getStudyid()) == null) {
            studentMapper.addStu(student);
            return true;
        } else
            return false;
    }
}
