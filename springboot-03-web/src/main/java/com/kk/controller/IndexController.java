package com.kk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//在template目录下的所有页面，只能通过controller来跳转
@Controller
public class IndexController {
    public String index(){
        return "index";
    }
}
