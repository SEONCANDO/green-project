package com.sunny.green.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PickupImgVo {
    int pu_no;
    String pu_img_origin_name;
    String pu_img_save_name;
    String pu_img_path;
}
