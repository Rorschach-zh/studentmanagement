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

    @RequestMapping("/addstu")
    public String addstu(){
        return "student/addstu";
    }

    @PostMapping("/stu")
    public String addStu(Student student){
        System.out.println(student);
        stuMapper.addStu(student);
        return "redirect:/stus";
    }

    @GetMapping("/deleteStu/{studyid}")
    public String deleteStu(@PathVariable("studyid") String studyid) {
        stuMapper.deleteStu(studyid);
        return "redirect:/stus";
    }
}
