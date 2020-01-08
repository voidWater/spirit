package com.voidshell.BM.vote.dao;

import com.voidshell.BM.vote.pojo.WxVoteItem;
import com.voidshell.BM.vote.pojo.WxVoteItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface WxVoteItemMapper {
    int countByExample(WxVoteItemExample example);

    int deleteByExample(WxVoteItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxVoteItem record);

    int insertSelective(WxVoteItem record);

    List<WxVoteItem> selectByExample(WxVoteItemExample example);

    WxVoteItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxVoteItem record, @Param("example") WxVoteItemExample example);

    int updateByExample(@Param("record") WxVoteItem record, @Param("example") WxVoteItemExample example);

    int updateByPrimaryKeySelective(WxVoteItem record);

    int updateByPrimaryKey(WxVoteItem record);
}