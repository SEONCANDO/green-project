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
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

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
    @ResponseBody
    public void pickupPageSave(PickupAddressVo address, HttpSession session) {
        session.setAttribute("address", address);
        PickupAddressVo address2 = (PickupAddressVo) session.getAttribute("address");
    }
    @PostMapping("pickupSave2.do")
    @ResponseBody
    public void pickupPageSave(PickupInfoVo info, HttpSession session) {
        session.setAttribute("info", info);
        PickupInfoVo info2 = (PickupInfoVo) session.getAttribute("info");
    }
    //이미지 임시 저장
    @PostMapping("pickupImg.do")
    @ResponseBody
    public void pickupImg(@RequestParam("images") List<MultipartFile> files) {
        System.out.println(">>>>>>>>>>>>>>"+files);
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

    @GetMapping("pickupRealSave.do")
    @ResponseBody
    public void pickupRealSave(HttpSession session) {
        PickupAddressVo address = (PickupAddressVo) session.getAttribute("address");
        PickupInfoVo info = (PickupInfoVo) session.getAttribute("info");
        int successVal = pickupDao.pickupAddressSave(address);
        if(successVal==1) {
            int addressNo = address.getPu_address_no();
            info.setPu_address_no(addressNo);
            System.out.println("info>>>>>>>>>>>"+info);
            int successVal2 = pickupDao.pickupInfoSave(info);
            if(successVal2==1) {
                int infoNo = info.getPu_no();
                String imgVal = info.getPu_img();
                if(Objects.equals(imgVal, "Y")) {
                    System.out.println("성공>>>>>>>");
                }
            }
        }
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
