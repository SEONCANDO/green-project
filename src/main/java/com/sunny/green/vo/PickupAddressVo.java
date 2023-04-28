package com.sunny.green.vo;




public class PickupAddressVo {
    private int pu_address_no;

    private String user_id;

    private String pu_address_name;

    private String pu_address_tel;

    private int pu_address_zip;

    private String pu_address1;

    private String pu_address2;

    private String pu_address3;

    private String pu_address4;


    public PickupAddressVo(int pu_address_no, String user_id, String pu_address_name, String pu_address_tel, int pu_address_zip, String pu_address1, String pu_address2, String pu_address3, String pu_address4) {
        this.pu_address_no = pu_address_no;
        this.user_id = user_id;
        this.pu_address_name = pu_address_name;
        this.pu_address_tel = pu_address_tel;
        this.pu_address_zip = pu_address_zip;
        this.pu_address1 = pu_address1;
        this.pu_address2 = pu_address2;
        this.pu_address3 = pu_address3;
        this.pu_address4 = pu_address4;
    }

    public PickupAddressVo() {
    }
}
