package com.sunny.green.controller;

import com.sunny.green.dao.MailDao;
import com.sunny.green.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MailController {
    private final UserDao ud;

    private final MailDao md;


    @GetMapping("/mail/send")
    public String mail(){
        return null;
    }


}
