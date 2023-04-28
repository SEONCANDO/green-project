package com.sunny.green.vo;


public class UserVo {
       private String user_id;

       private String user_pass;

       private String user_name;

       private String user_email;

       private String user_tel;

       private String zip_code;

       private String address1;

       private String address2;

       private String address3;

       private String address4;

       private int user_point;

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

       public String getUser_tel() {
              return user_tel;
       }

       public void setUser_tel(String user_tel) {
              this.user_tel = user_tel;
       }

       public String getZip_code() {
              return zip_code;
       }

       public void setZip_code(String zip_code) {
              this.zip_code = zip_code;
       }

       public String getAddress1() {
              return address1;
       }

       public void setAddress1(String address1) {
              this.address1 = address1;
       }

       public String getAddress2() {
              return address2;
       }

       public void setAddress2(String address2) {
              this.address2 = address2;
       }

       public String getAddress3() {
              return address3;
       }

       public void setAddress3(String address3) {
              this.address3 = address3;
       }

       public String getAddress4() {
              return address4;
       }

       public void setAddress4(String address4) {
              this.address4 = address4;
       }

       public int getUser_point() {
              return user_point;
       }

       public void setUser_point(int user_point) {
              this.user_point = user_point;
       }

       public UserVo() {
       }

       public UserVo(String user_id, String user_pass, String user_name, String user_email, String user_tel, String zip_code, String address1, String address2, String address3, String address4, int user_point) {
              this.user_id = user_id;
              this.user_pass = user_pass;
              this.user_name = user_name;
              this.user_email = user_email;
              this.user_tel = user_tel;
              this.zip_code = zip_code;
              this.address1 = address1;
              this.address2 = address2;
              this.address3 = address3;
              this.address4 = address4;
              this.user_point = user_point;
       }


}
