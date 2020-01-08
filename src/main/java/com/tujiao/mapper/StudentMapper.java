package com.tujiao.mapper;

import com.tujiao.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentMapper {

    List<Student> queryStuList();

    List<Student> queryStuByLimit(int startPage, int pageSize);

    Student queryStuById(String studyid);

    int addStu(Student stu);

    int updateStu(Student stu);

    int deleteStu(String studyid);

    int querySize();
}