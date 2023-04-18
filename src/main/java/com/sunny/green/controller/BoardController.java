package com.sunny.green.controller;

import com.sunny.green.dao.AdminDao;
import com.sunny.green.dao.ExchangeDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final UserDao ud;

    private final ExchangeDao ed;

    private final AdminDao ad;

    @GetMapping("/board") //Q&A
    public String index() {
        return "bbs/boardList";
    }

    @GetMapping("/post") //Q&A글쓰기
    public String post() {
        return "bbs/post";
    }


    @GetMapping("/myWrite")
    public String myWrite(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            model.addAttribute("alert", "로그인을 해주시기 바랍니다.");
            model.addAttribute("url", "/login");
        } else {
            UserVo user = (UserVo) session.getAttribute("user");
            UserVo user1 = ud.selectAll1(user.getUser_id());
            System.out.println("번호는 뭘까요? : " + user1);
            model.addAttribute("user", user1);

            return "/myPage/myWrite";
        }
        return "/alert";
    }

    @GetMapping("/myComment")
    public String myComment(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            model.addAttribute("alert", "로그인을 해주시기 바랍니다.");
            model.addAttribute("url", "/login");
        } else {
            UserVo user = (UserVo) session.getAttribute("user");
            UserVo user1 = ud.selectAll1(user.getUser_id());
            System.out.println("번호는 뭘까요? : " + user1);
            model.addAttribute("user", user1);

            return "/myPage/myComment";
        }
        return "/alert";
    }
}
