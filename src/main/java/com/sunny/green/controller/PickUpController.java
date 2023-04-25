package com.sunny.green.controller;


import com.sunny.green.dao.PickupDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.PickupAddressVo;

import com.sunny.green.vo.PickupInfoVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class PickUpController {

    private final PickupDao pickupDao;
    private final UserDao ud;

    // 예약 첫번째 페이징
    @GetMapping("/pickup")
    public String pickupPage(HttpSession session, Model model) {
        if(session.getAttribute("user") != null) {
            return "pickup/pickUp";
        } else {
            model.addAttribute("alert", "로그인이 필요한 페이지입니다.");
            model.addAttribute("url", "/login");
            return "alert";
        }
    }

    // 예약 첫번째 페이지 입력값 전달
    @PostMapping("pickupSave.do")
    public void pickupSave(PickupAddressVo address, PickupInfoVo info, HttpSession session) {
        session.setAttribute("address", address);
        session.setAttribute("info", info);
    }


    // 예약 두번째 페이징
    @GetMapping("/pickup2")
    public String pickupPage2() {

        return "pickup/pickUp2";
    }


    // 예약 세번째 페이징
    @GetMapping("/pickup3")
    public String pickupPage3() {
        return "pickup/pickUp3";
    }

    @GetMapping("/pickupSave")
    public String pickupSave2(HttpSession session) {
        PickupAddressVo address = (PickupAddressVo) session.getAttribute("address");
        PickupInfoVo info = (PickupInfoVo) session.getAttribute("info");
        int successVal = pickupDao.pickupAddressSave(address);
        if(successVal==1) {
            int addressNo = address.getPu_address_no();
            info.setPu_address_no(addressNo);
            int successVal2 = pickupDao.pickupInfoSave(info);
            if(successVal2==1) {

            }
        }
        return "/index";
    }

    @GetMapping("/reservationBd")
    public String reservationBd(HttpSession session, Model model) {

        if(session.getAttribute("user") == null){
            model.addAttribute("alert", "로그인이 필요한 페이지입니다.");
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
