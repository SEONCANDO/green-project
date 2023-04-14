package com.sunny.green.dao;

import com.sunny.green.vo.PickupAddressVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PickupDao {

    public PickupAddressVo impAddress(PickupAddressVo pickupAddressVo);
}
