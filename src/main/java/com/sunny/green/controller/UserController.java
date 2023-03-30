package com.sunny.green.controller;

import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserDao ud;

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @PostMapping("/login")
    public String login1(UserVo user, HttpSession session, Model model){
        UserVo userDB = ud.selectUser(user);
        System.out.println(userDB);

        if(userDB != null){
            System.out.println(userDB);
            session.setAttribute("user", userDB);
            model.addAttribute("alert", "로그인이 성공했습니다");
            model.addAttribute("url", "/index");
        } else {
            System.out.println("실패했습니다");
            model.addAttribute("alert", "로그인에 실패했습니다");
            model.addAttribute("url", "/login");
        }
        return "/alert";
    }


    @GetMapping("/join")
    public String join(){
        return "/user/join";
    }

    @PostMapping("/join")
    public String join1(UserVo user){
        ud.joinUser(user);
        return "/index";
    }

    @PostMapping("/checkDuplicateId")
    @ResponseBody
    public String checkDuplicateId(@RequestParam("userId") String userId) {
        UserVo existingUser = ud.selectUserId(userId);
        if(existingUser != null) {
            return "exist";
        } else {
            return "not exist";
        }
    }
}
