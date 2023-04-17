package com.sunny.green.dao;

import com.sunny.green.vo.PickupSaveVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PickupDao {

    public PickupSaveVo impAddress(PickupSaveVo pickupAddressVo);
}
