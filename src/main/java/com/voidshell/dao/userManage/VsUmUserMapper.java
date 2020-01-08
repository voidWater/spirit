package com.voidshell.dao.userManage;

import com.voidshell.pojo.userManage.VsUmUser;
import com.voidshell.pojo.userManage.VsUmUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VsUmUserMapper {
    int countByExample(VsUmUserExample example);

    int deleteByExample(VsUmUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(VsUmUser record);

    int insertSelective(VsUmUser record);

    List<VsUmUser> selectByExample(VsUmUserExample example);

    VsUmUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VsUmUser record, @Param("example") VsUmUserExample example);

    int updateByExample(@Param("record") VsUmUser record, @Param("example") VsUmUserExample example);

    int updateByPrimaryKeySelective(VsUmUser record);

    int updateByPrimaryKey(VsUmUser record);
}