package com.tujiao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ManagerController {

    @RequestMapping("/personal_info")
    public String info() {
        return "manager/personal_info";
    }
}
