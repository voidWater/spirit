package com.voidshell.service.userManage;

import com.voidshell.dao.UserMapper;
import com.voidshell.pojo.User;
import com.voidshell.pojo.UserExample;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserManageService {
    @RequiresPermissions("read")
    public String read() {
        return "reading...";
    }

    @RequiresPermissions("write")
    public String write() {
        return "writting...";
    }
    @Autowired
    private UserMapper userMapper;

    public User createUser(User user){
        String code = UUID.randomUUID().toString().replaceAll("-","");
        user.setCode(code);
        user.setCreateTime(new Date());
        int i = userMapper.insertSelective(user);
        if(i==1){
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andCodeEqualTo(code);
            return userMapper.selectByExample(userExample).get(0);
        }else{
            return null;
        }
    }

    public List<User> viewUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameLike("%%");

        return userMapper.selectByExample(userExample);
    }

    public User getUser(String id) {
        return userMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    public String delUser(String id) {
        if(userMapper.deleteByPrimaryKey(Integer.valueOf(id))==1){
            return "success";
        }else{
            return "fail";
        }
    }

    public User updateUser(User user) {
        user.setUpdateTime(new Date());
        if(userMapper.updateByPrimaryKey(user)==1){
            return userMapper.selectByPrimaryKey(user.getId());
        }else{
            return null;
        }
    }

    /**
     * 根据用户名获取密码
     * @param username
     * @return
     */
    public String getPasswordByUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()==1){
            return users.get(0).getName();
        }
        return "";
    }

    /**
     * TODO
     * @param username
     * @return
     */
    public Set<String> getRolesByUsername(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("general_user");
        return roles;
    }

    /**
     * TODO
     * @param role
     * @return
     */
    public Set<String> getPermissionsByRole(String role) {
        Set<String> permissions = new HashSet<>();
        permissions.add("list");
        permissions.add("edit");
        return permissions;
    }
}
