package com.sunny.green.controller;

import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class AdminController {

     private final UserDao ud;
    //보영
//    private UserService userService;

    //보영
//    public AdminController(UserService userService){
//        this.userService = userService;
//    }


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

    //보영(회원조회)
    @GetMapping("/admin/user2")
    public String getUserList(Model model){

        List<UserVo> userVoList = ud.selectAll();

        model.addAttribute("userVoList",userVoList);

        return "/admin/admin_user2";
    }
  //보영(회원정보수정페이지)
    @RequestMapping("/admin/userDetail")
        public String userUpdate(){
        return"/admin/admin_user3";
    }

    //보영(회원정보수정)
    @RequestMapping("/updateUser")
    public String updateUser(UserVo user){
        ud.updateUser(user);
        return "redirect:/admin_user2";
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
