package com.voidshell.dao.userManage;

import com.voidshell.pojo.userManage.VsUmPermission;
import com.voidshell.pojo.userManage.VsUmPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VsUmPermissionMapper {
    int countByExample(VsUmPermissionExample example);

    int deleteByExample(VsUmPermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(VsUmPermission record);

    int insertSelective(VsUmPermission record);

    List<VsUmPermission> selectByExample(VsUmPermissionExample example);

    VsUmPermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VsUmPermission record, @Param("example") VsUmPermissionExample example);

    int updateByExample(@Param("record") VsUmPermission record, @Param("example") VsUmPermissionExample example);

    int updateByPrimaryKeySelective(VsUmPermission record);

    int updateByPrimaryKey(VsUmPermission record);
}