package com.voidshell.BM.lotte.dao;

import com.voidshell.BM.lotte.pojo.WxLuckPartic;
import com.voidshell.BM.lotte.pojo.WxLuckParticExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxLuckParticMapper {
    int countByExample(WxLuckParticExample example);

    int deleteByExample(WxLuckParticExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxLuckPartic record);

    int insertSelective(WxLuckPartic record);

    List<WxLuckPartic> selectByExample(WxLuckParticExample example);

    WxLuckPartic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxLuckPartic record, @Param("example") WxLuckParticExample example);

    int updateByExample(@Param("record") WxLuckPartic record, @Param("example") WxLuckParticExample example);

    int updateByPrimaryKeySelective(WxLuckPartic record);

    int updateByPrimaryKey(WxLuckPartic record);
}