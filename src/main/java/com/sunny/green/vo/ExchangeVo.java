package com.sunny.green.vo;




import java.sql.Timestamp;


public class ExchangeVo {

    private int ex_num;

    private int pro_num;

    private String user_id;

    private String user_name;

    private String user_email;

    private String pro_name;

    private int user_point;

    private int pay_point;

    private int remain_point;
    private Timestamp ex_date;

    private String ex_uuid_num;

    private String pro_img_save_name;

    private UserVo userVo;

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public int getEx_num() {
        return ex_num;
    }

    public void setEx_num(int ex_num) {
        this.ex_num = ex_num;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getUser_point() {
        return user_point;
    }

    public void setUser_point(int user_point) {
        this.user_point = user_point;
    }

    public int getPay_point() {
        return pay_point;
    }

    public void setPay_point(int pay_point) {
        this.pay_point = pay_point;
    }

    public int getRemain_point() {
        return remain_point;
    }

    public void setRemain_point(int remain_point) {
        this.remain_point = remain_point;
    }

    public Timestamp getEx_date() {
        return ex_date;
    }

    public void setEx_date(Timestamp ex_date) {
        this.ex_date = ex_date;
    }

    public String getEx_uuid_num() {
        return ex_uuid_num;
    }

    public void setEx_uuid_num(String ex_uuid_num) {
        this.ex_uuid_num = ex_uuid_num;
    }

    public String getPro_img_save_name() {
        return pro_img_save_name;
    }

    public void setPro_img_save_name(String pro_img_save_name) {
        this.pro_img_save_name = pro_img_save_name;
    }

    public ExchangeVo() {
    }

    public ExchangeVo(int ex_num, int pro_num, String user_id, String user_name, String user_email, String pro_name, int user_point, int pay_point, int remain_point, Timestamp ex_date, String ex_uuid_num, String pro_img_save_name, UserVo userVo) {
        this.ex_num = ex_num;
        this.pro_num = pro_num;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.pro_name = pro_name;
        this.user_point = user_point;
        this.pay_point = pay_point;
        this.remain_point = remain_point;
        this.ex_date = ex_date;
        this.ex_uuid_num = ex_uuid_num;
        this.pro_img_save_name = pro_img_save_name;
        this.userVo = userVo;
    }
}
