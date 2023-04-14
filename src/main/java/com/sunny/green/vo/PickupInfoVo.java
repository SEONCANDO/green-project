package com.sunny.green.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PickupInfoVo {
    int pu_address_no;

    String user_id;

    int house_no;

    OffsetDateTime pu_date;

    String pu_elevator;

    OffsetDateTime pu_day;

    String pu_img;

    String pu_memo;

}
