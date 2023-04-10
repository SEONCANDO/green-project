package com.sunny.green.controller;

import com.sunny.green.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ExchangeController {

    private final UserDao ud;

    @GetMapping("/exchange")
    public String exchange1(){
        return "/exchange/exchange1";
    }

    @GetMapping("/exchange2")
    public String exchange(HttpSession httpSession, Model mo){

        return "/exchange/exchange2";
    }
}
