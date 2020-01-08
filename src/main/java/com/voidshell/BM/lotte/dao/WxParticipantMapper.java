package com.voidshell.BM.lotte.dao;

import com.voidshell.BM.lotte.pojo.WxParticipant;
import com.voidshell.BM.lotte.pojo.WxParticipantExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxParticipantMapper {
    int countByExample(WxParticipantExample example);

    int deleteByExample(WxParticipantExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxParticipant record);

    int insertSelective(WxParticipant record);

    List<WxParticipant> selectByExample(WxParticipantExample example);

    WxParticipant selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxParticipant record, @Param("example") WxParticipantExample example);

    int updateByExample(@Param("record") WxParticipant record, @Param("example") WxParticipantExample example);

    int updateByPrimaryKeySelective(WxParticipant record);

    int updateByPrimaryKey(WxParticipant record);
}