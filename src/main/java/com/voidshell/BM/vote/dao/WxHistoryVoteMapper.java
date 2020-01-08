package com.voidshell.BM.vote.dao;

import com.voidshell.BM.vote.pojo.WxHistoryVote;
import com.voidshell.BM.vote.pojo.WxHistoryVoteExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxHistoryVoteMapper {
    int countByExample(WxHistoryVoteExample example);

    int deleteByExample(WxHistoryVoteExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxHistoryVote record);

    int insertSelective(WxHistoryVote record);

    List<WxHistoryVote> selectByExample(WxHistoryVoteExample example);

    WxHistoryVote selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxHistoryVote record, @Param("example") WxHistoryVoteExample example);

    int updateByExample(@Param("record") WxHistoryVote record, @Param("example") WxHistoryVoteExample example);

    int updateByPrimaryKeySelective(WxHistoryVote record);

    int updateByPrimaryKey(WxHistoryVote record);
}