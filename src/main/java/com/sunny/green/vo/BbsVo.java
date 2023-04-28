package com.sunny.green.vo;


import java.time.LocalDateTime;


public class BbsVo {
    private int board_num;
    private String board_title;
    private String board_content;
    private String user_id;
    private LocalDateTime board_date;
    private String comment_exist;
    private int board_hit;

    public int getBoard_num() {
        return board_num;
    }

    public void setBoard_num(int board_num) {
        this.board_num = board_num;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getBoard_date() {
        return board_date;
    }

    public void setBoard_date(LocalDateTime board_date) {
        this.board_date = board_date;
    }

    public String getComment_exist() {
        return comment_exist;
    }

    public void setComment_exist(String comment_exist) {
        this.comment_exist = comment_exist;
    }

    public int getBoard_hit() {
        return board_hit;
    }

    public void setBoard_hit(int board_hit) {
        this.board_hit = board_hit;
    }

    public BbsVo() {
    }

    public BbsVo(int board_num, String board_title, String board_content, String user_id, LocalDateTime board_date, String comment_exist, int board_hit) {
        this.board_num = board_num;
        this.board_title = board_title;
        this.board_content = board_content;
        this.user_id = user_id;
        this.board_date = board_date;
        this.comment_exist = comment_exist;
        this.board_hit = board_hit;
    }
}
