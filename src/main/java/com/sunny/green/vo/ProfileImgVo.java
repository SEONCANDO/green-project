package com.sunny.green.vo;

public class ProfileImgVo {

    private int profile_num;

    private String user_id;

    private String img_save_name;

    private String img_path;

    public int getProfile_num() {
        return profile_num;
    }

    public void setProfile_num(int profile_num) {
        this.profile_num = profile_num;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getImg_save_name() {
        return img_save_name;
    }

    public void setImg_save_name(String img_save_name) {
        this.img_save_name = img_save_name;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public ProfileImgVo() {
    }

    public ProfileImgVo(int profile_num, String user_id, String img_save_name, String img_path) {
        this.profile_num = profile_num;
        this.user_id = user_id;
        this.img_save_name = img_save_name;
        this.img_path = img_path;
    }
}
