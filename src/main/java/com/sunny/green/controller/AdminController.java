package com.sunny.green.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("/admin")
    public String admin1(){
    return "admin/admin_main";
    }

    @GetMapping("/admin/reservation")
    public String adminRe() {
        return "/admin/admin_reservation";
    }

    @GetMapping("/admin/user1")
    public String adminUs1(){
        return "/admin/admin_user1";
    }

    @GetMapping("/admin/user2")
    public String adminUs2(){
        return "/admin/admin_user2";
    }

    @GetMapping("/admin/bbs1")
    public String bbs1(){
        return "/admin/admin_bbs1";
    }

    @GetMapping("/admin/bbs2")
    public String bbs2(){
        return "/admin/admin_bbs2";
    }
}
