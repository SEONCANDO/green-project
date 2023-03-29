package com.sunny.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PickUpController {

    @GetMapping("/pickup")
    public String pickupPage() {
        return "pickup/pickUp";
    }
}
