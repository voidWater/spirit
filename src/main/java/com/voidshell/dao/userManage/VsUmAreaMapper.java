package com.voidshell.dao.userManage;

import com.voidshell.pojo.userManage.VsUmArea;
import com.voidshell.pojo.userManage.VsUmAreaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface VsUmAreaMapper {
    int countByExample(VsUmAreaExample example);

    int deleteByExample(VsUmAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VsUmArea record);

    int insertSelective(VsUmArea record);

    List<VsUmArea> selectByExample(VsUmAreaExample example);

    VsUmArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VsUmArea record, @Param("example") VsUmAreaExample example);

    int updateByExample(@Param("record") VsUmArea record, @Param("example") VsUmAreaExample example);

    int updateByPrimaryKeySelective(VsUmArea record);

    int updateByPrimaryKey(VsUmArea record);
}