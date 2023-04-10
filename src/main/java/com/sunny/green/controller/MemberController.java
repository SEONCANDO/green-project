package com.sunny.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/memberList")
    public String memberList(){
        return "member/memberList";
    }

    @GetMapping("/member")
    public String member(){
        return "memberdetail";
    }
}
