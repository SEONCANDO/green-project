package com.sunny.green.vo;


import java.time.LocalDateTime;

public class MailVo {

    private int mail_num;

    private String mail_receiver;

    private String mail_title;

    private String mail_content;

    private LocalDateTime mail_date;

    public int getMail_num() {
        return mail_num;
    }

    public void setMail_num(int mail_num) {
        this.mail_num = mail_num;
    }

    public String getMail_receiver() {
        return mail_receiver;
    }

    public void setMail_receiver(String mail_receiver) {
        this.mail_receiver = mail_receiver;
    }

    public String getMail_title() {
        return mail_title;
    }

    public void setMail_title(String mail_title) {
        this.mail_title = mail_title;
    }

    public String getMail_content() {
        return mail_content;
    }

    public void setMail_content(String mail_content) {
        this.mail_content = mail_content;
    }

    public LocalDateTime getMail_date() {
        return mail_date;
    }

    public void setMail_date(LocalDateTime mail_date) {
        this.mail_date = mail_date;
    }

    public MailVo(int mail_num, String mail_receiver, String mail_title, String mail_content, LocalDateTime mail_date) {
        this.mail_num = mail_num;
        this.mail_receiver = mail_receiver;
        this.mail_title = mail_title;
        this.mail_content = mail_content;
        this.mail_date = mail_date;
    }

    public MailVo() {
    }
}
