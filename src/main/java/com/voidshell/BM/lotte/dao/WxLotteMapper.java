package com.voidshell.BM.lotte.dao;

import com.voidshell.BM.lotte.pojo.WxLotte;
import com.voidshell.BM.lotte.pojo.WxLotteExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxLotteMapper {
    int countByExample(WxLotteExample example);

    int deleteByExample(WxLotteExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxLotte record);

    int insertSelective(WxLotte record);

    List<WxLotte> selectByExample(WxLotteExample example);

    WxLotte selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxLotte record, @Param("example") WxLotteExample example);

    int updateByExample(@Param("record") WxLotte record, @Param("example") WxLotteExample example);

    int updateByPrimaryKeySelective(WxLotte record);

    int updateByPrimaryKey(WxLotte record);
}