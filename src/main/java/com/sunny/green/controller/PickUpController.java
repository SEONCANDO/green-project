package com.sunny.green.controller;


import com.sunny.green.dao.PickupDao;
import com.sunny.green.vo.PickupAddressVo;
import com.sunny.green.vo.PickupInfoVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class PickUpController {


    PickupDao pickupDao;


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

    @GetMapping("/pickupSave")
    public String pickupSave(HttpSession session, Model model, PickupInfoVo piv) {
        PickupAddressVo pav1 = (PickupAddressVo) session.getAttribute("user");
        System.out.println(pav1.getUser_id());
        piv.setUser_id(pav1.getUser_id());
        if (pickupDao.pickupInfoSave(pav1) != 0
                && pickupDao.pickupInfoSave2(piv) != 0) {
            model.addAttribute("alert", "예약되었습니다");
        };

        return "/index";
    }

    @GetMapping("/pickup3")
    public String pickupPage3() {
        return "pickup/pickUp3";
    }

    @GetMapping("/reservationBd")
    public String reservationBd(HttpSession session, Model model) {

        if(session.getAttribute("user") == null){
            model.addAttribute("alert", "로그인을 해주시기 바랍니다.");
            model.addAttribute("url", "/login");
        }
        else{
            UserVo user = (UserVo) session.getAttribute("user");
            UserVo user1 = ud.selectAll1(user.getUser_id());
            System.out.println("번호는 뭘까요? : " + user1);
            model.addAttribute("user", user1);

            return "/myPage/reservationBd";
        }
        return "/alert";
    }

}
