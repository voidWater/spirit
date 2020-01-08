package com.voidshell.dao.userManage;

import com.voidshell.pojo.userManage.VsUmUr;
import com.voidshell.pojo.userManage.VsUmUrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VsUmUrMapper {
    int countByExample(VsUmUrExample example);

    int deleteByExample(VsUmUrExample example);

    int deleteByPrimaryKey(String id);

    int insert(VsUmUr record);

    int insertSelective(VsUmUr record);

    List<VsUmUr> selectByExample(VsUmUrExample example);

    VsUmUr selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VsUmUr record, @Param("example") VsUmUrExample example);

    int updateByExample(@Param("record") VsUmUr record, @Param("example") VsUmUrExample example);

    int updateByPrimaryKeySelective(VsUmUr record);

    int updateByPrimaryKey(VsUmUr record);
}