package com.sunny.green.vo;

public class ProImgVo {
    private int pro_img_no;

    private int pro_num;

    private String user_id;

    private String pro_img_save_name;

    private String pro_img_path;

    public ProImgVo(int pro_img_no, int pro_num, String user_id, String pro_img_save_name, String pro_img_path) {
        this.pro_img_no = pro_img_no;
        this.pro_num = pro_num;
        this.user_id = user_id;
        this.pro_img_save_name = pro_img_save_name;
        this.pro_img_path = pro_img_path;
    }

    public ProImgVo() {
    }

    public int getPro_img_no() {
        return pro_img_no;
    }

    public void setPro_img_no(int pro_img_no) {
        this.pro_img_no = pro_img_no;
    }

    public int getPro_num() {
        return pro_num;
    }

    public void setPro_num(int pro_num) {
        this.pro_num = pro_num;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPro_img_save_name() {
        return pro_img_save_name;
    }

    public void setPro_img_save_name(String pro_img_save_name) {
        this.pro_img_save_name = pro_img_save_name;
    }

    public String getPro_img_path() {
        return pro_img_path;
    }

    public void setPro_img_path(String pro_img_path) {
        this.pro_img_path = pro_img_path;
    }
}
