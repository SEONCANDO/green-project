package com.sunny.green.controller;

import com.sunny.green.vo.PickupAddressVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PickUpController {

    @GetMapping("/pickup")
    public String pickupPage() {
        return "pickup/pickUp";
    }

    @GetMapping("/pickup2")
    public String pickupPage2() {
        return "pickup/pickUp2";
    }

    @PostMapping("/pickup2")
    public String pickup2(RequestParam user_id) {
        System.out.println("유저 id>>>>>>>>>>>"+user_id);

        return "user";
    }

    @GetMapping("/pickup3")
    public String pickupPage3() {
        return "pickup/pickUp3";
    }

    @GetMapping("/reservationBd")
    public String reservationBd() {
        return "/myPage/reservationBd";
    }
}
