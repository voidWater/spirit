package com.voidshell.dao.userManage;

import com.voidshell.pojo.userManage.VsUmRp;
import com.voidshell.pojo.userManage.VsUmRpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VsUmRpMapper {
    int countByExample(VsUmRpExample example);

    int deleteByExample(VsUmRpExample example);

    int deleteByPrimaryKey(String id);

    int insert(VsUmRp record);

    int insertSelective(VsUmRp record);

    List<VsUmRp> selectByExample(VsUmRpExample example);

    VsUmRp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VsUmRp record, @Param("example") VsUmRpExample example);

    int updateByExample(@Param("record") VsUmRp record, @Param("example") VsUmRpExample example);

    int updateByPrimaryKeySelective(VsUmRp record);

    int updateByPrimaryKey(VsUmRp record);
}