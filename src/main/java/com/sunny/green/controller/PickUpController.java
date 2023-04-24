package com.sunny.green.controller;


import com.sunny.green.dao.PickupDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.PickupAddressVo;

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
            model.addAttribute("alert", "로그인을 먼저 해주세요");
            model.addAttribute("url", "/login");
            return "alert";
        }
    }

    // 예약 첫번째 페이지 입력값 전달
    @PostMapping("pickupSave.do")
    public void pickupSave(PickupAddressVo address, HttpSession session) {
//        session.setAttribute("address", address);
//        PickupAddressVo addressSave = (PickupAddressVo) session.getAttribute("address");
//        System.out.println(">>>>>>>>>>>>>>"+addressSave);
        int successVal = pickupDao.pickupAddressSave(address);
        if(successVal==1) {
            System.out.println(">>>>>>>>>>>>>>"+address.getPu_address_no());
        }
    }

//    @PostMapping("pickupSave.do")
//    public void pickupSave(@RequestParam PickupAddressVo pav, @RequestParam PickupInfoVo piv, HttpSession session, Model model) {
//        session.setAttribute("pav", pav);
//        session.setAttribute("piv", piv);
//        System.out.println("pav>>>>>>>>>>>>>"+pav);
//        System.out.println("piv>>>>>>>>>>>>>"+piv);

//        PickupAddressVo pav1 = (PickupAddressVo) session.getAttribute("user");
//        System.out.println("저장된 값 :" + pav1);
//        piv.setUser_id(pav1.getUser_id());
//        if (pickupDao.pickupAddressSave(pav1) != 0
//                && pickupDao.pickupInfoSave(piv) != 0) {
//            model.addAttribute("alert", "예약되었습니다");
//        };
//    }

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
    public String pickupSave(HttpSession session) {
        PickupAddressVo address = (PickupAddressVo) session.getAttribute("address");
        System.out.println(">>>>>>>>>>>>>>"+address);
        pickupDao.pickupAddressSave(address);

        System.out.println(">>>>>>>>>>>>>>"+pickupDao.pickupAddressSave(address));
        return "/index";
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
