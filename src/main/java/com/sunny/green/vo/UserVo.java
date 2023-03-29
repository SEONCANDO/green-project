package com.sunny.green.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo {
       private int userNumber;

       private String userId;

       private String userPass;

       private String userName;

       private String userEmail;

       private int userPhone;

       private int zipCode;

       private String address1;

       private String address2;

       private String address3;

       private String address4;

       private int userPoint;


}
