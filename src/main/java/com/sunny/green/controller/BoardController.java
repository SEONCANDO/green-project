package com.sunny.green.controller;

import com.sunny.green.dao.BbsDao;
import com.sunny.green.vo.BbsVo;
import com.sunny.green.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    private final BbsDao bd;

    private final UserDao ud;

    private final ExchangeDao ed;

    private final AdminDao ad;

    @GetMapping("/board") // Q&A 목록
    public String index(Model model) {
        List<BbsVo> bbsVoList = bd.selectBoardAll();
        model.addAttribute("bbsVoList", bbsVoList);

        return "bbs/boardList";
    }

    @GetMapping("/post") // Q&A 글작성 폼
    public String post(UserVo user, HttpSession session, Model model) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        model.addAttribute("user", userVo);
        System.out.println("밸류값" + userVo);
        return "bbs/post";
    }


    @PostMapping("/post") // Q&A 글작성
    public String post1(@ModelAttribute BbsVo bbsVo, HttpSession session) {
        int insertResult = bd.insertBoard(bbsVo);
        if (insertResult > 0) {           // 성공으로 판단되면 목록으로 돌아가기.
            return "redirect:/board/";
        } else {                          // 실패하면 글작성 페이지에 머무름.
            return "bbs/post";
        }
    }

    @GetMapping("/boardDetail")
    public String boardDetail(Model model, BbsVo bbsVo) {
        List<BbsVo> boardNum = bd.selectBoardNum();
        model.addAttribute("boardNum", boardNum);
        return "bbs/boardDetail";
    }

    @GetMapping("/updateBoard")
    public String updateBoard(BbsVo bbsVo, Model model) {
        bd.updateBoard(bbsVo);
        List<BbsVo> board = bd.selectBoardAll();
        model.addAttribute("board", board);
        return "bbs/boardUpdate";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(BbsVo bbsVo) {
        bd.deleteBoard(bbsVo);
        return "redirect:bbs/board";
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

