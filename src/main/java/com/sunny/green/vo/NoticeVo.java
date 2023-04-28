package com.sunny.green.vo;


import java.time.LocalDateTime;


public class NoticeVo {
    private int notice_num;
    private String notice_title;
    private String notice_content;
    private String user_id;
    private LocalDateTime notice_date;

    public int getNotice_num() {
        return notice_num;
    }

    public void setNotice_num(int notice_num) {
        this.notice_num = notice_num;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(LocalDateTime notice_date) {
        this.notice_date = notice_date;
    }

    public NoticeVo(int notice_num, String notice_title, String notice_content, String user_id, LocalDateTime notice_date) {
        this.notice_num = notice_num;
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.user_id = user_id;
        this.notice_date = notice_date;
    }

    public NoticeVo() {
    }
}
