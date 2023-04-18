package com.sunny.green.controller;

import com.sunny.green.dao.BbsDao;
import com.sunny.green.vo.BbsVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class BoardController {
    private final BbsDao bd;

    public BoardController(BbsDao bd) {
        this.bd = bd;
    }

    @GetMapping("/board") // Q&A 목록
    public String index(Model model) {
        List<BbsVo> bbsVoList = bd.selectBoardAll();
        model.addAttribute("bbsVoList", bbsVoList);
        return "bbs/boardList";
    }

    @GetMapping ("/post") // Q&A 글작성 폼
    public String post(HttpSession session, Model model) {
        return "bbs/post";
    }

    @PostMapping("/post") // Q&A 글작성
    public String post1(@ModelAttribute BbsVo bbsVo, HttpSession session) {
        int insertResult = bd.insertBoard(bbsVo);

        if (insertResult > 0) { // 성공으로 판단되면 목록으로 돌아가기.
            return "redirect:/board/";
        } else { // 실패하면 글작성 페이지에 머무름.
            return "bbs/post";
        }
    }





}
