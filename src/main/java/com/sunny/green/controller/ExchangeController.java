package com.sunny.green.controller;

import com.sunny.green.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Random;

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

    @GetMapping("/exchange3")
    public String exchange3(HttpSession httpSession, Model mo){




        //        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // 예약번호로 사용할 문자열

//        int length = 8; // 예약번호의 길이
//        Random random = new Random();
//        StringBuilder reservationId = new StringBuilder();
//
//        for (int i = 0; i < length; i++) {
//            int index = random.nextInt(chars.length());
//            reservationId.append(chars.charAt(index));
//        }
//
//        mo.addAttribute("reservation", reservationId);
        return "/exchange/exchange3";
    }
}
