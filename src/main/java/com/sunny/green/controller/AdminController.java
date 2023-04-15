package com.sunny.green.controller;

import com.sunny.green.dao.AdminDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.ProImgVo;
import com.sunny.green.vo.ProductVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AdminController {

     private final UserDao ud;
     private final AdminDao ad;
    //보영
//    private UserService userService;

    //보영
//    public AdminController(UserService userService){
//        this.userService = userService;
//    }


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

    //보영
    @GetMapping("/admin/user2")
    public String getUserList(Model model){

        List<UserVo> userVoList = ud.selectAll();

        model.addAttribute("userVoList",userVoList);

        return "/admin/admin_user2";
    }

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

    @Transactional
    @PostMapping("/product3")
    public String pro4(ProductVo productVo, @RequestParam("image") MultipartFile imageFile){
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
        String str = String.valueOf(productVo);
        System.out.println(str);

        try (OutputStream os = new FileOutputStream(realPath)) {
            os.write(imageFile.getBytes());

            ProImgVo proImgVo = ProImgVo.builder()
                    .pro_num(productVo.getPro_num())
                    .pro_img_save_name(saveFile)
                    .pro_img_path(realPath)
                    .build();
            ad.insertProImg(proImgVo);
        } catch (IOException e) {
            // 파일 저장 실패 시 예외 처리
            e.printStackTrace();
        }
        return "redirect:/index";
    }
}
