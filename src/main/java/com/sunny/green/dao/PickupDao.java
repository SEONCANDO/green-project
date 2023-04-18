package com.sunny.green.dao;

import com.sunny.green.vo.PickupAddressVo;
import com.sunny.green.vo.PickupInfoVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PickupDao {

    public PickupAddressVo pickupInfoSave(String user_id, String pu_name, String pu_tel, int pu_zip, String pu_address1, String pu_address2, String pu_address3, String pu_address4);
    public PickupInfoVo pickupInfoSave2(int house_no, String pu_elevator, String pu_day, String pu_img, String text_memo);

}
