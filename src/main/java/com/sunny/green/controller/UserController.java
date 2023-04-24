package com.sunny.green.controller;

import com.sunny.green.dao.UserDao;

import com.sunny.green.vo.AdminVo;
import com.sunny.green.vo.ExchangeVo;
import com.sunny.green.vo.MailVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserDao ud;

    //마이페이지 매핑
    @GetMapping("/myPage")
    public String myPage(){
        return "myPage/myPage";
    }

    //로그인 창에 들어갈때 쓰는 매핑
    @GetMapping("/login")
    public String login(HttpSession session, Model model){
        if(session.getAttribute("user") != null){
            model.addAttribute("alert",  "이미 로그인이 되어있는 상황입니다");
            model.addAttribute("url", "/index");
        }
        else {
            return "user/login";
        }
        return "alert";
    }

    //로그인 할 때 나타나는 post매핑
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
            model.addAttribute("alert", "아이디/비밀번호가 일치하지 않습니다");
            model.addAttribute("url", "/login");
        }

        return "/alert";
    }


    //회원가입 들어가는 매핑
    @GetMapping("/join")
    public String join(HttpSession session, Model model) {
        if (session.getAttribute("user") != null) {
            model.addAttribute("alert", "이미 로그인이 되어있는 상태입니다");
            model.addAttribute("url", "/index");
        }
        else{
            return "/user/join";
        }
        return "/alert";
    }

    //회원가입 기능
    @PostMapping("/join")
    public String join1(UserVo user, Model model, HttpSession session) {

        if (ud.joinUser(user) != 0) {
            AdminVo adminVo = new AdminVo();
            adminVo.setAdmin_id(user.getUser_id());
            adminVo.setAdmin_pass(user.getUser_pass());
            adminVo.setUser_id(user.getUser_id());
            adminVo.setUser_pass(user.getUser_pass());
            ad.insertAdmin(adminVo);
            model.addAttribute("alert", "회원가입이 완료되었습니다.");
            model.addAttribute("url", "/index");
            session.setAttribute("user", user);
        }
        return "/alert";
    }


    //로그아웃 기능
    @GetMapping("/logout")
    public String logout(HttpSession httpSession, Model mo){
        if(httpSession.getAttribute("user") == null ){
            mo.addAttribute("alert", "로그인 먼저 해주시기 바랍니다");
            mo.addAttribute("url", "/login");
        }
        else{
            httpSession.setAttribute("user", null);
            mo.addAttribute("alert", "로그아웃 하셨습니다");
            mo.addAttribute("url", "/index");
        }
        return "/alert";
    }

    //회원가입시 아이디 중복 체크
    @PostMapping("/checkDuplicateId")
    @ResponseBody
    public String checkDuplicateId(@RequestParam("user_id") String userid) {
        UserVo existingUser = ud.selectUserId(userid);
        if(existingUser != null) {
            return "exist";
        } else {
            return "not exist";
        }
    }

    // 마이페이지 개인정보 수정
    @GetMapping("/modify")
    public String modify(HttpSession session, Model model){
        if(session.getAttribute("user") == null){
            model.addAttribute("alert", "로그인을 해주시기 바랍니다.");
            model.addAttribute("url", "/login");
        }
        else{
            UserVo user = (UserVo) session.getAttribute("user");
            System.out.println("번호는 뭘까요? : " + user);
            model.addAttribute("user", user);
            return "/myPage/modify";
        }
        return "/alert";
    }

    @PostMapping("/modify")
    public String modify1(UserVo user, Model mo)  {
        int update = ud.updateUser(user);
        if (update == 1) {
            System.out.println(update);
            mo.addAttribute("alert", "정보가 수정되었습니다");
            mo.addAttribute("url", "/myPage");

        } else {
            mo.addAttribute("alert", "정보 수정값을 등록하는데 오류가 있습니다");
            mo.addAttribute("url", "/index");
        }
        return "alert";
    }

// 그린포인트 확인
    @GetMapping("/greenPoint")
    public String green() {
        return "/myPage/greenPoint";
    }

    @GetMapping("/delete")
    public String delete(HttpSession session, String user_id) {
        UserVo userDB = (UserVo) session.getAttribute("user");
        user_id = userDB.getUser_id();
        System.out.println(user_id);
        int delete = ud.deleteId(user_id);
        System.out.println(delete);
        session.setAttribute("user", null);
        return "redirect:/index";
    }


    @GetMapping("testGuest")
    public String user1(){
        for(int i = 100; i < 250; i++){
            UserVo user = UserVo.builder().user_id("test"+i).user_pass("1234").user_email("d@c.com").user_name("관리자"+i).user_tel("01012345678").build();
            ud.joinUser(user);
        }
        return "테스트 계정에 대한 내용";
    }

    @GetMapping("/info")
    public String info(){
        return "info";
    }

}
