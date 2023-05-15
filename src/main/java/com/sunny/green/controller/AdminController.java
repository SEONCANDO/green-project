package com.sunny.green.controller;

import com.sunny.green.dao.*;
import com.sunny.green.service.AdminService;
import com.sunny.green.service.ProductService;
import com.sunny.green.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class AdminController {

    private final UserDao ud;
    private final AdminDao ad;
    private final PickupDao pd;
    private final NoticeDao nd;
    private final BbsDao bd;
    private final AdminService as;
    private final ProductService ps;


    //관리자 페이지
    @GetMapping("/admin")
    public String admin() {
        return "admin/admin_login";
    }

    // 관리자용 로그인 방법
    @PostMapping("/admin")
    public String admin2(AdminVo av, Model mo, HttpSession session) {
        AdminVo adminVo = as.selectAdmin(av);
        if (adminVo != null) {
            if (adminVo.getAdmin_role() == 1) {
                mo.addAttribute("alert", "관리자용 로그인에 성공했습니다.");
                mo.addAttribute("url", "/admin/main");
                session.setAttribute("admin", adminVo);
                log.info(session.getAttribute("user"));
            } else {
                mo.addAttribute("alert", "아이디/비밀번호가 일치하지 않습니다.");
                mo.addAttribute("url", "/admin");
            }
            return "alert";
        } else {
            mo.addAttribute("alert", "관리자용 아이디가 존재하지 않습니다.");
            mo.addAttribute("url", "/index");
        }
        return "alert";
    }

    //관리자페이지 메인
    @GetMapping("/admin/main")
    public String admin1() {

        return "admin/admin_main";
    }

    @GetMapping("/admin/services1")
    public String adminServices1(Model model, PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) throws Exception{
        List<PickupDetailVo> service;
        if (searchType == null || searchValue == null) {
            service = pd.rs_service1();
        } else {
            service = pd.rs_service2(search, searchType , searchValue);
        }
        model.addAttribute("service", service);
        return "admin/admin_services1";
    }

    //관리자페이지 유저검색 & 페이징
    @PostMapping("/paging_service1")
    @ResponseBody
    public List<PickupDetailVo> getServiceData(PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) {
        List<PickupDetailVo> service;
        if (searchType == null || searchValue == null) {
            service = pd.rs_service1();
        } else {
            service = pd.rs_service2(search, searchType, searchValue);
        }
        log.info(">>>>>>>>>>>>>"+service);
        return service;
    }

    //해당 업체 예약 정보 전달
    @GetMapping("/admin/services2")
    public String adminServices2(){
        return "admin/admin_services2";
    }


   //관리자 페이지 유저관리1
    @GetMapping("/admin/user1")
    public String adminUs1() {
        return "admin/admin_user1";
    }

    //관리자페이지 유저관리2
    @GetMapping("/admin/user2")
    public String getUserList(Model model, PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) throws Exception {
        List<UserVo> user;
        if (searchType == null || searchValue == null) {
            user = ud.selectAll();
        } else {
            user = ud.selectAll2(search, searchType, searchValue);
        }
        model.addAttribute("user", user);
        return "admin/admin_user2";
    }

    //관리자페이지 유저검색 & 페이징
    @PostMapping("/pagination")
    @ResponseBody
    public List<UserVo> getUserData(PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) {
        List<UserVo> user;
        if (searchType == null || searchValue == null) {
            user = ud.selectAll();
        } else {
            user = ud.selectAll2(search, searchType, searchValue);
        }
        log.info(">>>>>>>>>>>>>"+user);
        return user;
    }

    // 보영 (회원정보상세)
    @GetMapping("/admin/modify")
    public String userDetail(Model model, UserVo userVo) {
        UserVo user = ud.selectAll1(userVo.getUser_id());
        model.addAttribute("user", user);
        log.info(user);
        return "admin/admin_user3";
    }

    // 보영 (회원정보수정)
    @PostMapping("/admin/modify")
    public String adminModify(UserVo user, Model model) {
        int update = as.updateUser(user);
        log.info(update);
        model.addAttribute("alert", "수정되었습니다");
        model.addAttribute("url", "/admin/user2");

        return "alert";
    }


    // 어드민 페이지 유저관리 아이디 삭제
    @GetMapping("admin/delete")
    public String deleteUser(@RequestParam("user_id") String user_id) {
        log.info("번호 :" + user_id);
        int deleteUser = ud.deleteId(user_id);
        log.info(deleteUser);
        return "redirect:user2";
    }

    // 어드민 페이지 상품 등록1
    @GetMapping("admin/product1")
    public String pro1(Model mo) {
        List<ProductVo> product = ad.selectProAll();
        mo.addAttribute("product", product);
        return "admin/admin_product1";
    }

    // 어드민 페이지 상품 등록2
    @GetMapping("admin/product2")
    public String pro2(Model mo, ProductVo vo, ProImgVo iv) {
        ProductVo product = ad.selectPro(vo.getPro_num());
        ProImgVo proImgVo = ad.selectImg(iv.getPro_num());
        mo.addAttribute("product", product);
        mo.addAttribute("proImgVo", proImgVo);
        return "admin/admin_product2";
    }

    // 어드민 페이지 상품등록3
    @GetMapping("admin/product3")
    public String pro3() {


        return "admin/admin_product3";
    }

    // 어드민 페이지 상품 삭제
    @GetMapping("admin/deletePro")
    public String deletePro(int pro_num) {
        int otr = ad.deletePro_img(pro_num);
        int str = ad.deletePro(pro_num);
        return "redirect:admin";
    }

    //어드민 페이지 상품 등록 확인
    @GetMapping("admin/product4")
    public String pro5(ProductVo productVo, Model mo) {
        ProductVo pro = ad.selectPro(productVo.getPro_num());
        mo.addAttribute("pro", pro);
        return "admin/admin_product4";
    }

    //어드민 페이지 상품등록 업데이트
    @PostMapping("/updatePro")
    public String pro6(ProductVo productVo) {
        int str = as.updatePro(productVo);
        return "redirect:admin/product1";
    }


    //어드민 페이지 상품 등록
    @PostMapping("/product3")
    public String registerProduct(ProductVo productVo, @RequestParam("image") MultipartFile imageFile) throws IOException {
        ps.registerProduct(productVo, imageFile);
        return "redirect:admin";
    }
//   ---------------------------------- rs

    // 게시판_검색 및 데이터 불러오기
    @GetMapping("/admin/bbs1")
    public String getNoticeList(Model model, PageVo search ,@RequestParam(required = false) String searchType ,@RequestParam(required = false) String searchValue) throws Exception {
        List<NoticeVo> noticeVos;
        if (searchType == null || searchValue == null) {
            noticeVos = nd.selectAllNotice();
            log.info(noticeVos);
        } else {
            noticeVos = nd.searchNotice(search, searchType, searchValue);
            log.info(noticeVos);
        }
        model.addAttribute("noticeVos", noticeVos);
        return "admin/admin_bbs1";
    }


    // 공지사항 페이징 & 검색
    @PostMapping("/pagination_notice_page")
    @ResponseBody
    public List<NoticeVo> getNoticeInfo(PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) {
        List<NoticeVo> noticeVos;
        if (searchType == null || searchValue == null) {
            noticeVos = nd.selectAllNotice();

        } else {
            noticeVos = nd.searchNotice(search, searchType, searchValue);
            log.info(noticeVos);
        }
        log.info(">>>>>>>>>>>>>"+noticeVos);
        return noticeVos;
    }

    // QNA_검색 및 데이터 불러오기
    @GetMapping("/admin/bbs2")
    public String getBbsList(Model model, PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) throws Exception {
        List<BbsVo> bbsVos;
        if (searchType == null || searchValue == null) {
            bbsVos = bd.selectAllBoard();
            log.info(bbsVos);
        } else {
            bbsVos = bd.searchBoard(search, searchType, searchValue);
            log.info(bbsVos);
        }
        model.addAttribute("bbsVos", bbsVos);
        return "admin/admin_bbs2";
    }

    // QNA_페잉징
    @PostMapping("/pagination_board_page")
    @ResponseBody
    public List<BbsVo> getBbsInfo(PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) {
        List<BbsVo> bbsVos;
        if (searchType == null || searchValue == null) {
            bbsVos = bd.selectAllBoard();
            log.info(bbsVos);

        } else {
            bbsVos = bd.searchBoard(search, searchType, searchValue);
            log.info(bbsVos);

        }
        return bbsVos;
    }

    // 예약_검색 및 데이터 불러오기
    @GetMapping("/admin/reservation")
    public String getPickupList(Model model, PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) throws Exception {
        List<PickupDetailVo> pickup;
        if (searchType == null || searchValue == null) {
            pickup = pd.rsList();
            log.info(pickup);
        } else {
            pickup = pd.rsList2(search, searchType, searchValue);
            log.info(pickup);
        }
        model.addAttribute("pickup", pickup);
        return "admin/admin_reservation";
    }
    // 예약_페이징
    @PostMapping("/pagination_rsPage")
    @ResponseBody
    public List<PickupDetailVo> getPickupInfo(PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) {
        List<PickupDetailVo> pickup;
        if (searchType == null || searchValue == null) {
            pickup = pd.rsList();

        } else {
            pickup = pd.rsList2(search, searchType, searchValue);

        }
        log.info(">>>>>>>>>>>>>"+pickup);
        return pickup;
    }

    // 예약정보상세
    @GetMapping("/rs_info")
    public String rsDetail(Model model, PickupDetailVo  pickupDetailVo ) {
        PickupDetailVo rs_info = pd.pu_information(pickupDetailVo.getPu_no());
        model.addAttribute("rs_info", rs_info);
        log.info("인포메이션"+rs_info);
        return "admin/admin_rs_info";
    }

    // 예약정보 변경
    @PostMapping("/rs_information")
    public String rsUpdate(PickupDetailVo pickupDetailVo){
        int result = pd.update_info(pickupDetailVo);
        log.info("변경됨?"+result);
        return "redirect:admin/reservation";
    }

    // 업로드된 상품 이미지 restful api로 불러오기
    @GetMapping("/img/product/{img_save_name}")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable("img_save_name") String imgSaveName) throws IOException {
        Resource resource = new FileSystemResource("/home/ubuntu/greentopia2/img/product/" + imgSaveName);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
    }

}


