package com.sunny.green.controller;

import com.sunny.green.dao.AdminDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.service.UserService;
import com.sunny.green.vo.ProductVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    private UserService userService;


    private final UserDao ud;
    private final AdminDao ad;


    @GetMapping("/admin")
    public String admin1(){
        return "admin/admin_main";
    }

    @GetMapping("/admin/reservation")
    public String adminRe() {
        return "/admin/admin_reservation";
    }

    @GetMapping("/admin/user1")
    public String adminUs1(){
        return "/admin/admin_user1";
    }

    //보영 (회원 목록 조회)
    @GetMapping("/admin/user2")
    public String getUserList(Model model){
        List<UserVo> user = ud.selectAll();
        model.addAttribute("user",user);
        return "/admin/admin_user2";
    }
    // 보영 (회원정보상세)
    @GetMapping("/admin/modify/{user_id}")
    public String userDetail(Model model,@PathVariable("user_id") String user_id){
        UserVo user = userService.getUserInfo(user_id);
        model.addAttribute("user", user);
        return "admin/admin_user3";
    }
    // 보영 (회원정보수정)
    @PostMapping("/admin/modify")
    public String adminModify(UserVo user, Model model){
        int update = ud.updateUser(user);
        System.out.println(update);
        model.addAttribute("alert","수정되었습니다");
        model.addAttribute("url","/admin/user2");

        return "alert";
    }

//    @GetMapping("/admin/delete")
//    public String deleteUser(HttpSession session, String user_id){
//        UserVo userDB = (UserVo) session.getAttribute("user");
//        user_id = userDB.getUser_id();
//        System.out.println(user_id);
//        int delete = ud.deleteId(user_id);
//        System.out.println(delete);
//        session.setAttribute("user", null);
//        return "redirect:/index";
//    }



    @GetMapping("/admin/bbs1")
    public String bbs1(){
        return "/admin/admin_bbs1";
    }

    @GetMapping("/admin/bbs2")
    public String bbs2(){
        return "/admin/admin_bbs2";
    }

    @GetMapping("/admin/product1")
    public String pro1(){
        return "/admin/admin_product1";
    }

    @GetMapping("/admin/product2")
    public String pro2(){
        return "/admin/admin_product2";
    }

    @GetMapping("/admin/product3")
    public String pro3(){


        return "/admin/admin_product3";
    }

    @PostMapping("/product3")
    public String pro4(ProductVo productVo){

        ad.insertPro(productVo);
        return "/admin/admin_product3";
    }
}