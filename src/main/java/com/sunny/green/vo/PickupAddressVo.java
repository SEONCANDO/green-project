package com.sunny.green.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PickupAddressVo {
    String user_id;

    String pu_address_name;

    int pu_address_tel;

    int pu_address_zip;

    String pu_address1;

    String pu_address2;

    String pu_address3;

    String pu_address4;
}
