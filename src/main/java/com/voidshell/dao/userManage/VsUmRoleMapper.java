package com.voidshell.dao.userManage;

import com.voidshell.pojo.userManage.VsUmRole;
import com.voidshell.pojo.userManage.VsUmRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface VsUmRoleMapper {
    int countByExample(VsUmRoleExample example);

    int deleteByExample(VsUmRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(VsUmRole record);

    int insertSelective(VsUmRole record);

    List<VsUmRole> selectByExample(VsUmRoleExample example);

    VsUmRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VsUmRole record, @Param("example") VsUmRoleExample example);

    int updateByExample(@Param("record") VsUmRole record, @Param("example") VsUmRoleExample example);

    int updateByPrimaryKeySelective(VsUmRole record);

    int updateByPrimaryKey(VsUmRole record);
}