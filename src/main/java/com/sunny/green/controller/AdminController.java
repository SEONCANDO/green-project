package com.sunny.green.controller;

import com.sunny.green.dao.AdminDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.service.UserService;
import com.sunny.green.vo.ProImgVo;
import com.sunny.green.vo.ProductVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AdminController {


    private final UserDao ud;
    private final AdminDao ad;

    private UserService userService;


    @GetMapping("/admin")

    public String admin(){
        return "admin/admin_login";
    }

    @GetMapping("/admin/main")
    public String admin1() {

        return "admin/admin_main";
    }



    @GetMapping("/admin/reservation")
    public String adminRe() {
        return "/admin/admin_reservation";
    }

    @GetMapping("/admin/user1")
    public String adminUs1() {
        return "/admin/admin_user1";
    }

    //보영 (회원 목록 조회)
    @GetMapping("/admin/user2")

    public String getUserList(Model model) {

        List<UserVo> user = ud.selectAll();

        model.addAttribute("user", user);

        return "/admin/admin_user2";
    }
    // 보영 (회원정보상세)
    @GetMapping("/admin/modify")
    public String userDetail(Model model, UserVo userVo){
        UserVo user = ud.selectAll1(userVo.getUser_id());
        model.addAttribute("user", user);
        System.out.println(user);
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
    public String bbs1() {
        return "/admin/admin_bbs1";
    }

    @GetMapping("/admin/bbs2")
    public String bbs2() {
        return "/admin/admin_bbs2";
    }


    @GetMapping("admin/product1")
    public String pro1(Model mo) {
        List<ProductVo> product = ad.selectProAll();
        mo.addAttribute("product", product);
        return "/admin/admin_product1";
    }

    @GetMapping("admin/product2")
    public String pro2(Model mo, ProductVo vo, ProImgVo iv) {
        ProductVo product = ad.selectPro(vo.getPro_num());
        ProImgVo proImgVo = ad.selectImg(iv.getPro_num());
        mo.addAttribute("product", product);
        mo.addAttribute("proImgVo", proImgVo);
        return "/admin/admin_product2";
    }

    @GetMapping("admin/product3")
    public String pro3() {


        return "/admin/admin_product3";
    }

    @GetMapping("admin/deletePro")
    public String deletePro(int pro_num) {
        int otr = ad.deletePro_img(pro_num);
        int str = ad.deletePro(pro_num);
        return "redirect:/admin";
    }

    @GetMapping("admin/product4")
    public String pro5(ProductVo productVo, Model mo) {
        ProductVo pro = ad.selectPro(productVo.getPro_num());
        mo.addAttribute("pro", pro);
        return "/admin/admin_product4";
    }

    @PostMapping("/updatePro")
    public String pro6(ProductVo productVo) {
        int str = ad.updatePro(productVo);
        return "redirect:/admin/product1";
    }


    @Transactional
    @PostMapping("/product3")
    public String pro4(ProductVo productVo, @RequestParam("image") MultipartFile imageFile) {
        String fileName = imageFile.getOriginalFilename(); // 파일 이름 추출
        String uploadPath = "src/main/resources/static/img/product/"; // 업로드 디렉토리 경로
        String filePath = uploadPath + fileName; // 저장될 파일 경로
        String uuid = UUID.randomUUID().toString();
        String realPath = uploadPath + uuid + fileName;
        String saveFile = uuid + fileName;
        System.out.println(fileName);
        System.out.println(filePath);
        System.out.println(realPath);
        ad.insertPro(productVo);
        return "/admin/admin_product3";
    }
}