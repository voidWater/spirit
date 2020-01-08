package com.voidshell.dao.userManage;

import com.voidshell.pojo.userManage.VsUmOrg;
import com.voidshell.pojo.userManage.VsUmOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VsUmOrgMapper {
    int countByExample(VsUmOrgExample example);

    int deleteByExample(VsUmOrgExample example);

    int deleteByPrimaryKey(String id);

    int insert(VsUmOrg record);

    int insertSelective(VsUmOrg record);

    List<VsUmOrg> selectByExample(VsUmOrgExample example);

    VsUmOrg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VsUmOrg record, @Param("example") VsUmOrgExample example);

    int updateByExample(@Param("record") VsUmOrg record, @Param("example") VsUmOrgExample example);

    int updateByPrimaryKeySelective(VsUmOrg record);

    int updateByPrimaryKey(VsUmOrg record);
}