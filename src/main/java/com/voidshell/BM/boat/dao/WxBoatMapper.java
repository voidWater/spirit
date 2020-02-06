package com.voidshell.BM.boat.dao;

import com.voidshell.BM.boat.pojo.WxBoat;
import com.voidshell.BM.boat.pojo.WxBoatExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxBoatMapper {
    int countByExample(WxBoatExample example);

    int deleteByExample(WxBoatExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxBoat record);

    int insertSelective(WxBoat record);

    List<WxBoat> selectByExample(WxBoatExample example);

    WxBoat selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxBoat record, @Param("example") WxBoatExample example);

    int updateByExample(@Param("record") WxBoat record, @Param("example") WxBoatExample example);

    int updateByPrimaryKeySelective(WxBoat record);

    int updateByPrimaryKey(WxBoat record);
}