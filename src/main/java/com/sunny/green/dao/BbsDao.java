package com.sunny.green.dao;

import com.sunny.green.vo.BbsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbsDao {

    public int insertBoard(BbsVo bbsVo);

    public List<BbsVo> selectBoardAll();
    public List<BbsVo> selectBoardNum();

    void updateBoard(BbsVo bbsVo);
    void deleteBoard(BbsVo bbsVo);

}
