package com.sunny.green.vo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PickupAddressVo {
    private String user_id;

    private String pu_name;

    private String pu_tel;

    private int pu_zip;

    private String pu_address1;

    private String pu_address2;

    private String pu_address3;

    private String pu_address4;

}
