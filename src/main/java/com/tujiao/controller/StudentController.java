package com.tujiao.controller;

import com.tujiao.mapper.StudentMapper;
import com.tujiao.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentMapper stuMapper;

    @RequestMapping("/stus")
    public String GetUser(Model model){
        List<Student> stus = stuMapper.queryStuList();
        model.addAttribute("stus",stus);
        return "student/students_list";
    }

    @PostMapping("/stu")
    public String addStu(Student student) {
//        System.out.println(student);
        stuMapper.addStu(student);
        return "redirect:/stus";
    }

    //跳转到修改页面 (链结形式-getmapping)
    @GetMapping("/updateStu/{studyid}")
    public String addstu(@PathVariable("studyid") String studyid, Model model) {
//        查出原来的数据
        Student student = stuMapper.queryStuById(studyid);
        model.addAttribute("stu", student);
        return "student/student_update";
    }

    @PostMapping("/updateStu")
    public String updateStu(Student student) {
        stuMapper.updateStu(student);
        return "redirect:/stus";
    }


    @GetMapping("/deleteStu/{studyid}")
    public String deleteStu(@PathVariable("studyid") String studyid) {
        stuMapper.deleteStu(studyid);
        return "redirect:/stus";
    }
}
