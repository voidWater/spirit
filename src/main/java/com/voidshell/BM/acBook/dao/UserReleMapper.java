package com.voidshell.BM.acBook.dao;

import com.voidshell.BM.acBook.pojo.UserRele;
import com.voidshell.BM.acBook.pojo.UserReleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserReleMapper {
    long countByExample(UserReleExample example);

    int deleteByExample(UserReleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserRele record);

    int insertSelective(UserRele record);

    List<UserRele> selectByExample(UserReleExample example);

    UserRele selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserRele record, @Param("example") UserReleExample example);

    int updateByExample(@Param("record") UserRele record, @Param("example") UserReleExample example);

    int updateByPrimaryKeySelective(UserRele record);

    int updateByPrimaryKey(UserRele record);
}