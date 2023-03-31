package com.sunny.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/board")
public class BoardController {
    @GetMapping("/board")
    public String index() {
        return "bbs/boardList";
    }
}
