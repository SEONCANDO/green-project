package com.sunny.green.controller;

import com.sunny.green.dao.AdminDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class ExchangeController {
    private final AdminDao ad;
    private final UserDao ud;

    @GetMapping("/exchange")
    public String exchange1(HttpSession session, Model mo){
        if(session.getAttribute("user") == null){
            mo.addAttribute("alert", "로그인을 먼저 해주시기 바랍니다");
            mo.addAttribute("url", "/login");
        }
        else{
            return "/exchange/exchange1";
        }
        return "/alert";
    }

    @GetMapping("/exchange2")
    public String exchange(HttpSession httpSession, Model mo, int pro_num){
        ProductVo pro = ad.selectPro(pro_num);
        mo.addAttribute("pro", pro);
        System.out.println(pro);
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
