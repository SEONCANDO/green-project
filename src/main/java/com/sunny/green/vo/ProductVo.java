package com.sunny.green.vo;




public class ProductVo {

    private int pro_num;

    private String pro_name;

    private String pro_content;

    private String pro_from;
    private String pro_img;

    private int pro_point;

    private String user_id;


    private ProImgVo proImgVo;

    public ProImgVo getProImgVo() {
        return proImgVo;
    }

    public void setProImgVo(ProImgVo proImgVo) {
        this.proImgVo = proImgVo;
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

    public String getPro_img() {
        return pro_img;
    }

    public void setPro_img(String pro_img) {
        this.pro_img = pro_img;
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

    public ProductVo(int pro_num, String pro_name, String pro_content, String pro_from, String pro_img, int pro_point, String user_id, ProImgVo proImgVo) {
        this.pro_num = pro_num;
        this.pro_name = pro_name;
        this.pro_content = pro_content;
        this.pro_from = pro_from;
        this.pro_img = pro_img;
        this.pro_point = pro_point;
        this.user_id = user_id;
        this.proImgVo = proImgVo;
    }

    public ProductVo() {
    }
}
