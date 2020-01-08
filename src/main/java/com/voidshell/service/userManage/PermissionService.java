package com.voidshell.service.userManage;

import com.voidshell.dao.userManage.*;
import com.voidshell.pojo.userManage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionService {
    @Autowired
    private VsUmUrMapper vsUmUrMapper;
    @Autowired
    private VsUmRoleMapper vsUmRoleMapper;
    @Autowired
    private VsUmRpMapper vsUmRpMapper;
    @Autowired
    private VsUmPermissionMapper vsUmPermissionMapper;
    @Autowired
    private VsUmUpMapper vsUmUpMapper;

    /**
     * 获取用户全部权限
     * @param vsUmUser
     * @return
     */
    public Set<String> getPermissionByUser(VsUmUser vsUmUser){
        Set<String> permissionSet = new HashSet<>();
        List<VsUmRole> roles = getRoleByUser(vsUmUser);
        //admin获取全部权限
        for(int i = 0;i<roles.size();i++){
            if(roles.get(i).equals("admin")){
                VsUmPermissionExample vsUmPermissionExample = new VsUmPermissionExample();
                vsUmPermissionExample.createCriteria().andNameNotLike("%%");
                List<VsUmPermission> list= vsUmPermissionMapper.selectByExample(vsUmPermissionExample);
                list.forEach(l->{
                    permissionSet.add(l.getCode());
                });
                return permissionSet;
            }
        }
        //获取角色权限
        VsUmRpExample vsUmRpExample = new VsUmRpExample();
        roles.forEach(vsUmRole -> {
            vsUmRpExample.createCriteria().andRoleIdEqualTo(vsUmRole.getId());
            List<VsUmRp> list= vsUmRpMapper.selectByExample(vsUmRpExample);
            list.forEach(l->{
                permissionSet.add(vsUmPermissionMapper.selectByPrimaryKey(l.getPermissionId()).getCode());
            });
        });
        //获取自接权限
        VsUmUpExample vsUmUpExample = new VsUmUpExample();
        vsUmUpExample.createCriteria().andUserIdEqualTo(vsUmUser.getId());
        List<VsUmUp> umList= vsUmUpMapper.selectByExample(vsUmUpExample);
        umList.forEach(l->{
            permissionSet.add(vsUmPermissionMapper.selectByPrimaryKey(l.getPermissionId()).getCode());
        });
        return permissionSet;
    }

    /**
     * 根据用户获取角色
     * @param vsUmUser
     * @return
     */
    public List<VsUmRole> getRoleByUser(VsUmUser vsUmUser){
        VsUmUrExample vsUmUrExample = new VsUmUrExample();
        vsUmUrExample.createCriteria().andUserIdEqualTo(vsUmUser.getId());
        List<VsUmUr> list= vsUmUrMapper.selectByExample(vsUmUrExample);
        List<VsUmRole> result = new ArrayList<VsUmRole>();
        list.forEach(l->{
            result.add(vsUmRoleMapper.selectByPrimaryKey(l.getRoleId()));
        });
        return result;
    }

    /**
     * 根据角色获取权限
     * @param vsUmRole
     * @return
     */
    public Set<String> getPermissionByRole(VsUmRole vsUmRole){
        VsUmRpExample vsUmRpExample = new VsUmRpExample();
        vsUmRpExample.createCriteria().andRoleIdEqualTo(vsUmRole.getId());
        List<VsUmRp> list= vsUmRpMapper.selectByExample(vsUmRpExample);
        Set<String> result = new HashSet<>();
        list.forEach(l->{
            result.add(vsUmPermissionMapper.selectByPrimaryKey(l.getPermissionId()).getCode());
        });
        return result;
    }
}
