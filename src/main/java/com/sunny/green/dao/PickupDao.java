package com.sunny.green.dao;

import com.sunny.green.vo.PickupAddressVo;
import com.sunny.green.vo.PickupCategoryVo;
import com.sunny.green.vo.PickupImgVo;
import com.sunny.green.vo.PickupInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PickupDao {

    public int pickupAddressSave(PickupAddressVo pickupAddressVo);
    public int pickupInfoSave(PickupInfoVo pickupInfoVo);
    public int pickupCategorySave(PickupCategoryVo items);
    public int pickupImgSave(PickupImgVo pickupImgVo);
    public int pickupImgUpdate(PickupImgVo pickupImgVo);
    public PickupImgVo pickupImgView(Integer pu_no);

}
