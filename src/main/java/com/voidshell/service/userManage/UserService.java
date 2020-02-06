package com.voidshell.service.userManage;

import com.voidshell.common.ResponseResult;
import com.voidshell.dao.userManage.VsUmUserMapper;
import com.voidshell.pojo.userManage.VsUmDepartExample;
import com.voidshell.pojo.userManage.VsUmUser;
import com.voidshell.pojo.userManage.VsUmUserExample;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private VsUmUserMapper vsUmUserMapper;

    /**
     * 创建用户
     * @param user
     * @return
     */
    public ResponseResult createUser(VsUmUser user){
        VsUmUserExample vsUmUserExample = new VsUmUserExample();
        vsUmUserExample.createCriteria().andCodeEqualTo(user.getCode());
        List<VsUmUser> list = vsUmUserMapper.selectByExample(vsUmUserExample);
        if(list.size()>0){
            return ResponseResult.createComm(201,"user","用户唯一性编码重复");
        }
        user.setCreatedate(new Date());
        //TODO
        user.setCreateuser("");
        user.setCreatedate(new Date());
        user.setValid(1);

        if(vsUmUserMapper.insert(user)==1){
            return ResponseResult.createComm(0,"success","新增用户成功");
        }else{
            return ResponseResult.createComm(1,"error","新增用户失败");
        }
    }
    public List<VsUmUser> list(){
        return null;
    }
    /**
     * 物理删除用户
     * @param id
     * @return
     */
    public int delUser(String id){
        return vsUmUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 逻辑删除用户
     * @param id
     * @return
     */
    public int locDelUser(String id){
        VsUmUser vsUmUser = vsUmUserMapper.selectByPrimaryKey(id);
        if(vsUmUser==null){
            return 0;
        }
        vsUmUser.setValid(0);
        if(vsUmUserMapper.updateByPrimaryKey(vsUmUser)==1){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public VsUmUser updateUser(VsUmUser user){
        if(vsUmUserMapper.updateByPrimaryKey(user)==1){
            user = vsUmUserMapper.selectByPrimaryKey(user.getId());
            user.setUpdatedate(new Date());
            //TODO
            user.setUpdateuser("");
            user.setPassword("");
            return user;
        }else{
            return null;
        }
    }

    /**
     * 获取用户
     * @param id
     * @return
     */
    public VsUmUser getUser(String id){
        return vsUmUserMapper.selectByPrimaryKey(id);
    }
}
