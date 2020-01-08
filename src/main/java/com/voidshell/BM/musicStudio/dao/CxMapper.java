package com.voidshell.BM.musicStudio.dao;

import com.voidshell.BM.musicStudio.pojo.Cx;
import com.voidshell.BM.musicStudio.pojo.CxExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CxMapper {
    int countByExample(CxExample example);

    int deleteByExample(CxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cx record);

    int insertSelective(Cx record);

    List<Cx> selectByExample(CxExample example);

    Cx selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cx record, @Param("example") CxExample example);

    int updateByExample(@Param("record") Cx record, @Param("example") CxExample example);

    int updateByPrimaryKeySelective(Cx record);

    int updateByPrimaryKey(Cx record);
}