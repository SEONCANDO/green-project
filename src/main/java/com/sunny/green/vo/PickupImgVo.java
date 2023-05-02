package com.sunny.green.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class PickupImgVo {
    int pu_no;
    String pu_img_origin_name;
    String pu_img_save_name;
    String pu_img_path;
}
