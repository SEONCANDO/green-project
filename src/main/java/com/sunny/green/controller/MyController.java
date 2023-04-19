package com.sunny.green.controller;

import com.sunny.green.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/index")
    public String index1() {
        return "/index";
    }


}
