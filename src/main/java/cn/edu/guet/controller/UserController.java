package cn.edu.guet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login(){
        return "index";
    }
}
