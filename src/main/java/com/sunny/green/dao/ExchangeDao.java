package com.sunny.green.dao;

import com.sunny.green.vo.ProImgVo;
import com.sunny.green.vo.ProductVo;
import com.sunny.green.vo.ProductWithImgVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExchangeDao {

    public List<ProductWithImgVo> selectProductAll();

    public ProductWithImgVo selectProOne(int pro_num);
}
