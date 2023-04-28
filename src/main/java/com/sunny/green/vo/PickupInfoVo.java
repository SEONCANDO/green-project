package com.sunny.green.vo;



public class PickupInfoVo {
    private int pu_no;

    private int pu_address_no;

    private String user_id;

    private int house_no;

    private String pu_elevator;

    private String pu_day;

    private String pu_img;

    private String text_memo;

    public int getPu_no() {
        return pu_no;
    }

    public void setPu_no(int pu_no) {
        this.pu_no = pu_no;
    }

    public int getPu_address_no() {
        return pu_address_no;
    }

    public void setPu_address_no(int pu_address_no) {
        this.pu_address_no = pu_address_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getHouse_no() {
        return house_no;
    }

    public void setHouse_no(int house_no) {
        this.house_no = house_no;
    }

    public String getPu_elevator() {
        return pu_elevator;
    }

    public void setPu_elevator(String pu_elevator) {
        this.pu_elevator = pu_elevator;
    }

    public String getPu_day() {
        return pu_day;
    }

    public void setPu_day(String pu_day) {
        this.pu_day = pu_day;
    }

    public String getPu_img() {
        return pu_img;
    }

    public void setPu_img(String pu_img) {
        this.pu_img = pu_img;
    }

    public String getText_memo() {
        return text_memo;
    }

    public void setText_memo(String text_memo) {
        this.text_memo = text_memo;
    }

    public PickupInfoVo(int pu_no, int pu_address_no, String user_id, int house_no, String pu_elevator, String pu_day, String pu_img, String text_memo) {
        this.pu_no = pu_no;
        this.pu_address_no = pu_address_no;
        this.user_id = user_id;
        this.house_no = house_no;
        this.pu_elevator = pu_elevator;
        this.pu_day = pu_day;
        this.pu_img = pu_img;
        this.text_memo = text_memo;
    }

    public PickupInfoVo() {
    }
}
