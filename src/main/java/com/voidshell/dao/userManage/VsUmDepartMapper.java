package com.voidshell.dao.userManage;

import com.voidshell.pojo.userManage.VsUmDepart;
import com.voidshell.pojo.userManage.VsUmDepartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VsUmDepartMapper {
    int countByExample(VsUmDepartExample example);

    int deleteByExample(VsUmDepartExample example);

    int deleteByPrimaryKey(String id);

    int insert(VsUmDepart record);

    int insertSelective(VsUmDepart record);

    List<VsUmDepart> selectByExample(VsUmDepartExample example);

    VsUmDepart selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VsUmDepart record, @Param("example") VsUmDepartExample example);

    int updateByExample(@Param("record") VsUmDepart record, @Param("example") VsUmDepartExample example);

    int updateByPrimaryKeySelective(VsUmDepart record);

    int updateByPrimaryKey(VsUmDepart record);
}