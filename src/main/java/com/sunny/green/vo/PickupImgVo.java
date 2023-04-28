package com.sunny.green.vo;


public class PickupImgVo {
    int pu_no;
    String pu_img_origin_name;
    String pu_img_save_name;
    String pu_img_path;

    public int getPu_no() {
        return pu_no;
    }

    public void setPu_no(int pu_no) {
        this.pu_no = pu_no;
    }

    public String getPu_img_origin_name() {
        return pu_img_origin_name;
    }

    public void setPu_img_origin_name(String pu_img_origin_name) {
        this.pu_img_origin_name = pu_img_origin_name;
    }

    public String getPu_img_save_name() {
        return pu_img_save_name;
    }

    public void setPu_img_save_name(String pu_img_save_name) {
        this.pu_img_save_name = pu_img_save_name;
    }

    public String getPu_img_path() {
        return pu_img_path;
    }

    public void setPu_img_path(String pu_img_path) {
        this.pu_img_path = pu_img_path;
    }

    public PickupImgVo(int pu_no, String pu_img_origin_name, String pu_img_save_name, String pu_img_path) {
        this.pu_no = pu_no;
        this.pu_img_origin_name = pu_img_origin_name;
        this.pu_img_save_name = pu_img_save_name;
        this.pu_img_path = pu_img_path;
    }

    public PickupImgVo() {
    }
}
