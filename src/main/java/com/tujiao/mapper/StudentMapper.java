package com.tujiao.mapper;

import com.tujiao.pojo.Student;
import com.tujiao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    List<Student> queryStuList();

    Student queryStuById(int id);

    int addStu(Student stu);

    int updateStu(Student stu);

    int deleteStu(int id);
}