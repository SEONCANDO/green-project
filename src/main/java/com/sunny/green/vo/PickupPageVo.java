package com.sunny.green.vo;




public class PickupPageVo {
    String user_id;
    String pu_address_name;
    String pu_address_tel;
    int pu_address_zip;
    String pu_address1;
    String pu_address2;
    String pu_address3;
    String pu_address4;
    int house_no;
    String pu_elevator;
    String pu_day;
    String pu_img;
    String pu_memo;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPu_address_name() {
        return pu_address_name;
    }

    public void setPu_address_name(String pu_address_name) {
        this.pu_address_name = pu_address_name;
    }

    public String getPu_address_tel() {
        return pu_address_tel;
    }

    public void setPu_address_tel(String pu_address_tel) {
        this.pu_address_tel = pu_address_tel;
    }

    public int getPu_address_zip() {
        return pu_address_zip;
    }

    public void setPu_address_zip(int pu_address_zip) {
        this.pu_address_zip = pu_address_zip;
    }

    public String getPu_address1() {
        return pu_address1;
    }

    public void setPu_address1(String pu_address1) {
        this.pu_address1 = pu_address1;
    }

    public String getPu_address2() {
        return pu_address2;
    }

    public void setPu_address2(String pu_address2) {
        this.pu_address2 = pu_address2;
    }

    public String getPu_address3() {
        return pu_address3;
    }

    public void setPu_address3(String pu_address3) {
        this.pu_address3 = pu_address3;
    }

    public String getPu_address4() {
        return pu_address4;
    }

    public void setPu_address4(String pu_address4) {
        this.pu_address4 = pu_address4;
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

    public String getPu_memo() {
        return pu_memo;
    }

    public void setPu_memo(String pu_memo) {
        this.pu_memo = pu_memo;
    }

    public PickupPageVo(String user_id, String pu_address_name, String pu_address_tel, int pu_address_zip, String pu_address1, String pu_address2, String pu_address3, String pu_address4, int house_no, String pu_elevator, String pu_day, String pu_img, String pu_memo) {
        this.user_id = user_id;
        this.pu_address_name = pu_address_name;
        this.pu_address_tel = pu_address_tel;
        this.pu_address_zip = pu_address_zip;
        this.pu_address1 = pu_address1;
        this.pu_address2 = pu_address2;
        this.pu_address3 = pu_address3;
        this.pu_address4 = pu_address4;
        this.house_no = house_no;
        this.pu_elevator = pu_elevator;
        this.pu_day = pu_day;
        this.pu_img = pu_img;
        this.pu_memo = pu_memo;
    }

    public PickupPageVo() {
    }
}
