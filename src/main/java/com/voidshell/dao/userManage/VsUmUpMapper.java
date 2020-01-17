package com.voidshell.dao.userManage;

import com.voidshell.pojo.userManage.VsUmUp;
import com.voidshell.pojo.userManage.VsUmUpExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface VsUmUpMapper {
    int countByExample(VsUmUpExample example);

    int deleteByExample(VsUmUpExample example);

    int deleteByPrimaryKey(String id);

    int insert(VsUmUp record);

    int insertSelective(VsUmUp record);

    List<VsUmUp> selectByExample(VsUmUpExample example);

    VsUmUp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VsUmUp record, @Param("example") VsUmUpExample example);

    int updateByExample(@Param("record") VsUmUp record, @Param("example") VsUmUpExample example);

    int updateByPrimaryKeySelective(VsUmUp record);

    int updateByPrimaryKey(VsUmUp record);
}