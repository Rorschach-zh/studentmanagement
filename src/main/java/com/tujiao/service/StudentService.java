package com.tujiao.service;

import com.tujiao.pojo.Student;

import java.util.List;

public interface StudentService {

    int querySize();

    Student queryStuById(String studyid);

    List<Student> queryStuByLimit(int startpage, int pageSize);

    List<Student> queryStuList();

    boolean addStu(Student student);

    int updateStu(Student stu);

    int deleteStu(String studyid);
}
