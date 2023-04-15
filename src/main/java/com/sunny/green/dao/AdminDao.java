package com.sunny.green.dao;

import com.sunny.green.vo.ProImgVo;
import com.sunny.green.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {
    public int insertPro(ProductVo pro);

    public ProductVo selectPro(int proNum);

    public int insertProImg(ProImgVo proImgVo);

    public List<ProductVo> selectProAll();
}