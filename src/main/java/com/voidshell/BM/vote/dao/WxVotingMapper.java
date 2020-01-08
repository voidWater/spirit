package com.voidshell.BM.vote.dao;

import com.voidshell.BM.vote.pojo.WxVoting;
import com.voidshell.BM.vote.pojo.WxVotingExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface WxVotingMapper {
    int countByExample(WxVotingExample example);

    int deleteByExample(WxVotingExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxVoting record);

    int insertSelective(WxVoting record);

    List<WxVoting> selectByExample(WxVotingExample example);

    WxVoting selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxVoting record, @Param("example") WxVotingExample example);

    int updateByExample(@Param("record") WxVoting record, @Param("example") WxVotingExample example);

    int updateByPrimaryKeySelective(WxVoting record);

    int updateByPrimaryKey(WxVoting record);
}