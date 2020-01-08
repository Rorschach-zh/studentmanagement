package com.tujiao;

import com.tujiao.mapper.StudentMapper;
import com.tujiao.pojo.Student;
import com.tujiao.service.StudentService;
import com.tujiao.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    StudentService services;

    @Test
    void contextLoads() {
        Student student = new Student();
        student.setStudyid("1712120444");
        student.setName("zgr");
        student.setSex(1);
        student.setAge(20);
        student.setBirth(Date.valueOf("2020-01-07"));
        student.setPhone("124123");
        student.setAddress("1213");

        if (services.addStu(student))
            System.out.println("true");
        else
            System.out.println("false");
    }

    @Autowired
    StudentMapper mapper;

    @Test
    void testLimit() {
        final int PAGESIZE = 8;
        List<Student> students = mapper.queryStuByLimit(0, 8);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    void testsize() {
        System.out.println(services.querySize());
    }
}
