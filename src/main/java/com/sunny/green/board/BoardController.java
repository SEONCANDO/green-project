package com.sunny.green.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/board")
public class BoardController {
    @GetMapping("/board")
    public String index() {
        return "board/list";
    }
}
