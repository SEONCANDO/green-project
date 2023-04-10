package com.sunny.green.controller;

import com.sunny.green.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ExchangeController {

    private final UserDao ud;

    @GetMapping("/exchange")
    public String exchange1(){
        return "/exchange/exchange1";
    }
}
