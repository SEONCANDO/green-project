package com.sunny.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/pickup3")
    public String pickupPage3() {
        return "pickup/pickUp3";
    }
}
