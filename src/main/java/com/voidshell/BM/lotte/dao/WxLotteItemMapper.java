package com.voidshell.BM.lotte.dao;

import com.voidshell.BM.lotte.pojo.WxLotteItem;
import com.voidshell.BM.lotte.pojo.WxLotteItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxLotteItemMapper {
    int countByExample(WxLotteItemExample example);

    int deleteByExample(WxLotteItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxLotteItem record);

    int insertSelective(WxLotteItem record);

    List<WxLotteItem> selectByExample(WxLotteItemExample example);

    WxLotteItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxLotteItem record, @Param("example") WxLotteItemExample example);

    int updateByExample(@Param("record") WxLotteItem record, @Param("example") WxLotteItemExample example);

    int updateByPrimaryKeySelective(WxLotteItem record);

    int updateByPrimaryKey(WxLotteItem record);
}