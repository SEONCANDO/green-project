package com.sunny.green.vo;



public class AdminVo {

    private String admin_id;
    private String admin_pass;
    private String user_id;

    private String user_pass;

    private int admin_role;

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_pass() {
        return admin_pass;
    }

    public void setAdmin_pass(String admin_pass) {
        this.admin_pass = admin_pass;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public int getAdmin_role() {
        return admin_role;
    }

    public void setAdmin_role(int admin_role) {
        this.admin_role = admin_role;
    }

    public AdminVo(String admin_id, String admin_pass, String user_id, String user_pass, int admin_role) {
        this.admin_id = admin_id;
        this.admin_pass = admin_pass;
        this.user_id = user_id;
        this.user_pass = user_pass;
        this.admin_role = admin_role;
    }

    public AdminVo() {
    }


}
