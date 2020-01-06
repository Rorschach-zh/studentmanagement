package com.tujiao.controller;

import com.tujiao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String login(HttpSession session){
        session.invalidate();

        return "login";
    }

    @RequestMapping("/loginCheck")
    public String loginCheck(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){

        if(username!=null&&password!=null) {

            if (userMapper.userlogin(username, password) != null){
                session.setAttribute("loginUser",username);
                System.out.println(username);
                return "/index";
            }
            }

            model.addAttribute("msg", "用户名或者密码错误！");
        return "/login";
    }
}
