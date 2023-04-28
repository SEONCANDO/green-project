package com.sunny.green.vo;

import java.time.LocalDateTime;


public class CommentVo {
    private int com_num;
    private String com_content;
    private LocalDateTime com_date;
    private String user_id;
    private int board_num;

    public int getCom_num() {
        return com_num;
    }

    public void setCom_num(int com_num) {
        this.com_num = com_num;
    }

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public LocalDateTime getCom_date() {
        return com_date;
    }

    public void setCom_date(LocalDateTime com_date) {
        this.com_date = com_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getBoard_num() {
        return board_num;
    }

    public void setBoard_num(int board_num) {
        this.board_num = board_num;
    }

    public CommentVo(int com_num, String com_content, LocalDateTime com_date, String user_id, int board_num) {
        this.com_num = com_num;
        this.com_content = com_content;
        this.com_date = com_date;
        this.user_id = user_id;
        this.board_num = board_num;
    }

    public CommentVo() {
    }
}