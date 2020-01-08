package com.voidshell.BM.vote.dao;

import com.voidshell.BM.vote.pojo.WxVote;
import com.voidshell.BM.vote.pojo.WxVoteExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxVoteMapper {
    int countByExample(WxVoteExample example);

    int deleteByExample(WxVoteExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxVote record);

    int insertSelective(WxVote record);

    List<WxVote> selectByExample(WxVoteExample example);

    WxVote selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxVote record, @Param("example") WxVoteExample example);

    int updateByExample(@Param("record") WxVote record, @Param("example") WxVoteExample example);

    int updateByPrimaryKeySelective(WxVote record);

    int updateByPrimaryKey(WxVote record);
}