package com.voidshell.BM.boat.dao;

import com.voidshell.BM.boat.pojo.WxUser;
import com.voidshell.BM.boat.pojo.WxUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface WxUserMapper {
    int countByExample(WxUserExample example);

    int deleteByExample(WxUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    List<WxUser> selectByExample(WxUserExample example);

    WxUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxUser record, @Param("example") WxUserExample example);

    int updateByExample(@Param("record") WxUser record, @Param("example") WxUserExample example);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
}