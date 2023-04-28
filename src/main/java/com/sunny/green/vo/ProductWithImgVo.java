package com.sunny.green.vo;


import java.util.List;


public class ProductWithImgVo {

    private int pro_num;

    private String pro_name;

    private String pro_content;

    private String pro_from;

    private int pro_point;

    private String user_id;

    private int pro_img_no;

    private String pro_img_save_name;

    private String pro_img_path;

    public ProductWithImgVo(int pro_num, String pro_name, String pro_content, String pro_from, int pro_point, String user_id, int pro_img_no, String pro_img_save_name, String pro_img_path) {
        this.pro_num = pro_num;
        this.pro_name = pro_name;
        this.pro_content = pro_content;
        this.pro_from = pro_from;
        this.pro_point = pro_point;
        this.user_id = user_id;
        this.pro_img_no = pro_img_no;
        this.pro_img_save_name = pro_img_save_name;
        this.pro_img_path = pro_img_path;
    }

    public ProductWithImgVo() {
    }

    public int getPro_num() {
        return pro_num;
    }

    public void setPro_num(int pro_num) {
        this.pro_num = pro_num;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_content() {
        return pro_content;
    }

    public void setPro_content(String pro_content) {
        this.pro_content = pro_content;
    }

    public String getPro_from() {
        return pro_from;
    }

    public void setPro_from(String pro_from) {
        this.pro_from = pro_from;
    }

    public int getPro_point() {
        return pro_point;
    }

    public void setPro_point(int pro_point) {
        this.pro_point = pro_point;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getPro_img_no() {
        return pro_img_no;
    }

    public void setPro_img_no(int pro_img_no) {
        this.pro_img_no = pro_img_no;
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
