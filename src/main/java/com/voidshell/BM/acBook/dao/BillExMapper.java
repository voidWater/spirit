package com.voidshell.BM.acBook.dao;

import com.voidshell.BM.acBook.pojo.BillEx;
import com.voidshell.BM.acBook.pojo.BillExExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillExMapper {
    long countByExample(BillExExample example);

    int deleteByExample(BillExExample example);

    int deleteByPrimaryKey(String id);

    int insert(BillEx record);

    int insertSelective(BillEx record);

    List<BillEx> selectByExampleWithBLOBs(BillExExample example);

    List<BillEx> selectByExample(BillExExample example);

    BillEx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BillEx record, @Param("example") BillExExample example);

    int updateByExampleWithBLOBs(@Param("record") BillEx record, @Param("example") BillExExample example);

    int updateByExample(@Param("record") BillEx record, @Param("example") BillExExample example);

    int updateByPrimaryKeySelective(BillEx record);

    int updateByPrimaryKeyWithBLOBs(BillEx record);

    int updateByPrimaryKey(BillEx record);
}