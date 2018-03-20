package com.germaine.recureRobot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String login() {
        return "index";
    }

    @RequestMapping("/index")
    public String loginToIndex() {
        return "index";
    }
}
