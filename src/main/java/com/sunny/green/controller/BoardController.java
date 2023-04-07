package com.sunny.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board") //Q&A
    public String index() {
        return "bbs/boardList";
    }

    @GetMapping("/post") //Q&A글쓰기
    public String post() {
        return "bbs/post";
    }

}
