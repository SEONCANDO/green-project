package com.sunny.green.controller;

import com.sunny.green.dao.PickupDao;
import com.sunny.green.vo.PickupAddressVo;
import com.sunny.green.vo.PickupInfoVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class PickUpController {

    @GetMapping("/pickup")
    public String pickupPage(HttpSession session, Model model) {
        if(session.getAttribute("user") != null) {
            return "pickup/pickUp";
        } else {
            model.addAttribute("alert", "로그인을 먼저 해주세요");
            model.addAttribute("url", "/login");
            return "alert";
        }
    }

    @GetMapping("/pickup2")
    public String pickupPage2() {
        return "pickup/pickUp2";
    }

    @PostMapping("pickupSave.do")
    public void pickupSave(HttpSession session,
            @RequestParam("user_id")String user_id, @RequestParam("pu_name")String pu_name, @RequestParam("pu_tel")String pu_tel,
            @RequestParam("pu_zip")int pu_zip, @RequestParam("pu_address1")String pu_address1, @RequestParam("pu_address2")String pu_address2,
            @RequestParam("pu_address3")String pu_address3, @RequestParam("pu_address4")String pu_address4, @RequestParam("house_no")int house_no,
            @RequestParam("pu_elevator")String pu_elevator, @RequestParam("pu_day")String pu_day, @RequestParam("pu_img")String pu_img,
            @RequestParam("text_memo")String text_memo) {

        session.setAttribute("user_id", user_id);
        session.setAttribute("pu_name", pu_name);
        session.setAttribute("pu_tel", pu_tel);
        session.setAttribute("pu_zip", pu_zip);
        session.setAttribute("pu_address1", pu_address1);
        session.setAttribute("pu_address2", pu_address2);
        session.setAttribute("pu_address3", pu_address3);
        session.setAttribute("pu_address4", pu_address4);
        session.setAttribute("house_no", house_no);
        session.setAttribute("pu_elevator", pu_elevator);
        session.setAttribute("pu_day", pu_day);
        session.setAttribute("pu_img", pu_img);
        session.setAttribute("text_memo", text_memo);

        String userid = (String) session.getAttribute(user_id);
        System.out.println(userid);
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
