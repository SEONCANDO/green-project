package com.sunny.green.controller;

import com.sunny.green.dao.NoticeDao;
import com.sunny.green.vo.NoticeVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeDao nd;

    //공지사항 목록
    @GetMapping("/notice")
    public String index(Model model) {
        List<NoticeVo> notice = nd.selectNoticeAll();
        model.addAttribute("notice", notice);
        return "bbs/noticeList";
    }

    // 공지사항 글작성 폼
    @GetMapping("/noticePost")
    public String noticePost(UserVo user, HttpSession session, Model model) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        model.addAttribute("user", userVo);
        System.out.println("밸류값" + userVo);
        return "/bbs/noticePost";
    }

    // 공지사항 글작성
    @PostMapping("/noticePost")
    public String noticePost1(@ModelAttribute NoticeVo noticeVo, HttpSession session) {
        int insertResult = nd.insertNotice(noticeVo);
        if (insertResult > 0) {           // 성공으로 판단되면 목록으로 돌아가기.
            return "redirect:/notice/";
        } else {                          // 실패하면 글작성 페이지에 머무름.
            return "bbs/noticePost";
        }
    }

    // 공지사항 상세조회
    @GetMapping("/noticeDetail")
    public String boardDetail(Model model, NoticeVo noticeVo) {
        NoticeVo notice = nd.selectNotice(noticeVo.getNotice_num());
        model.addAttribute("notice", notice);
        return "bbs/noticeDetail";
    }

    // 공지사항 글 수정/삭제 폼
    @GetMapping("/updateNotice1")
    public String updateBoard1(NoticeVo noticeVo, Model model, int notice_num) {
        NoticeVo notice = nd.selectNotice(noticeVo.getNotice_num());
        model.addAttribute("notice", notice);
        return "bbs/noticeUpdate";
    }

    // 공지사항 글 수정
    @PostMapping("/updateNotice2")
    public String updateNotice2(NoticeVo noticeVo, Model model) {
        System.out.println("보드값" + noticeVo.getNotice_num() );
        NoticeVo notice = nd.selectNotice(noticeVo.getNotice_num());
        System.out.println(notice);
        int str = nd.updateNotice(noticeVo);
        System.out.println("업데이트 :" + str);
        return "redirect:/notice";
    }

    // 공지사항 글 삭제
    @GetMapping("/deleteNotice")
    public String deleteNotice(int notice_num) {
        int str = nd.deleteBoard(notice_num);
        return "redirect:/notice";
    }

}
