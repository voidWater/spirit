package com.voidshell.service.userManage;

import com.voidshell.dao.userManage.VsUmUserMapper;
import com.voidshell.pojo.userManage.VsUmUser;
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
    public VsUmUser createUser(VsUmUser user){
        user.setCreatedate(new Date());
        //TODO
        user.setCreateuser("");
        user.setValid(1);
        if(vsUmUserMapper.insert(user)==1){
            user = vsUmUserMapper.selectByPrimaryKey(user.getId());
            return user;
        }else{
            return null;
        }
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
