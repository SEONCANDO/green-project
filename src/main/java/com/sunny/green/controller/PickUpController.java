package com.sunny.green.controller;

import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.PickupSaveVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class PickUpController {

    private final UserDao ud;
    PickupSaveVo pickupSaveVo = new PickupSaveVo();

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

    @GetMapping("/pickup2")
    public String pickupPage2() {
        return "pickup/pickUp2";
    }

    @PostMapping("pickupSave.do")
    public void pickupSave(
            @RequestParam("user_id")String user_id, @RequestParam("pu_name")String pu_name, @RequestParam("pu_tel")String pu_tel,
            @RequestParam("pu_zip")int pu_zip, @RequestParam("pu_address1")String pu_address1, @RequestParam("pu_address2")String pu_address2,
            @RequestParam("pu_address3")String pu_address3, @RequestParam("pu_address4")String pu_address4, @RequestParam("house_no")int house_no,
            @RequestParam("pu_elevator")String pu_elevator, @RequestParam("pu_day")String pu_day, @RequestParam("pu_img")String pu_img,
            @RequestParam("text_memo")String text_memo) {
        System.out.println(user_id);
        pickupSaveVo.setUser_id(user_id);
        pickupSaveVo.setPu_name(pu_name);
        pickupSaveVo.setPu_tel(pu_tel);
        pickupSaveVo.setPu_zip(pu_zip);
        pickupSaveVo.setPu_address1(pu_address1);
        pickupSaveVo.setPu_address2(pu_address2);
        pickupSaveVo.setPu_address3(pu_address3);
        pickupSaveVo.setPu_address4(pu_address4);
        pickupSaveVo.setHouse_no(house_no);
        pickupSaveVo.setPu_elevator(pu_elevator);
        pickupSaveVo.setPu_day(pu_day);
        pickupSaveVo.setPu_img(pu_img);
        pickupSaveVo.setText_memo(text_memo);

        System.out.println(pickupSaveVo);
    }

    @GetMapping("/pickup3")
    public String pickupPage3() {
        return "pickup/pickUp3";
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
