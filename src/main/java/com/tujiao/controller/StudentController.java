package com.tujiao.controller;

import com.tujiao.mapper.StudentMapper;
import com.tujiao.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentMapper stuMapper;

    @RequestMapping("/stus")
    public String GetUser(Model model){
        List<Student> stus = stuMapper.queryStuList();
        model.addAttribute("stus",stus);
        return "student/stulist";
    }

    @RequestMapping("/addstu")
    public String addstu(){
        return "student/addstu";
    }

    @PostMapping("/stu")
    public String addStu(Student student){
        System.out.println(student);
        Map<String,Object> map = new HashMap<>();
        stuMapper.addStu(student);
        return "redirect:/stus";
    }

    @GetMapping("/deleteStu/{studyid}")
    public String deleteStu(@PathVariable("studyid") int studyid){
        stuMapper.deleteStu(studyid);
        return "redirect:/stus";
    }
}
