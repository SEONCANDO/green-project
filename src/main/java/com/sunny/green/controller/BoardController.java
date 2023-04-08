package com.sunny.green.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("/board") //Q&A
    public String index() {
        return "bbs/boardList";
    }

    @GetMapping("/post") //Q&A글쓰기
    public String post() {
        return "bbs/post";
    }


    @GetMapping("/myWrite")
    public String myWrite(){
        return "/myPage/myWrite";
    }

    @GetMapping("/myComment")
    public String myComment(){
        return "/myPage/myComment";
    }
}
