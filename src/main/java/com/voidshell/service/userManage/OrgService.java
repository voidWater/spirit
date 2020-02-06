package com.voidshell.service.userManage;

import com.voidshell.common.ResponseResult;
import com.voidshell.dao.userManage.VsUmDepartMapper;
import com.voidshell.pojo.userManage.VsUmDepart;
import com.voidshell.pojo.userManage.VsUmDepartExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrgService {

    @Autowired
    private VsUmDepartMapper vsUmDepartMapper;

    /**
     * 新增部门
     * @param code
     * @param name
     * @param des
     * @return
     */
    public int addDepart(String code,String name,String des){
        VsUmDepart vsUmDepart = new VsUmDepart();
        vsUmDepart.setCode(code);
        vsUmDepart.setName(name);
        vsUmDepart.setDes(des);
        vsUmDepart.setValid(1);
        vsUmDepart.setId(UUID.randomUUID().toString().replaceAll("-",""));
        vsUmDepart.setCreatedate(new Date());
        return vsUmDepartMapper.insertSelective(vsUmDepart);
    }

    /**
     *  获取部门信息
     * @return
     */
    public VsUmDepart getDepart(String id){
        return vsUmDepartMapper.selectByPrimaryKey(id);
    }
    /**
     * 删除部门（逻辑删除）
     * @param id
     * @return
     */
    public int delDepart(String id){
        VsUmDepart vsUmDepart = getDepart(id);
        vsUmDepart.setValid(0);
        return vsUmDepartMapper.updateByPrimaryKey(vsUmDepart);
    }

    /**
     * 修改部门信息
     * @param depart
     * @return
     */
    public int updateDepart(VsUmDepart depart){
        depart.setUpdatedate(new Date());
        return vsUmDepartMapper.updateByPrimaryKey(depart);
    }

    /**
     * 获取部门列表
     * @return
     */
    public List<VsUmDepart> list(){
        VsUmDepartExample vsUmDepartExample = new VsUmDepartExample();
        vsUmDepartExample.createCriteria().andNameLike("%%");
        return vsUmDepartMapper.selectByExample(vsUmDepartExample);
    }

}
